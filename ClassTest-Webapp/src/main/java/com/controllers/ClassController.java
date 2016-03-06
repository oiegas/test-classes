package com.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.converter.ClassConverter;
import com.converter.ClassConverterImplementation;
import com.domain.Clas;
import com.service.providers.ClassService;
import com.service.providers.ClassServiceImplementation;
import com.ui.domain.UIClass;

@Controller
@RequestMapping(value = "/class")
public class ClassController{
	
	ClassService classService=new ClassServiceImplementation();
	ClassConverter converter=new ClassConverterImplementation();

	
	@RequestMapping(method = RequestMethod.GET)
	public String listClasses(Model model) {
		UIClass ui=new UIClass();
		model.addAttribute("aClass",ui);
		List<UIClass> elist = transofrmList();
		model.addAttribute("listClasses",elist);
		return "class";
	}
	
	@RequestMapping("/remove/{id}")
	public String removeEmployee(@PathVariable("id") int code) {
		if (classService.getClassById(code) != null){
			Clas c=classService.getClassById(code);
			System.out.println("this is the class:"+c.getName());
			classService.deleteClass(c);
		}
		return "redirect:/class";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addEmployee(@ModelAttribute("aClass") UIClass ui) {
		
		Clas c =converter.createClass(ui);
		classService.addClass(c);
		return "redirect:/class";

	}


	
private List<UIClass> transofrmList(){
		List<Clas> pList = classService.getAllClasses();
		System.out.println(pList.size());
		List<UIClass> puiList = new ArrayList<UIClass>();
		for (Clas a : pList){
			puiList.add(converter.createUIClass(a));
		}
		return puiList;
		
	}

}
