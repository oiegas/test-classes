package com.services;

import com.domain.Question;

public interface QuestionDAOService {
	
	public Question addQuestion(Question question);
	public Question updateQuestion(Question question);
	public void deleteQuestion(Question question);

}
