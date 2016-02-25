package com.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.converter.TestConverter;
import com.converter.TestConverterImplementation;
import com.domain.Test;
import com.ui.domain.UITest;

@Controller
@RequestMapping(value = "/test")
public class TestController {
	
	TestConverter converter=new TestConverterImplementation();
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView choosePersons(){
		ModelAndView model = new ModelAndView();
		model.setViewName("test");
		return model;
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addPerson(@ModelAttribute("testAdd") UITest pui) {
		Test p = converter.createTest(pui);
		
		return "redirect:/test";

	}
}
