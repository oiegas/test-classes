package com.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.converter.UserConverter;
import com.converter.UserConverterImplementation;
import com.domain.Grade;
import com.domain.User;
import com.service.providers.GradesService;
import com.service.providers.GradesServiceImplementation;
import com.service.providers.TestService;
import com.service.providers.TestServiceImplementation;
import com.service.providers.UserService;
import com.service.providers.UserServiceImplementation;
import com.ui.domain.UIGrades;
import com.ui.domain.UIUser;

@Controller
@RequestMapping(value = "/studentStatistics")
public class StudentStatisticsController {
//studentSearch ca parametru
	
	
	UserService userService=new UserServiceImplementation();
	UserConverter userConverter=new UserConverterImplementation();
	GradesService gradeService=new GradesServiceImplementation();
	TestService testService=new TestServiceImplementation();
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
	
	@RequestMapping("/get/{userId}")
	public String getPerson(@PathVariable("userId") int id, Model model) {

		model.addAttribute("studentSearch", new UIUser());
		List<UIUser> studentsList = convertList(userService.getAllStudents());
		model.addAttribute("listStudents", studentsList);
		List<Grade> gradesOfStudent=gradeService.getGradesOfStudentWithId(id);
		List<UIGrades> gradesForUi=new ArrayList<UIGrades>();
		for(Grade g:gradesOfStudent){
			UIGrades uiGrade=new UIGrades();
			uiGrade.setGrade(g.getGrade());
			uiGrade.setTestName(testService.getTestById(g.getTest().getTestId()).getName());
			gradesForUi.add(uiGrade);
			System.out.println("NUMELE::"+testService.getTestById(g.getTest().getTestId()).getName());
		}
		model.addAttribute("listGrades", gradesForUi);
		return "studentStatistics";
	}
}
