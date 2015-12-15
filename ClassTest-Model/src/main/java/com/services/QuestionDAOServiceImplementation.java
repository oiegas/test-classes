package com.services;

import javax.persistence.EntityManager;

import com.domain.Question;
import com.repository.EntityManagerUtil;

public class QuestionDAOServiceImplementation implements QuestionDAOService{

private EntityManager entityM;
	
	public QuestionDAOServiceImplementation()
	{
		super();
		entityM = EntityManagerUtil.entityM;
	}
	public Question addQuestion(Question question) {
		entityM.getTransaction().begin();
		entityM.persist(question);
		entityM.getTransaction().commit();
		return question;
	}

	public Question updateQuestion(Question question) {
		entityM.getTransaction().begin();
		entityM.merge(question);
		entityM.getTransaction().commit();
		return question;
	}

	public void deleteQuestion(Question question) {
		entityM.getTransaction().begin();
		entityM.remove(question);
		entityM.getTransaction().commit();
	}
	public EntityManager getEntityManager() {
		return this.entityM;
	}

}
