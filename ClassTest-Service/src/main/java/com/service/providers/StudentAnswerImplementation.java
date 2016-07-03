package com.service.providers;

import java.util.List;

import com.domain.Question;
import com.domain.StudentAnswer;
import com.domain.User;
import com.services.StudentAnswerDAORemoveService;
import com.services.StudentAnswerDAOService;
import com.services.StudentAnswerDAOServiceImplementation;

public class StudentAnswerImplementation implements StudentAnswerService {
	StudentAnswerDAOService dao = new StudentAnswerDAOServiceImplementation();
	StudentAnswerDAOService removeDAO=new StudentAnswerDAORemoveService();

	public StudentAnswer addStudentAnswer(StudentAnswer answer) {
		return dao.addStudentAnswer(answer);
	}

	public StudentAnswer updateStudentAnswer(StudentAnswer answer) {
		return dao.updateStudentAnswer(answer);
	}

	public List<StudentAnswer> getAllAnswersOfStudent(int userId) {
		return dao.getAllAnswersOfStudent(userId);
	}

	public List<StudentAnswer> getAllAnswersOfQuestion(Question question) {
		return dao.getAllAnswersOfQuestion(question);
	}

	public void removeAnswer(StudentAnswer answer) {
		dao.removeAnswer(answer);
	}

	public List<StudentAnswer> getAllAnswersOfStudentAndTest(int studentId, int testId) {
		return dao.getAllAnswersOfStudentAndTest(studentId, testId);
	}

	@Override
	public List<StudentAnswer> getAllAnsweresOfQuestionsAndStudent(int questionId, int userId) {
		return dao.getAllAnsweresOfQuestionsAndStudent(questionId, userId);
	}

	@Override
	public List<StudentAnswer> getAllAnswersOfTest(int testId) {
		return dao.getAllAnswersOfTest(testId);
	}


}
