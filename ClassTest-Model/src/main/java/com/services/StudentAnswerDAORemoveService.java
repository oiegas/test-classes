package com.services;

import java.util.List;

import javax.persistence.EntityManager;

import com.domain.Question;
import com.domain.StudentAnswer;
import com.domain.User;
import com.repository.EntityManagerUtil;

public class StudentAnswerDAORemoveService implements StudentAnswerDAOService {
	private EntityManager entityM;

	public StudentAnswerDAORemoveService() {
		entityM = EntityManagerUtil.entityM;
	}

	@Override
	public StudentAnswer addStudentAnswer(StudentAnswer answer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StudentAnswer updateStudentAnswer(StudentAnswer answer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StudentAnswer> getAllAnswersOfStudent(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StudentAnswer> getAllAnswersOfQuestion(Question question) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StudentAnswer> getAllAnswersOfStudentAndTest(int studentId, int testId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeAnswer(StudentAnswer answer) {
		entityM.getTransaction().begin();
		entityM.remove(entityM.merge(answer));
		entityM.getTransaction().commit();

	}

	@Override
	public List<StudentAnswer> getAllAnswersOfTest(int testId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StudentAnswer> getAllAnsweresOfQuestionsAndStudent(int questionId, int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StudentAnswer> getAllOfClass(int classId) {
		// TODO Auto-generated method stub
		return null;
	}

}
