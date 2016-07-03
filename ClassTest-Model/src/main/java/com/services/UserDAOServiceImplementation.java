package com.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.domain.User;
import com.repository.EntityManagerUtil;

public class UserDAOServiceImplementation implements UserDAOService {

	private static final String STUDENTS_ACCOUNT = "ROLE_STUDENT";
	private static final String ADMIN_ACCOUNT = "ROLE_ADMIN";
	private EntityManager entityM;

	public UserDAOServiceImplementation() {

		entityM = EntityManagerUtil.entityM;

	}

	public User addUser(User user) {
		entityM.getTransaction().begin();
		entityM.persist(user);
		entityM.getTransaction().commit();
		return user;
	}

	public User searchUserByName(String username) {
		try {
			TypedQuery<User> query = entityM.createQuery("Select x from User x where x.username =:username",
					User.class);
			query.setParameter("username", username);
			if (query.getSingleResult() != null)
				return query.getSingleResult();
			else
				return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public User updateUser(User user) {
		entityM.getTransaction().begin();
		entityM.merge(user);
		entityM.getTransaction().commit();
		return user;
	}

	public void removeUser(User user) {
		entityM.getTransaction().begin();
		entityM.remove(user);
		entityM.getTransaction().commit();

	}

	public EntityManager getEntityManager() {
		return this.entityM;
	}

	public String getRole(String username) {
		User user = null;
		try {
			TypedQuery<User> query = entityM.createQuery("Select x from User x where x.username =:username",
					User.class);
			query.setParameter("username", username);
			user = query.getSingleResult();
			if (query.getSingleResult() != null)
				return user.getRole().getName();
			else
				return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean verifyLogin(String username, String password) {
		try {
			TypedQuery<User> query = entityM.createQuery(
					"Select x from User x where x.username =:username and x.password = :password", User.class);
			query.setParameter("username", username);
			query.setParameter("password", password);
			if (query.getSingleResult() != null)
				return true;
			else
				return false;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public User getUserById(int id) {
		try {
			TypedQuery<User> query = entityM.createQuery("Select x from User x where x.userId =:id", User.class);
			query.setParameter("id", id);
			if (query.getSingleResult() != null)
				return query.getSingleResult();
			else
				return null;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<User> getAllUsers() {
		try {
			TypedQuery<User> query = entityM.createQuery("Select x from User x", User.class);
			if (query.getResultList() != null)
				return query.getResultList();
			else
				return null;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<User> getAllStudents() {
		try {
			TypedQuery<User> query = entityM.createQuery("Select x from User x where x.role.name =:name", User.class);
			query.setParameter("name", STUDENTS_ACCOUNT);
			if (query.getResultList() != null)
				return query.getResultList();
			else
				return null;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<User> getUsersByName(String name) {
		try {
			TypedQuery<User> query = entityM.createQuery("Select x from User x where x.name=:name", User.class);
			query.setParameter("name", name);
			if (query.getResultList() != null)
				return query.getResultList();
			else
				return null;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<User> getUsersByClass(String clas) {
		try {
			TypedQuery<User> query = entityM.createQuery("Select x from User x where x.classForUser.name=:name",
					User.class);
			query.setParameter("name", clas);
			if (query.getResultList() != null)
				return query.getResultList();
			else
				return null;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public User getUserByUsername(String username) {
		try {
			TypedQuery<User> query = entityM.createQuery("Select x from User x where x.username =:username",
					User.class);
			query.setParameter("username", username);
			if (query.getSingleResult() != null)
				return query.getSingleResult();
			else
				return null;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public User getUserByEmail(String email) {
		try {
			TypedQuery<User> query = entityM.createQuery("Select x from User x where x.email =:email", User.class);
			query.setParameter("email", email);
			if (query.getSingleResult() != null)
				return query.getSingleResult();
			else
				return null;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<User> getAllProfesors() {
		try {
			TypedQuery<User> query = entityM.createQuery("Select x from User x where x.role.name =:name", User.class);
			query.setParameter("name", ADMIN_ACCOUNT);
			if (query.getResultList() != null)
				return query.getResultList();
			else
				return null;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
