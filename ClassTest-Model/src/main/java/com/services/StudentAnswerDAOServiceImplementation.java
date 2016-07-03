package com.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import com.domain.Question;
import com.domain.StudentAnswer;
import com.domain.User;
import com.repository.EntityManagerUtil;

public class StudentAnswerDAOServiceImplementation implements StudentAnswerDAOService {

	private EntityManagerFactory entityFactory;

	public StudentAnswerDAOServiceImplementation() {

		entityFactory = EntityManagerUtil.entityF;
	}

	public StudentAnswer addStudentAnswer(StudentAnswer answer) {
		EntityManager entityM = entityFactory.createEntityManager();
		entityM.getTransaction().begin();
		entityM.persist(answer);
		entityM.getTransaction().commit();
		entityM.close();
		return answer;
	}

	public StudentAnswer updateStudentAnswer(StudentAnswer answer) {
		EntityManager entityM = entityFactory.createEntityManager();
		entityM.getTransaction().begin();
		entityM.merge(answer);
		entityM.getTransaction().commit();
		entityM.close();
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
		EntityManager entityM = entityFactory.createEntityManager();
		StudentAnswer answerToBeRemoved = entityM.getReference(StudentAnswer.class, answer.getStudentAnswerId());
		entityM.getTransaction().begin();
		entityM.remove(answerToBeRemoved);
		entityM.getTransaction().commit();
		entityM.close();
	}

	public List<StudentAnswer> getAllAnswersOfStudentAndTest(int studentId, int testId) {
		EntityManager entityM = entityFactory.createEntityManager();
		try {
			TypedQuery<StudentAnswer> query = entityM.createQuery(
					"Select x from StudentAnswer x where x.user.userId=:userId and x.test.testId=:testId",
					StudentAnswer.class);
			query.setParameter("userId", studentId);
			query.setParameter("testId", testId);
			if (query.getResultList() != null)
				return query.getResultList();
			else
				return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			entityM.close();
		}

	}

	public List<StudentAnswer> getAllAnsweresOfQuestionsAndStudent(int questionId, int userId) {
		EntityManager entityM = entityFactory.createEntityManager();
		try {
			TypedQuery<StudentAnswer> query = entityM.createQuery(
					"Select x from StudentAnswer x where x.question.questionId=:questionId and x.user.userId=:userId",
					StudentAnswer.class);
			query.setParameter("questionId", questionId);
			query.setParameter("userId", userId);
			if (query.getResultList() != null)
				return query.getResultList();
			else
				return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			entityM.close();
		}

	}

	public List<StudentAnswer> getAllAnswersOfTest(int testId) {
		EntityManager entityM = entityFactory.createEntityManager();
		try {
			TypedQuery<StudentAnswer> query = entityM.createQuery(
					"Select x from StudentAnswer x where x.test.testId=:testId",
					StudentAnswer.class);
			query.setParameter("testId", testId);
			if (query.getResultList() != null)
				return query.getResultList();
			else
				return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			entityM.close();
		}

	}

	@Override
	public List<StudentAnswer> getAllOfClass(int classId) {
		return null;
	}

	@Override
	public List<StudentAnswer> getAllAnswersOfStudent(int userId) {
		EntityManager entityM = entityFactory.createEntityManager();
		try {
			TypedQuery<StudentAnswer> query = entityM.createQuery(
					"Select x from StudentAnswer x where x.user.userId=:userId",
					StudentAnswer.class);
			query.setParameter("userId", userId);
			if (query.getResultList() != null)
				return query.getResultList();
			else
				return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			entityM.close();
		}

	}

}
