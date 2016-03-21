package com.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.domain.Grade;
import com.repository.EntityManagerUtil;

public class GradesDAOServiceImplementation implements GradesDAOService{

private EntityManager entityM;
	
	public GradesDAOServiceImplementation()
	{
		super();
		entityM = EntityManagerUtil.entityM;
	}
	public Grade addGrade(Grade grade) {
		entityM.getTransaction().begin();
		entityM.persist(grade);
		entityM.getTransaction().commit();
		return grade;
	}

	public Grade updateGrade(Grade grade) {
		entityM.getTransaction().begin();
		entityM.merge(grade);
		entityM.getTransaction().commit();
		return grade;
	}

	public List<Grade> getGradesOfStudent(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public void removeGrade(Grade grade) {
		entityM.getTransaction().begin();
		entityM.remove(grade);
		entityM.getTransaction().commit();
		
	}

	public EntityManager getEntityManager() {
		return this.entityM;
	}
	public List<Grade> getGradesOfStudentWithId(int id) {
		try {
			TypedQuery <Grade> query = entityM.createQuery("Select x from Grade x where x.user.userId=:userId",Grade.class);
			query.setParameter("userId", id);	
			if (query.getResultList() != null) 
				return query.getResultList();
			else return null;
			

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
