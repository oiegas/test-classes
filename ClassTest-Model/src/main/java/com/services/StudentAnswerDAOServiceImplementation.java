package com.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.domain.Grade;
import com.domain.Question;
import com.domain.StudentAnswer;
import com.domain.User;
import com.repository.EntityManagerUtil;

public class StudentAnswerDAOServiceImplementation implements StudentAnswerDAOService{


	private EntityManager entityM;
	
	public StudentAnswerDAOServiceImplementation() {
	 
		
		entityM = EntityManagerUtil.entityM;
	}
	public StudentAnswer addStudentAnswer(StudentAnswer answer) {
		entityM.getTransaction().begin();
		entityM.persist(answer);
		entityM.getTransaction().commit();
		return answer;
	}

	public StudentAnswer updateStudentAnswer(StudentAnswer answer) {
		entityM.getTransaction().begin();
		entityM.merge(answer);
		entityM.getTransaction().commit();
		return answer;
	}

	public List<StudentAnswer> getAllAnswersOfStudent(User student) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<StudentAnswer> getAllAnswersOfQuestion(Question question) {
		// TODO Auto-generated method stub
		return null;
	}

	public void removeAnswer(StudentAnswer answer) {
		entityM.getTransaction().begin();
		entityM.remove(answer);
		entityM.getTransaction().commit();
		
	}
	public EntityManager getEntityManager() {
		return this.entityM;
	}
	public List<StudentAnswer> getAllAnswersOfStudentAndTest(int studentId,
			int testId) {
		try {
			TypedQuery <StudentAnswer> query = entityM.createQuery("Select x from StudentAnswer x where x.user.userId=:userId and x.test.testId=:testId",StudentAnswer.class);
			query.setParameter("userId", studentId);
			query.setParameter("testId", testId);
			if (query.getResultList() != null) 
				return query.getResultList();
			else return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
