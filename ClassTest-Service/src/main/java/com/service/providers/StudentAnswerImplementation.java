package com.service.providers;

import java.util.List;

import com.domain.Question;
import com.domain.StudentAnswer;
import com.domain.User;
import com.services.StudentAnswerDAOService;
import com.services.StudentAnswerDAOServiceImplementation;

public class StudentAnswerImplementation implements StudentAnswerService{
StudentAnswerDAOService dao=new StudentAnswerDAOServiceImplementation();
	public StudentAnswer addStudentAnswer(StudentAnswer answer) {
		return dao.addStudentAnswer(answer);
	}

	public StudentAnswer updateStudentAnswer(StudentAnswer answer) {
		return dao.updateStudentAnswer(answer);
	}

	public List<StudentAnswer> getAllAnswersOfStudent(User student) {
		return dao.getAllAnswersOfStudent(student);
	}

	public List<StudentAnswer> getAllAnswersOfQuestion(Question question) {
		return dao.getAllAnswersOfQuestion(question);
	}

	public void removeAnswer(StudentAnswer answer) {
dao.removeAnswer(answer);		
	}

}
