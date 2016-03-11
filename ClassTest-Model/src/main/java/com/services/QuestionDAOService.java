package com.services;

import java.util.List;

import com.domain.Question;

public interface QuestionDAOService {
	
	public Question addQuestion(Question question);
	public Question updateQuestion(Question question);
	public void deleteQuestion(Question question);
	public Question getQuestionById(int id);
	public List<Question> getQuestionByTestId(int testId);

}
