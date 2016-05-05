package com.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.converter.TestConverter;
import com.converter.TestConverterImplementation;
import com.domain.Grade;
import com.domain.StudentAnswer;
import com.domain.Test;
import com.service.providers.GradesService;
import com.service.providers.GradesServiceImplementation;
import com.service.providers.StudentAnswerImplementation;
import com.service.providers.StudentAnswerService;
import com.service.providers.TestService;
import com.service.providers.TestServiceImplementation;
import com.service.providers.UserService;
import com.service.providers.UserServiceImplementation;
import com.ui.domain.UITest;
import com.ui.domain.UITestGrade;
import com.utils.LoginUtils;

@Controller
@RequestMapping(value = "/testStatistics")
public class TestStatisticsController {

	private static String STUDENT_PRESENT = "Prezent";
	private static String STUDENT_ABSENT = "Absent";
	GradesService gradeService = new GradesServiceImplementation();
	TestService testService = new TestServiceImplementation();
	TestConverter converter = new TestConverterImplementation();
	UserService userService = new UserServiceImplementation();
	StudentAnswerService answerService = new StudentAnswerImplementation();

	@RequestMapping(method = RequestMethod.GET)
	public String listTest(Model model) {
		model.addAttribute("testSearch", new UITest());
		List<UITest> testList = transformList(testService.getTestsByUserId(LoginUtils.userLogedIn.getUserId()));
		model.addAttribute("listTests", testList);
		return "testStatistics";
	}

	@RequestMapping("/search")
	public String searchPerson(@ModelAttribute("testSearch") UITest test, Model model) {
		model.addAttribute("testSearch", new UITest());
		if (test.getName() != null && !test.getName().equals("")) {
			List<UITest> tests = transformList(testService.getTestByName(test.getName()));
			model.addAttribute("listTests", tests);
		} else {
			List<UITest> tests = transformList(testService.getTestsByUserId(LoginUtils.userLogedIn.getUserId()));
			model.addAttribute("listTests", tests);
		}
		return "testStatistics";

	}

	@RequestMapping("/get/{id}")
	public String getPerson(@PathVariable("id") int id, Model model) {
		model.addAttribute("testSearch", new UITest());
		List<UITest> testList = transformList(testService.getTestsByUserId(LoginUtils.userLogedIn.getUserId()));
		model.addAttribute("listTests", testList);
		List<Grade> grades = gradeService.getGradesWithTestId(id);
		List<UITestGrade> uiGrades = new ArrayList<UITestGrade>();
		for (Grade g : grades) {
			UITestGrade testGrade = new UITestGrade();
			testGrade.setGrade(g.getGrade());
			testGrade.setStudentName(g.getUser().getName());
			List<StudentAnswer> answers = null;
			answers = answerService.getAllAnswersOfStudentAndTest(id, g.getTest().getTestId());
			System.out.println(answers.size());
			if (answers.size() == 0)
				testGrade.setPresentOrNot(STUDENT_ABSENT);
			else
				testGrade.setPresentOrNot(STUDENT_PRESENT);
			uiGrades.add(testGrade);
		}
		model.addAttribute("listGrades", uiGrades);
		for (UITestGrade ui : uiGrades) {
			System.out.println(ui.getStudentName());
		}
		return "testStatistics";
	}

	public List<UITest> transformList(List<Test> list) {
		List<Test> tlist = list;
		List<UITest> uiList = new ArrayList<UITest>();
		for (Test t : tlist) {
			uiList.add(converter.createUITest(t));
		}
		return uiList;
	}
}
