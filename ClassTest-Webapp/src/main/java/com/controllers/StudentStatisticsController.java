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
import com.domain.StudentAnswer;
import com.domain.User;
import com.service.providers.GradesService;
import com.service.providers.GradesServiceImplementation;
import com.service.providers.StudentAnswerImplementation;
import com.service.providers.StudentAnswerService;
import com.service.providers.TestService;
import com.service.providers.TestServiceImplementation;
import com.service.providers.UserService;
import com.service.providers.UserServiceImplementation;
import com.ui.domain.UIGrades;
import com.ui.domain.UIUser;

@Controller
@RequestMapping(value = "/studentStatistics")
public class StudentStatisticsController {

	private static String STUDENT_PRESENT="Prezent";
	private static String STUDENT_ABSENT="Absent";
	UserService userService = new UserServiceImplementation();
	UserConverter userConverter = new UserConverterImplementation();
	GradesService gradeService = new GradesServiceImplementation();
	TestService testService = new TestServiceImplementation();
	StudentAnswerService answerService=new StudentAnswerImplementation();

	@RequestMapping(method = RequestMethod.GET)
	public String listTest(Model model) {
		model.addAttribute("studentSearch", new UIUser());

		List<UIUser> studentsList = convertList(userService.getAllStudents());
		model.addAttribute("listStudents", studentsList);
		return "studentStatistics";
	}

	private List<UIUser> convertList(List<User> users) {
		List<UIUser> uiUsers = new ArrayList<UIUser>();
		for (User u : users) {
			uiUsers.add(userConverter.createUIUser(u));
		}
		return uiUsers;
	}

	@RequestMapping("/search")
	public String searchPerson(@ModelAttribute("studentSearch") UIUser user,
			Model model) {
		model.addAttribute("studentSearch", new UIUser());
		if (user.getName() != null && !user.getName().equals("")) {
			List<UIUser> users = convertList(userService.getStudentsByName(user
					.getName()));
			model.addAttribute("listStudents", users);
		} else {
			List<UIUser> studentsList = convertList(userService
					.getAllStudents());
			model.addAttribute("listStudents", studentsList);
		}
		return "studentStatistics";

	}

	@RequestMapping("/get/{userId}")
	public String getPerson(@PathVariable("userId") int userId, Model model) {

		model.addAttribute("studentSearch", new UIUser());
		List<UIUser> studentsList = convertList(userService.getAllStudents());
		model.addAttribute("listStudents", studentsList);
		List<Grade> gradesOfStudent = gradeService.getGradesOfStudentWithId(userId);
		List<UIGrades> gradesForUi = new ArrayList<UIGrades>();
		for (Grade g : gradesOfStudent) {
			UIGrades uiGrade = new UIGrades();
			uiGrade.setGrade(g.getGrade());
			uiGrade.setTestName(testService
					.getTestById(g.getTest().getTestId()).getName());
			List<StudentAnswer> answers=null;
			answers=answerService.getAllAnswersOfStudentAndTest(userId, g.getTest().getTestId());
			System.out.println(answers.size());
			if(answers.size()==0)
				uiGrade.setPresent(STUDENT_ABSENT);
			else
				uiGrade.setPresent(STUDENT_PRESENT);
			gradesForUi.add(uiGrade);
			
		}
		model.addAttribute("listGrades", gradesForUi);
		return "studentStatistics";
	}
}
