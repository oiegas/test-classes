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
import com.domain.Answer;
import com.domain.Clas;
import com.domain.Grade;
import com.domain.Question;
import com.domain.StudentAnswer;
import com.domain.Test;
import com.domain.User;
import com.service.providers.AnswerService;
import com.service.providers.AnswerServiceImplementation;
import com.service.providers.ClassService;
import com.service.providers.ClassServiceImplementation;
import com.service.providers.GradesService;
import com.service.providers.GradesServiceImplementation;
import com.service.providers.QuestionService;
import com.service.providers.QuestionServiceImplementation;
import com.service.providers.StudentAnswerImplementation;
import com.service.providers.StudentAnswerService;
import com.service.providers.TestService;
import com.service.providers.TestServiceImplementation;
import com.service.providers.UserService;
import com.service.providers.UserServiceImplementation;
import com.ui.domain.UIClass;

@Controller
@RequestMapping(value = "/class")
public class ClassController {

	ClassService classService = new ClassServiceImplementation();
	TestService testService = new TestServiceImplementation();
	UserService userService = new UserServiceImplementation();
	ClassConverter converter = new ClassConverterImplementation();
	GradesService gradesService = new GradesServiceImplementation();
	StudentAnswerService studentAnswerService = new StudentAnswerImplementation();
	AnswerService answerService = new AnswerServiceImplementation();
	QuestionService questionService = new QuestionServiceImplementation();

	@RequestMapping(method = RequestMethod.GET)
	public String listClasses(Model model) {
		UIClass ui = new UIClass();
		model.addAttribute("aClass", ui);
		List<UIClass> elist = transofrmList();
		model.addAttribute("listClasses", elist);
		return "class";
	}

	@RequestMapping("/remove/{id}")
	public String removeClass(@PathVariable("id") int code) {
		if (classService.getClassById(code) != null) {
			Clas c = classService.getClassById(code);
			List<User> students = userService.getUsersByClass(c.getName());
			if (students != null) {
				for (User student : students) {
					List<Grade> grades = gradesService.getGradesOfStudentWithId(student.getUserId());
					if (grades != null) {
						for (Grade grade : grades) {
							gradesService.removeGrade(grade);
						}
					}
					List<StudentAnswer> studentAnswers = studentAnswerService.getAllAnswersOfStudent(student.getUserId());
					if (studentAnswers != null) {
						for (StudentAnswer answer : studentAnswers) {
							studentAnswerService.removeAnswer(answer);
						}
					}
					userService.removeUser(student);
				}
			}
			List<Test> tests = testService.getTestForClass(c.getClassId());
			if (tests != null) {
				for (Test test : tests) {
					List<Question> questions = questionService.getQuestionByTestId(test.getTestId());
					for (Question question : questions) {
						List<Answer> answers = answerService.getAnswersByQuestionId(question.getQuestionId());
						for (Answer answer : answers) {
							answerService.deleteAnswe(answer);
						}
						questionService.deleteQuestion(question);
					}
					testService.removeTest(test);
				}
			}
			classService.deleteClass(c);
		}
		return "redirect:/class";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addClass(@ModelAttribute("aClass") UIClass ui) {
		Clas c = converter.createClass(ui);
		classService.addClass(c);
		return "redirect:/class";

	}

	private List<UIClass> transofrmList() {
		List<Clas> pList = classService.getAllClasses();
		List<UIClass> puiList = new ArrayList<UIClass>();
		for (Clas a : pList) {
			puiList.add(converter.createUIClass(a));
		}
		return puiList;

	}

}
