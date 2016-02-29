package com.converter;

import com.domain.Question;
import com.service.providers.QuestionService;
import com.service.providers.QuestionServiceImplementation;
import com.service.providers.TestService;
import com.service.providers.TestServiceImplementation;
import com.ui.domain.UIQuestion;

public class QuestionConverterImplementation implements QuestionConverter{
	
	QuestionService service=new QuestionServiceImplementation();
	TestService testService=new TestServiceImplementation();

	public Question createQuestion(UIQuestion ui) {
		
		Question question=new Question();
		if(service.getQuestionById(ui.getQuestionId())!=null)
		question=service.getQuestionById(ui.getQuestionId());
		if(ui.getQuestion()!=null || !ui.getQuestion().equals(""))
			question.setQuestion(ui.getQuestion());
		if(ui.getTestId() !=0)
			question.setTest(testService.getTestById(ui.getTestId()));
		return question;
	}

	public UIQuestion createUIQuestion(Question question) {
		UIQuestion ui=new UIQuestion();
		if(!question.getQuestion().equals("")||question.getQuestion()!=null)
			ui.setQuestion(question.getQuestion());
		if(question.getQuestionId()!=0)
			ui.setQuestionId(question.getQuestionId());
		if(question.getTest()!=null)
			ui.setTestId(question.getTest().getTestId());
		return null;
	}

}
