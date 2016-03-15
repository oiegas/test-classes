package com.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.converter.UserConverter;
import com.converter.UserConverterImplementation;
import com.domain.User;
import com.service.providers.UserService;
import com.service.providers.UserServiceImplementation;
import com.ui.domain.UIUser;

@Controller
@RequestMapping(value = "/studentStatistics")
public class StudentStatisticsController {
//studentSearch ca parametru
	
	
	UserService userService=new UserServiceImplementation();
	UserConverter userConverter=new UserConverterImplementation();
	@RequestMapping(method = RequestMethod.GET)
	public String listTest(Model model) {
		model.addAttribute("studentSearch", new UIUser());

		List<UIUser> studentsList = convertList(userService.getAllStudents());
		model.addAttribute("listStudents", studentsList);
		return "studentStatistics";
	}
	
	private List<UIUser> convertList(List<User> users){
		List<UIUser> uiUsers=new ArrayList<UIUser>();
		for(User u:users){
			uiUsers.add(userConverter.createUIUser(u));
		}
		return uiUsers;	
	}
	
	@RequestMapping("/search")
	public String searchPerson(@ModelAttribute("studentSearch") UIUser user,
			Model model) {
		model.addAttribute("studentSearch", new UIUser());
		if (user.getName() != null && !user.getName().equals("")) {
			List<UIUser> users=convertList(userService.getStudentsByName(user.getName()));
			model.addAttribute("listStudents", users);
		} else {
			List<UIUser> studentsList = convertList(userService.getAllStudents());
			model.addAttribute("listStudents", studentsList);
		}
		return "studentStatistics";

	}
}
