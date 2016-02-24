package com.converter;

import com.domain.Answer;
import com.ui.domain.UIAnswer;

public class AnswerConverterImplementation implements AnswerConverter{

	public Answer createAnswer(UIAnswer ui) {
		Answer answer=new Answer();
		answer.setAnswer(ui.getAnswer());
		return null;
	}

	public UIAnswer createUIAnswer(Answer answer) {
		// TODO Auto-generated method stub
		return null;
	}

}
