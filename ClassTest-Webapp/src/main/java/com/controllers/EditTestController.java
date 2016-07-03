package com.controllers;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
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
import com.ui.domain.UIQuestionEdit;
import com.ui.domain.UITestEdit;

@Controller
@RequestMapping(value = "/editTest")
public class EditTestController {
	DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	TestService testService = new TestServiceImplementation();
	QuestionService questionService = new QuestionServiceImplementation();
	AnswerService answerService = new AnswerServiceImplementation();
	AnswerConverter answerConverter = new AnswerConverterImplementation();
	private static int testId;

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public String listTest(@PathVariable("id") int id, Model model) {
		testId = id;
		Test test = testService.getTestById(id);
		List<Question> questions = questionService.getQuestionByTestId(id);
		for (Question q : questions) {
			List<Answer> answers = answerService.getAnswersByQuestionId(q.getQuestionId());
			Set<Answer> ans = new LinkedHashSet<Answer>(answers);
			q.setAnswers(ans);
		}
		UITestEdit uiTest = new UITestEdit();
		uiTest.setName(test.getName());
		uiTest.setStartDate(formatter.format(test.getStartDate()));
		uiTest.setQuestions(convertQuestions(questions));
		uiTest.setTestId(test.getTestId());
		model.addAttribute("test", uiTest);
		return "editTest";

	}

	@RequestMapping(value = "edit", method = RequestMethod.POST)
	public String editTest(@ModelAttribute("test") UITestEdit uiTest) {
		Date date = null;
		Test test = testService.getTestById(testId);
		try {
			date = formatter.parse(uiTest.getStartDate());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if (date != null && !date.equals(test.getStartDate())) {
			test.setStartDate(date);
		}
		if (!uiTest.getName().equals(test.getName()))
			test.setName(uiTest.getName());
		testService.updateTest(test);
		List<Question> questions = questionService.getQuestionByTestId(testId);
		List<UIQuestionEdit> uiQuestions = uiTest.getQuestions();
		int i = 0;
		int j = 0;
		for (Question question : questions) {
			if (uiQuestions.get(i).getText().equals("") || uiQuestions.get(i).getText() == null) {
				List<Answer> dbAnswer = answerService.getAnswersByQuestionId(question.getQuestionId());
				for (Answer answer : dbAnswer) {
					answerService.deleteAnswe(answer);
				}
				questionService.deleteQuestion(question);
				i++;
			} else {
				if (!question.getQuestion().equals(uiQuestions.get(i).getText())) {
					question.setQuestion(uiQuestions.get(i).getText());
					questionService.updateQuestion(question);
				}
				List<Answer> answers = answerService.getAnswersByQuestionId(question.getQuestionId());
				List<UIAnswer> uiAnswers = uiQuestions.get(i).getAnswers();
				j = 0;
				for (Answer a : answers) {
					if (uiAnswers.get(j).getAnswer().equals("") || uiAnswers.get(j).getAnswer() == null) {
						answerService.deleteAnswe(a);
					} else {
						if (!a.getAnswer().equals(uiAnswers.get(j).getAnswer()))
							a.setAnswer(uiAnswers.get(j).getAnswer());
						if (a.isGood() != uiAnswers.get(j).isGood()) {
							a.setGood(uiAnswers.get(j).isGood());
							answerService.updateAnswer(a);
						}
						j++;
					}
				}
				i++;
			}
		}
		return "redirect:/test";
	}

	public List<UIQuestionEdit> convertQuestions(List<Question> question) {
		List<UIQuestionEdit> ui = new ArrayList<UIQuestionEdit>();
		for (Question q : question) {
			UIQuestionEdit uiq = new UIQuestionEdit();
			uiq.setText(q.getQuestion());
			List<UIAnswer> answers = new ArrayList<UIAnswer>();
			for (Answer a : q.getAnswers()) {
				answers.add(answerConverter.createUIAnswer(a));
			}
			uiq.setAnswers(answers);
			uiq.setQuestionId(q.getQuestionId());
			ui.add(uiq);
		}
		return ui;
	}

}
