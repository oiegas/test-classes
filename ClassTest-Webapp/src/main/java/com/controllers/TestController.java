package com.controllers;

import java.util.ArrayList;
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
import com.converter.QuestionConverter;
import com.converter.QuestionConverterImplementation;
import com.converter.TestConverter;
import com.converter.TestConverterImplementation;
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
import com.ui.domain.UIQuestion;
import com.ui.domain.UITest;

@Controller
@RequestMapping(value = "/test")
public class TestController {
	
	TestConverter converter=new TestConverterImplementation();
	QuestionConverter questionConverter=new QuestionConverterImplementation();
	AnswerConverter answerConverter= new AnswerConverterImplementation();
	TestService testService=new TestServiceImplementation();
	QuestionService questionService=new QuestionServiceImplementation();
	AnswerService answerService=new AnswerServiceImplementation();
	
	@RequestMapping(method = RequestMethod.GET)
	public String listTest(Model model){
		model.addAttribute("test",new UITest());
		model.addAttribute("testAdd",new UITest());
		model.addAttribute("firstQuestion",new UIQuestion());
		List<UITest> testList=transformList(testService.getAllTests());
		model.addAttribute("listTests", testList);
		return "test";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addPerson(@ModelAttribute("test") UITest pui) {
		Test test = converter.createTest(pui);
		testService.addTest(test);
		System.out.println(test.getTestId());
		
		UIAnswer uiAnswer;
		Answer answer;
		UIQuestion uiquestion=pui.getFirstQuestion();
		if(uiquestion!=null && !uiquestion.getQuestion().equals("")){
		Question firstQuestion=questionConverter.createQuestion(uiquestion);
		firstQuestion.setTest(test);
		questionService.addQuestion(firstQuestion);
		
		uiAnswer=pui.getFirstQuestion().getFirstAnswer();
		if(uiAnswer!=null && !uiAnswer.getAnswer().equals("")){
		answer=answerConverter.createAnswer(uiAnswer);
		answer.setQuestion(firstQuestion);
		answerService.addAnswer(answer);
		}
		
		uiAnswer=pui.getFirstQuestion().getSecondAnswer();
		if(uiAnswer!=null && !uiAnswer.getAnswer().equals("")){
		answer=answerConverter.createAnswer(uiAnswer);
		answer.setQuestion(firstQuestion);
		answerService.addAnswer(answer);
		}
		
		uiAnswer=pui.getFirstQuestion().getThirdAnswer();
		if(uiAnswer!=null && !uiAnswer.getAnswer().equals("")){
		answer=answerConverter.createAnswer(uiAnswer);
		answer.setQuestion(firstQuestion);
		answerService.addAnswer(answer);
		}
		
		uiAnswer=pui.getFirstQuestion().getFourthAnswer();
		if(uiAnswer!=null && !uiAnswer.getAnswer().equals("")){
		answer=answerConverter.createAnswer(uiAnswer);
		answer.setQuestion(firstQuestion);
		answerService.addAnswer(answer);
		}
		}
		
		
		
		uiquestion=pui.getSecondQuestion();
		if(uiquestion!=null && !uiquestion.getQuestion().equals("")){
		Question secondQuestion=questionConverter.createQuestion(uiquestion);
		secondQuestion.setTest(test);
		questionService.addQuestion(secondQuestion);
		
		uiAnswer=pui.getSecondQuestion().getFirstAnswer();
		if(uiAnswer!=null && !uiAnswer.getAnswer().equals("")){
		answer=answerConverter.createAnswer(uiAnswer);
		answer.setQuestion(secondQuestion);
		answerService.addAnswer(answer);
		}
		
		uiAnswer=pui.getSecondQuestion().getSecondAnswer();
		if(uiAnswer!=null && !uiAnswer.getAnswer().equals("")){
		answer=answerConverter.createAnswer(uiAnswer);
		answer.setQuestion(secondQuestion);
		answerService.addAnswer(answer);
		}
		
		uiAnswer=pui.getSecondQuestion().getThirdAnswer();
		if(uiAnswer!=null && !uiAnswer.getAnswer().equals("")){
		answer=answerConverter.createAnswer(uiAnswer);
		answer.setQuestion(secondQuestion);
		answerService.addAnswer(answer);
		}
		
		uiAnswer=pui.getSecondQuestion().getFourthAnswer();
		if(uiAnswer!=null && !uiAnswer.getAnswer().equals("")){
		answer=answerConverter.createAnswer(uiAnswer);
		answer.setQuestion(secondQuestion);
		answerService.addAnswer(answer);
		}
		}
		
		uiquestion=pui.getThirdQuestion();
		if(uiquestion!=null && !uiquestion.getQuestion().equals("")){
		Question thirdQuestion=questionConverter.createQuestion(uiquestion);
		thirdQuestion.setTest(test);
		questionService.addQuestion(thirdQuestion);
		
		uiAnswer=pui.getThirdQuestion().getFirstAnswer();
		if(uiAnswer!=null && !uiAnswer.getAnswer().equals("")){
		answer=answerConverter.createAnswer(uiAnswer);
		answer.setQuestion(thirdQuestion);
		answerService.addAnswer(answer);
		}
		
		uiAnswer=pui.getThirdQuestion().getSecondAnswer();
		if(uiAnswer!=null && !uiAnswer.getAnswer().equals("")){
		answer=answerConverter.createAnswer(uiAnswer);
		answer.setQuestion(thirdQuestion);
		answerService.addAnswer(answer);
		}
		
		
		uiAnswer=pui.getThirdQuestion().getThirdAnswer();
		if(uiAnswer!=null && !uiAnswer.getAnswer().equals("")){
		answer=answerConverter.createAnswer(uiAnswer);
		answer.setQuestion(thirdQuestion);
		answerService.addAnswer(answer);
		}
		
		uiAnswer=pui.getThirdQuestion().getFourthAnswer();
		if(uiAnswer!=null && !uiAnswer.getAnswer().equals("")){
		answer=answerConverter.createAnswer(uiAnswer);
		answer.setQuestion(thirdQuestion);
		answerService.addAnswer(answer);
		}
		}
		
		uiquestion=pui.getFourthQuestion();
		if(uiquestion!=null && !uiquestion.getQuestion().equals("")){
		Question fourthQuestion=questionConverter.createQuestion(uiquestion);
		fourthQuestion.setTest(test);
		questionService.addQuestion(fourthQuestion);
		
		uiAnswer=pui.getFourthQuestion().getFirstAnswer();
		if(uiAnswer!=null && !uiAnswer.getAnswer().equals("")){
		answer=answerConverter.createAnswer(uiAnswer);
		answer.setQuestion(fourthQuestion);
		answerService.addAnswer(answer);
		}
		
		uiAnswer=pui.getFourthQuestion().getSecondAnswer();
		if(uiAnswer!=null && !uiAnswer.getAnswer().equals("")){
		answer=answerConverter.createAnswer(uiAnswer);
		answer.setQuestion(fourthQuestion);
		answerService.addAnswer(answer);
		}
		
		uiAnswer=pui.getFourthQuestion().getThirdAnswer();
		if(uiAnswer!=null && !uiAnswer.getAnswer().equals("")){
		answer=answerConverter.createAnswer(uiAnswer);
		answer.setQuestion(fourthQuestion);
		answerService.addAnswer(answer);
		}
		
		uiAnswer=pui.getFourthQuestion().getFourthAnswer();
		if(uiAnswer!=null && !uiAnswer.getAnswer().equals("")){
		answer=answerConverter.createAnswer(uiAnswer);
		answer.setQuestion(fourthQuestion);
		answerService.addAnswer(answer);
		}
		}
		
		
		uiquestion=pui.getFifthQuestion();
		if(uiquestion!=null && !uiquestion.getQuestion().equals("")){
		Question fifthQuestion=questionConverter.createQuestion(uiquestion);
		fifthQuestion.setTest(test);
		questionService.addQuestion(fifthQuestion);
		
		uiAnswer=pui.getFifthQuestion().getFirstAnswer();
		if(uiAnswer!=null && !uiAnswer.getAnswer().equals("")){
		answer=answerConverter.createAnswer(uiAnswer);
		answer.setQuestion(fifthQuestion);
		answerService.addAnswer(answer);
		}
		
		uiAnswer=pui.getFifthQuestion().getSecondAnswer();
		if(uiAnswer!=null && !uiAnswer.getAnswer().equals("")){
		answer=answerConverter.createAnswer(uiAnswer);
		answer.setQuestion(fifthQuestion);
		answerService.addAnswer(answer);
		}
		
		uiAnswer=pui.getFifthQuestion().getThirdAnswer();
		if(uiAnswer!=null && !uiAnswer.getAnswer().equals("")){
		answer=answerConverter.createAnswer(uiAnswer);
		answer.setQuestion(fifthQuestion);
		answerService.addAnswer(answer);
		}
		
		uiAnswer=pui.getFifthQuestion().getFourthAnswer();
		if(uiAnswer!=null && !uiAnswer.getAnswer().equals("")){
		answer=answerConverter.createAnswer(uiAnswer);
		answer.setQuestion(fifthQuestion);
		answerService.addAnswer(answer);
		}
		}
		
		System.out.println(pui.getName());
		System.out.println(pui.getFirstQuestion().getQuestion());
		return "redirect:/test";

	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String editTest(@ModelAttribute("testEdit") UITest pui) {
		Test p =converter.createTest(pui);
		if (p.getTestId() == 0) {

			this.testService.addTest(p);
		} else {

			this.testService.updateTest(p);
		}
		return "redirect:/test";

	}
	
	@RequestMapping("/remove/{testId}")
	public String removeTest(@PathVariable("testId") int id) {
		Test test=testService.getTestById(id);
		System.out.println(test.getName());
		List<Answer> answers=new ArrayList<Answer>();
		List<Question> questions= null;
		questions=questionService.getQuestionByTestId(test.getTestId());
		System.out.println(questions.size());
		List<Answer> particularAnswers=null;
		if(questions!=null){
			for(Question q: questions){
				System.out.println(answerService.getAnswersByQuestionId(q.getQuestionId()).size());
				particularAnswers=answerService.getAnswersByQuestionId(q.getQuestionId());
				for(Answer a:particularAnswers){
					answers.add(a);
				}
			}
			for(Answer a:answers){
				answerService.deleteAnswe(a);
			}
			for(Question q : questions){
			questionService.deleteQuestion(q);
}
		}
		testService.removeTest(testService.getTestById(id));
		return "redirect:/test";
	}
	
	@RequestMapping("/search")
	public String searchPerson(@ModelAttribute("testAdd") UITest test, Model model) {
		model.addAttribute("testAdd", new UITest());
		if(test.getName()!=null && !test.getName().equals("")){
			List<UITest> tests=transformList(testService.getTestByName(test.getName()));
			model.addAttribute("listTests", tests);
		}
		else{
			List<UITest> tests=transformList(testService.getAllTests());
			model.addAttribute("listTests", tests);
		}
		return "test";

	}
	
	@RequestMapping("/get/{testId}")
	public String getPerson(@PathVariable("testId") int id, Model model) {

		model.addAttribute("test",new UITest());
		model.addAttribute("testAdd",new UITest());
		model.addAttribute("firstQuestion",new UIQuestion());
		List<UITest> testList=transformList(testService.getAllTests());
		model.addAttribute("listTests", testList);
		UITest test=converter.createUITest(testService.getTestById(id));
		model.addAttribute("testB", test);
	
		return "test";
	}
	
	@RequestMapping("/edit/{testId}")
	public String editPerson(@PathVariable("testId") int id, Model model) {
		model.addAttribute("test",new UITest());
		model.addAttribute("testAdd",new UITest());
		UITest test = converter.createUITest(testService.getTestById(id));
		model.addAttribute("testEdit", test);
		List<UITest> puiList = transformList(testService.getAllTests());
		model.addAttribute("listTests", puiList);
		return "test";
	}
	
	public List<UITest> transformList(List<Test> list)
	{
		List<Test> tlist= list;
		List<UITest> uiList=new ArrayList<UITest>();
		for(Test t: tlist){
			uiList.add(converter.createUITest(t));
		}
		return uiList;
	}
}
