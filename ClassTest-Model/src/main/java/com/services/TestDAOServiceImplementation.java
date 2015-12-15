package com.services;

import javax.persistence.EntityManager;

import com.domain.Test;
import com.repository.EntityManagerUtil;

public class TestDAOServiceImplementation implements TestDAOService{
	private EntityManager entityM;

	public TestDAOServiceImplementation() {

		entityM = EntityManagerUtil.entityM;

	}
	public Test addTest(Test test) {
		entityM.getTransaction().begin();
		entityM.persist(test);
		entityM.getTransaction().commit();
		return test;
	}

	public Test updateTest(Test test) {
		entityM.getTransaction().begin();
		entityM.merge(test);
		entityM.getTransaction().commit();
		return test;
	}

	public void removeTest(Test test) {
		entityM.getTransaction().begin();
		entityM.remove(test);
		entityM.getTransaction().commit();
		
	}
	public EntityManager getEntityManager() {
		return this.entityM;
	}
}
