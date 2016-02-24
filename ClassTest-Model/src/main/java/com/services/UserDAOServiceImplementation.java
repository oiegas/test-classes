package com.services;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.domain.User;
import com.repository.EntityManagerUtil;

public class UserDAOServiceImplementation implements UserDAOService{

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

	public User searchUserByName(String name) {
		// TODO Auto-generated method stub
		return null;
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
		User user=null;
		try {
			TypedQuery <User> query = entityM.createQuery("Select x from User x where x.username =:username",User.class);
			query.setParameter("username", username);
			user=query.getSingleResult();
			if (query.getSingleResult() != null) 
				return user.getRole().getName();
			else return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public boolean verifyLogin(String username, String password) {
		try {
			TypedQuery <User> query = entityM.createQuery("Select x from User x where x.username =:username and x.password = :password",User.class);
			query.setParameter("username", username);	
			query.setParameter("password", password);	
			if (query.getSingleResult() != null) return true;
			else return false;
			

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
