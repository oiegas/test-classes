package com.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.converter.QuestionConverter;
import com.converter.QuestionConverterImplementation;
import com.converter.TestConverter;
import com.converter.TestConverterImplementation;
import com.domain.Question;
import com.domain.Test;
import com.ui.domain.UIQuestion;
import com.ui.domain.UITest;

@Controller
@RequestMapping(value = "/test")
public class TestController {
	
	TestConverter converter=new TestConverterImplementation();
	QuestionConverter questionConverter=new QuestionConverterImplementation();
	
	@RequestMapping(method = RequestMethod.GET)
	public String listTest(Model model){
		model.addAttribute("testAdd",new UITest());
		return "test";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addPerson(@ModelAttribute("test") UITest pui, @ModelAttribute("firstQuestion") UIQuestion question) {
		Test p = converter.createTest(pui);
		Question q=questionConverter.createQuestion(question);
		
		return "redirect:/test";

	}

	@RequestMapping("/search")
	public String searchPerson(@ModelAttribute("testAdd") UITest person, Model model) {
		model.addAttribute("testAdd", new UITest());
		
		return "test";

	}
}
