package com.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.domain.Answer;
import com.repository.EntityManagerUtil;

public class AnswerDAOServiceImplementation implements AnswerDAOService{
	private EntityManager entityM;
	public AnswerDAOServiceImplementation()
	{
		entityM = EntityManagerUtil.entityM;
	}
	public Answer addAnswer(Answer answer) {
	
		entityM.getTransaction().begin();
		entityM.persist(answer);
		entityM.getTransaction().commit();
		return answer;
	}

	public void deleteAnswe(Answer answer) {
		entityM.getTransaction().begin();
		entityM.remove(entityM.merge(answer));
		entityM.flush();
		entityM.getTransaction().commit();
		
	}

	public Answer updateAnswer(Answer answer) {
		entityM.getTransaction().begin();
		entityM.merge(answer);
		entityM.getTransaction().commit();
		return answer;
	}

	public EntityManager getEntityManager() {
		return this.entityM;
	}
	public Answer getAnswerById(int id) {
		try {
			TypedQuery <Answer> answer = entityM.createQuery("Select x from Answer x where x.answerId =:id",Answer.class);
			answer.setParameter("id", id);	
			if (answer.getSingleResult() != null) 
				return answer.getSingleResult();
			else 
				return null;
			

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public List<Answer> getAnswersByQuestionId(int questionId) {
		try {
			TypedQuery <Answer> answer = entityM.createQuery("Select x from Answer x where x.question.questionId =:questionId",Answer.class);
			answer.setParameter("questionId",questionId);	
			if (answer.getResultList() != null) 
				return answer.getResultList();
			else 
				return null;
			

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
