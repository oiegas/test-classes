package com.services;

import java.util.List;

import com.domain.Question;
import com.domain.StudentAnswer;

public interface StudentAnswerDAOService {

	public StudentAnswer addStudentAnswer(StudentAnswer answer);
	public StudentAnswer updateStudentAnswer(StudentAnswer answer);
	public List<StudentAnswer> getAllAnswersOfStudent(int userId);
	public List<StudentAnswer> getAllAnswersOfQuestion(Question question);
	public List<StudentAnswer> getAllAnswersOfStudentAndTest(int studentId, int testId);
	public void removeAnswer(StudentAnswer answer);
	public List<StudentAnswer> getAllAnswersOfTest(int testId);
	public List<StudentAnswer> getAllAnsweresOfQuestionsAndStudent(int questionId, int userId);
	public List<StudentAnswer> getAllOfClass(int classId);
}
