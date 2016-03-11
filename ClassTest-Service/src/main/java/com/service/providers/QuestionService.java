package com.service.providers;

import java.util.List;

import com.domain.Question;

public interface QuestionService {
	public Question addQuestion(Question question);
	public Question updateQuestion(Question question);
	public void deleteQuestion(Question question);
	public Question getQuestionById(int id);
	public List<Question> getQuestionByTestId(int id);
}
