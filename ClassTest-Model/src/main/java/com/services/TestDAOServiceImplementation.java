package com.services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

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
	public Test getTestById(int id) {
		try {
			TypedQuery <Test> query = entityM.createQuery("Select x from Test x where x.testId=:test_id",Test.class);
			query.setParameter("test_id", id);	
			if (query.getSingleResult() != null) 
				return query.getSingleResult();
			else return null;
			

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public List<Test> getAllTests() {
		List<Test> allTests=new ArrayList<Test>();
		try{
			allTests=entityM.createQuery("Select x from Test x",Test.class).getResultList();
			return allTests;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	public List<Test> getTestsByName(String name) {
		List<Test> test=new ArrayList<Test>();
		test=entityM.createQuery("Select x from Test x where x.name='"+name+"'", Test.class).getResultList();
		return test;
	}
	public List<Test> getTestsByUserId(int id) {
		List<Test> test=new ArrayList<Test>();
		test=entityM.createQuery("Select x from Test x where x.userCreator.userId='"+id+"'", Test.class).getResultList();
		return test;
	}
}
