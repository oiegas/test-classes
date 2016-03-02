package com.services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.domain.Clas;
import com.repository.EntityManagerUtil;

public class ClassDAOServiceImplementation implements ClassDAOService{

	private EntityManager entityM;
	
	public ClassDAOServiceImplementation(){
		entityM=EntityManagerUtil.entityM;
	}
	public Clas addClass(Clas c) {
		entityM.getTransaction().begin();
		entityM.persist(c);
		entityM.getTransaction().commit();
		return c;
	}

	public void deleteClass(Clas c) {
		entityM.getTransaction().begin();
		entityM.remove(c);
		entityM.getTransaction().commit();
	}

	public Clas updateClass(Clas c) {
		entityM.getTransaction().begin();
		entityM.merge(c);
		entityM.getTransaction().commit();
		return c;
	}

	public Clas getClassById(int id) {
		try {
			TypedQuery <Clas> query = entityM.createQuery("Select x from Clas x where x.class_id=:class_id",Clas.class);
			query.setParameter("class_id", id);	
			if (query.getSingleResult() != null) 
				return query.getSingleResult();
			else return null;
			

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	/*public List<Clas> getAllClasses() {
		List<Clas> classes = new ArrayList<Clas>();
		try{
			classes=entityM.createQuery("SELECT x FROM Class x",Clas.class).getResultList();
			return classes;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}*/
	public List<Clas> getAllClasses() {

		List<Clas> employees = new ArrayList<Clas>();
		try {
			employees = entityM.createQuery("SELECT x FROM Clas x",Clas.class).getResultList();
			return employees;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public EntityManager getEntityManager() {
		return this.entityM;
	}

}