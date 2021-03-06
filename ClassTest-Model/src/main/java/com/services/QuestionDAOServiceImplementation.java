package com.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.domain.Question;
import com.domain.Test;
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
		entityM.remove(entityM.merge(question));
		entityM.getTransaction().commit();
	}
	public EntityManager getEntityManager() {
		return this.entityM;
	}
	public Question getQuestionById(int id) {
		entityM.clear();
		try {
			TypedQuery <Question> question = entityM.createQuery("Select x from Question x where x.questionId=:question_id",Question.class);
			question.setParameter("question_id", id);	
			if (question.getSingleResult() != null) 
				return question.getSingleResult();
			else 
				return null;
			

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public List<Question> getQuestionByTestId(int testId) {
		try {
			TypedQuery <Question> question = entityM.createQuery("Select x from Question x where x.test.testId=:test",Question.class);
			question.setParameter("test", testId);	
			if (question.getResultList() != null) 
				return question.getResultList();
			else 
				return null;
			

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
