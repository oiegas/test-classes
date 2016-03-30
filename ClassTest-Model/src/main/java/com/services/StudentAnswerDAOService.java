package com.services;

import java.util.List;

import com.domain.Question;
import com.domain.StudentAnswer;
import com.domain.User;

public interface StudentAnswerDAOService {

	public StudentAnswer addStudentAnswer(StudentAnswer answer);
	public StudentAnswer updateStudentAnswer(StudentAnswer answer);
	public List<StudentAnswer> getAllAnswersOfStudent(User student);
	public List<StudentAnswer> getAllAnswersOfQuestion(Question question);
	public List<StudentAnswer> getAllAnswersOfStudentAndTest(int studentId, int testId);
	public void removeAnswer(StudentAnswer answer);
}
