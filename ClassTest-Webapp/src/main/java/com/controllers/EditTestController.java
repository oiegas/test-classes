package com.controllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.converter.AnswerConverter;
import com.converter.AnswerConverterImplementation;
import com.domain.Answer;
import com.domain.Question;
import com.domain.Test;
import com.service.providers.AnswerService;
import com.service.providers.AnswerServiceImplementation;
import com.service.providers.QuestionService;
import com.service.providers.QuestionServiceImplementation;
import com.service.providers.TestService;
import com.service.providers.TestServiceImplementation;
import com.ui.domain.UIAnswer;
import com.ui.domain.UIQuestion2;
import com.ui.domain.UITest2;

@Controller
@RequestMapping(value = "/editTest")
public class EditTestController {
	DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	TestService testService=new TestServiceImplementation();
	QuestionService questionService=new QuestionServiceImplementation();
	AnswerService answerService=new AnswerServiceImplementation();
	AnswerConverter answerConverter=new AnswerConverterImplementation();
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String listPersons(@PathVariable("id") int id, Model model) {

		Test test=testService.getTestById(id);
		List<Question> questions=questionService.getQuestionByTestId(id);
		for(Question q:questions){
			List<Answer> answers=answerService.getAnswersByQuestionId(q.getQuestionId());
			Set<Answer> ans=new HashSet<Answer>(answers);
			q.setAnswers(ans);
		}
		UITest2 uiTest=new UITest2();
		uiTest.setName(test.getName());
		uiTest.setEndDate(formatter.format(test.getEndDate()));
		uiTest.setStartDate(formatter.format(test.getStartDate()));
		uiTest.setQuestions(convertQuestions(questions));
		uiTest.setTestId(test.getTestId());
		System.out.println("Intrebari"+questions.size());
		model.addAttribute("test", uiTest);
		return "editTest";
		
	}
	
	public List<UIQuestion2> convertQuestions(List<Question> question){
		
		List<UIQuestion2> ui=new ArrayList<UIQuestion2>();
		
		for(Question q:question){
			UIQuestion2 uiq=new UIQuestion2();
			uiq.setText(q.getQuestion());
			List<UIAnswer> answers=new ArrayList<UIAnswer>();
			for(Answer a:q.getAnswers()){
				answers.add(answerConverter.createUIAnswer(a));
			}
			uiq.setAnswers(answers);
			uiq.setQuestionId(q.getQuestionId());
			ui.add(uiq);
		}
		return ui;
	}
	
}
