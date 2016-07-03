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
import com.domain.Answer;
import com.domain.Grade;
import com.domain.Question;
import com.domain.Role;
import com.domain.StudentAnswer;
import com.domain.Test;
import com.domain.User;
import com.service.providers.AnswerService;
import com.service.providers.AnswerServiceImplementation;
import com.service.providers.GradesService;
import com.service.providers.GradesServiceImplementation;
import com.service.providers.QuestionService;
import com.service.providers.QuestionServiceImplementation;
import com.service.providers.RoleService;
import com.service.providers.RoleServiceImplementation;
import com.service.providers.StudentAnswerImplementation;
import com.service.providers.StudentAnswerService;
import com.service.providers.TestService;
import com.service.providers.TestServiceImplementation;
import com.service.providers.UserService;
import com.service.providers.UserServiceImplementation;
import com.ui.domain.UIUser;

@Controller
@RequestMapping(value = "/user")
public class UserController {

	UserService service = new UserServiceImplementation();
	UserConverter converter = new UserConverterImplementation();
	RoleService roleService = new RoleServiceImplementation();
	TestService testService = new TestServiceImplementation();
	QuestionService questionService = new QuestionServiceImplementation();
	AnswerService answerService = new AnswerServiceImplementation();
	StudentAnswerService studentAnswerService = new StudentAnswerImplementation();
	GradesService gradesService = new GradesServiceImplementation();

	private List<UIUser> transofrmList() {
		List<User> pList = service.getAllProfesors();
		List<UIUser> puiList = new ArrayList<UIUser>();
		for (User a : pList) {
			puiList.add(converter.createUIUser(a));
		}
		return puiList;

	}

	@RequestMapping(method = RequestMethod.GET)
	public String listClasses(Model model) {
		UIUser ui = new UIUser();
		model.addAttribute("user", ui);
		List<UIUser> elist = transofrmList();
		model.addAttribute("listUsers", elist);
		return "user";
	}

	@RequestMapping("/remove/{id}")
	public String removeUser(@PathVariable("id") int id) {
		if (service.getUserById(id) != null) {
			User u = service.getUserById(id);
			List<Test> tests = testService.getTestsByUserId(id);
			if (tests != null) {
				for (Test test : tests) {
					List<Question> questions = questionService.getQuestionByTestId(test.getTestId());
					List<Answer> particularAnswers = null;
					List<StudentAnswer> studentAnswers = studentAnswerService.getAllAnswersOfTest(id);
					for (StudentAnswer answer : studentAnswers) {
						studentAnswerService.removeAnswer(answer);
					}
					if (questions != null) {
						for (Question q : questions) {
							particularAnswers = answerService.getAnswersByQuestionId(q.getQuestionId());
							for (Answer a : particularAnswers) {
								answerService.deleteAnswe(a);
							}
							questionService.deleteQuestion(q);
						}
					}

					List<Grade> gradesToRemove = gradesService.getGradesWithTestId(test.getTestId());
					for (Grade g : gradesToRemove) {
						gradesService.removeGrade(g);
					}
					testService.removeTest(test);
				}
			}

			service.removeUser(u);
		}
		return "redirect:/user";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addEmployee(@ModelAttribute("user") UIUser ui) {
		User u = converter.createUser(ui);
		if (service.getUserByUsername(u.getUsername()) != null)
			System.out.println("The user exists!");
		else {
			Role r = roleService.getRoleById(1);
			u.setRole(r);
			service.addUser(u);
		}
		return "redirect:/user";

	}
}
