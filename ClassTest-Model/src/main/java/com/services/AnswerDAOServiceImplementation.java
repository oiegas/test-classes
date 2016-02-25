package com.services;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.domain.Answer;
import com.domain.Question;
import com.repository.EntityManagerUtil;

public class AnswerDAOServiceImplementation implements AnswerDAOService{

	private EntityManager entityM;
	public AnswerDAOServiceImplementation()
	{
		super();
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
		entityM.remove(answer);
		entityM.getTransaction().commit();
		
	}

	public Answer updateAnswer(Answer answer) {
		entityM.getTransaction().begin();
		entityM.merge(answer);
		entityM.getTransaction().commit();
		return answer;
	}

	public EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return this.entityM;
	}
	public Answer getAnswerById(int id) {
		try {
			TypedQuery <Answer> answer = entityM.createQuery("Select x from Answer x where x.answer_id =:answer_id",Answer.class);
			answer.setParameter("answer_id", id);	
			if (answer.getSingleResult() != null) 
				return answer.getSingleResult();
			else 
				return null;
			

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
