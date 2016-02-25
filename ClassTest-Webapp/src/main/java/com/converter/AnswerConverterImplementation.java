package com.converter;

import com.domain.Answer;
import com.service.providers.AnswerService;
import com.service.providers.AnswerServiceImplementation;
import com.ui.domain.UIAnswer;

public class AnswerConverterImplementation implements AnswerConverter{

	AnswerService service=new AnswerServiceImplementation();
	public Answer createAnswer(UIAnswer ui) {
		Answer answer=new Answer();
		answer=service.getAnswerById(ui.getAnswerId());
		if(!ui.getAnswer().equals("")||ui.getAnswer()!=null)
		answer.setAnswer(ui.getAnswer());
		
		return answer;
	}

	public UIAnswer createUIAnswer(Answer answer) {
		UIAnswer ui=new UIAnswer();
		if(!answer.getAnswer().equals("")||answer.getAnswer()!=null)
			ui.setAnswer(answer.getAnswer());
		if(answer.getAnswerId()!=0)
			ui.setAnswerId(answer.getAnswerId());
		return ui;
	}

}