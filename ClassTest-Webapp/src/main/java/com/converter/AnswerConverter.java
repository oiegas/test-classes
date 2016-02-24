package com.converter;

import com.domain.Answer;
import com.ui.domain.UIAnswer;

public interface AnswerConverter {
	
	public Answer createAnswer(UIAnswer ui);
	public UIAnswer createUIAnswer(Answer answer);
}
