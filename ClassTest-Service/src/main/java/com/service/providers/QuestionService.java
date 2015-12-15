package com.service.providers;

import com.domain.Question;

public interface QuestionService {
	public Question addQuestion(Question question);
	public Question updateQuestion(Question question);
	public void deleteQuestion(Question question);
}
