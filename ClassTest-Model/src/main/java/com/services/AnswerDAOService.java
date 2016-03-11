package com.services;


import java.util.List;

import com.domain.Answer;

public interface AnswerDAOService {

	public Answer addAnswer(Answer answer);
	public void deleteAnswe(Answer answer);
	public Answer updateAnswer(Answer answer);
	public Answer getAnswerById(int id);
	public List<Answer> getAnswersByQuestionId(int questionId);
}
