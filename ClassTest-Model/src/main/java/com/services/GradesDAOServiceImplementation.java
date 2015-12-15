package com.services;

import java.util.List;

import javax.persistence.EntityManager;

import com.domain.Grades;
import com.repository.EntityManagerUtil;

public class GradesDAOServiceImplementation implements GradesDAOService{

private EntityManager entityM;
	
	public GradesDAOServiceImplementation()
	{
		super();
		entityM = EntityManagerUtil.entityM;
	}
	public Grades addGrade(Grades grade) {
		entityM.getTransaction().begin();
		entityM.persist(grade);
		entityM.getTransaction().commit();
		return grade;
	}

	public Grades updateGrade(Grades grade) {
		entityM.getTransaction().begin();
		entityM.merge(grade);
		entityM.getTransaction().commit();
		return grade;
	}

	public List<Grades> getGradesOfStudent(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public void removeGrade(Grades grade) {
		entityM.getTransaction().begin();
		entityM.remove(grade);
		entityM.getTransaction().commit();
		
	}

	public EntityManager getEntityManager() {
		return this.entityM;
	}

}
