package com.service.providers;

import com.domain.Answer;

public interface AnswerService {

	public Answer addAnswer(Answer answer);
	public void deleteAnswe(Answer answer);
	public Answer updateAnswer(Answer answer);
	public Answer getAnswerById(int id);
}
