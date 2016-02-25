package com.service.providers;

import java.util.List;

import com.domain.Question;
import com.domain.StudentAnswer;
import com.domain.User;

public interface StudentAnswerService {
	public StudentAnswer addStudentAnswer(StudentAnswer answer);
	public StudentAnswer updateStudentAnswer(StudentAnswer answer);
	public List<StudentAnswer> getAllAnswersOfStudent(User student);
	public List<StudentAnswer> getAllAnswersOfQuestion(Question question);
	public void removeAnswer(StudentAnswer answer);
}