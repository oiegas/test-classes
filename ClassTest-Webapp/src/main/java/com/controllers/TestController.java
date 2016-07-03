package com.controllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.apache.http.util.TextUtils;
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
import com.ui.domain.UIAnswer;
import com.ui.domain.UIQuestion;
import com.ui.domain.UIQuestionEdit;
import com.ui.domain.UITest;
import com.ui.domain.UITestEdit;
import com.utils.LoginUtils;

@Controller
@RequestMapping(value = "/test")
public class TestController {

	DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	TestConverter converter = new TestConverterImplementation();
	QuestionConverter questionConverter = new QuestionConverterImplementation();
	AnswerConverter answerConverter = new AnswerConverterImplementation();
	TestService testService = new TestServiceImplementation();
	QuestionService questionService = new QuestionServiceImplementation();
	AnswerService answerService = new AnswerServiceImplementation();
	ClassService classService = new ClassServiceImplementation();
	GradesService gradesService = new GradesServiceImplementation();
	UserService userService = new UserServiceImplementation();
	StudentAnswerService studentAnswerService = new StudentAnswerImplementation();

	@RequestMapping(method = RequestMethod.GET)
	public String listTest(Model model) {
		model.addAttribute("test", new UITest());
		model.addAttribute("testClone", new UITest());
		model.addAttribute("testAdd", new UITest());
		model.addAttribute("questionAdd", new UIQuestion());
		model.addAttribute("firstQuestion", new UIQuestion());
		List<Clas> classList = classService.getAllClasses();
		ArrayList<String> allClasses = new ArrayList<String>();
		for (Clas c : classList) {
			allClasses.add(c.getName());
		}
		model.addAttribute("classList", allClasses);
		List<UITest> testList = transformList(testService.getTestsByUserId(LoginUtils.userLogedIn.getUserId()));
		model.addAttribute("listTests", testList);
		return "test";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addPerson(@ModelAttribute("test") UITest pui) {
		Test test = converter.createTest(pui);
		if (test.getStartDate() == null)
			return "redirect:/test";
		test.setAvailable(false);
		test.setOpened(true);
		test.setUserCreator(LoginUtils.getUserLogedIn());
		Clas clasForTest = classService.getClassByName(pui.getNameClass());
		test.setClassForTest(clasForTest);
		if (pui.getName() != null && !pui.getName().equals("")) {
			testService.addTest(test);
			UIAnswer uiAnswer;
			boolean ok = false;
			Answer answer;
			UIQuestion uiquestion = pui.getFirstQuestion();
			if (uiquestion != null && !uiquestion.getQuestion().equals("")) {
				ok = true;
				Question firstQuestion = questionConverter.createQuestion(uiquestion);
				firstQuestion.setTest(test);
				firstQuestion.setAvailable(false);
				questionService.addQuestion(firstQuestion);
				uiAnswer = pui.getFirstQuestion().getFirstAnswer();
				boolean questionDelete = false;
				if (uiAnswer != null && !uiAnswer.getAnswer().equals("")) {
					questionDelete = true;
					answer = answerConverter.createAnswer(uiAnswer);
					answer.setQuestion(firstQuestion);
					answerService.addAnswer(answer);
				}

				uiAnswer = pui.getFirstQuestion().getSecondAnswer();
				if (uiAnswer != null && !uiAnswer.getAnswer().equals("")) {
					questionDelete = true;
					answer = answerConverter.createAnswer(uiAnswer);
					answer.setQuestion(firstQuestion);
					answerService.addAnswer(answer);
				}

				uiAnswer = pui.getFirstQuestion().getThirdAnswer();
				if (uiAnswer != null && !uiAnswer.getAnswer().equals("")) {
					questionDelete = true;
					answer = answerConverter.createAnswer(uiAnswer);
					answer.setQuestion(firstQuestion);
					answerService.addAnswer(answer);
				}

				uiAnswer = pui.getFirstQuestion().getFourthAnswer();
				if (uiAnswer != null && !uiAnswer.getAnswer().equals("")) {
					questionDelete = true;
					answer = answerConverter.createAnswer(uiAnswer);
					answer.setQuestion(firstQuestion);
					answerService.addAnswer(answer);
				}
				if (questionDelete == false) {
					ok = false;
					questionService.deleteQuestion(firstQuestion);
				}
			}

			uiquestion = pui.getSecondQuestion();
			if (uiquestion != null && !uiquestion.getQuestion().equals("")) {
				ok = true;
				Question secondQuestion = questionConverter.createQuestion(uiquestion);
				secondQuestion.setTest(test);
				secondQuestion.setAvailable(false);
				questionService.addQuestion(secondQuestion);
				boolean questionDelete = false;
				uiAnswer = pui.getSecondQuestion().getFirstAnswer();
				if (uiAnswer != null && !uiAnswer.getAnswer().equals("")) {
					questionDelete = true;
					answer = answerConverter.createAnswer(uiAnswer);
					answer.setQuestion(secondQuestion);
					answerService.addAnswer(answer);
				}

				uiAnswer = pui.getSecondQuestion().getSecondAnswer();
				if (uiAnswer != null && !uiAnswer.getAnswer().equals("")) {
					questionDelete = true;
					answer = answerConverter.createAnswer(uiAnswer);
					answer.setQuestion(secondQuestion);
					answerService.addAnswer(answer);
				}

				uiAnswer = pui.getSecondQuestion().getThirdAnswer();
				if (uiAnswer != null && !uiAnswer.getAnswer().equals("")) {
					questionDelete = true;
					answer = answerConverter.createAnswer(uiAnswer);
					answer.setQuestion(secondQuestion);
					answerService.addAnswer(answer);
				}

				uiAnswer = pui.getSecondQuestion().getFourthAnswer();
				if (uiAnswer != null && !uiAnswer.getAnswer().equals("")) {
					questionDelete = true;
					answer = answerConverter.createAnswer(uiAnswer);
					answer.setQuestion(secondQuestion);
					answerService.addAnswer(answer);
				}
				if (questionDelete == false) {
					ok = false;
					questionService.deleteQuestion(secondQuestion);
				}
			}

			uiquestion = pui.getThirdQuestion();
			if (uiquestion != null && !uiquestion.getQuestion().equals("")) {
				ok = true;
				boolean questionDelete = false;
				Question thirdQuestion = questionConverter.createQuestion(uiquestion);
				thirdQuestion.setTest(test);
				thirdQuestion.setAvailable(false);
				questionService.addQuestion(thirdQuestion);

				uiAnswer = pui.getThirdQuestion().getFirstAnswer();
				if (uiAnswer != null && !uiAnswer.getAnswer().equals("")) {
					questionDelete = true;
					answer = answerConverter.createAnswer(uiAnswer);
					answer.setQuestion(thirdQuestion);
					answerService.addAnswer(answer);
				}

				uiAnswer = pui.getThirdQuestion().getSecondAnswer();
				if (uiAnswer != null && !uiAnswer.getAnswer().equals("")) {
					questionDelete = true;
					answer = answerConverter.createAnswer(uiAnswer);
					answer.setQuestion(thirdQuestion);
					answerService.addAnswer(answer);
				}

				uiAnswer = pui.getThirdQuestion().getThirdAnswer();
				if (uiAnswer != null && !uiAnswer.getAnswer().equals("")) {
					questionDelete = true;
					answer = answerConverter.createAnswer(uiAnswer);
					answer.setQuestion(thirdQuestion);
					answerService.addAnswer(answer);
				}

				uiAnswer = pui.getThirdQuestion().getFourthAnswer();
				if (uiAnswer != null && !uiAnswer.getAnswer().equals("")) {
					questionDelete = true;
					answer = answerConverter.createAnswer(uiAnswer);
					answer.setQuestion(thirdQuestion);
					answerService.addAnswer(answer);
				}
				if (questionDelete == false) {
					ok = false;
					questionService.deleteQuestion(thirdQuestion);
				}
			}

			uiquestion = pui.getFourthQuestion();
			if (uiquestion != null && !uiquestion.getQuestion().equals("")) {
				ok = true;
				boolean questionDelete = false;
				Question fourthQuestion = questionConverter.createQuestion(uiquestion);
				fourthQuestion.setTest(test);
				fourthQuestion.setAvailable(false);
				questionService.addQuestion(fourthQuestion);

				uiAnswer = pui.getFourthQuestion().getFirstAnswer();
				if (uiAnswer != null && !uiAnswer.getAnswer().equals("")) {
					questionDelete = true;
					answer = answerConverter.createAnswer(uiAnswer);
					answer.setQuestion(fourthQuestion);
					answerService.addAnswer(answer);
				}

				uiAnswer = pui.getFourthQuestion().getSecondAnswer();
				if (uiAnswer != null && !uiAnswer.getAnswer().equals("")) {
					questionDelete = true;
					answer = answerConverter.createAnswer(uiAnswer);
					answer.setQuestion(fourthQuestion);
					answerService.addAnswer(answer);
				}

				uiAnswer = pui.getFourthQuestion().getThirdAnswer();
				if (uiAnswer != null && !uiAnswer.getAnswer().equals("")) {
					questionDelete = true;
					answer = answerConverter.createAnswer(uiAnswer);
					answer.setQuestion(fourthQuestion);
					answerService.addAnswer(answer);
				}

				uiAnswer = pui.getFourthQuestion().getFourthAnswer();
				if (uiAnswer != null && !uiAnswer.getAnswer().equals("")) {
					questionDelete = true;
					answer = answerConverter.createAnswer(uiAnswer);
					answer.setQuestion(fourthQuestion);
					answerService.addAnswer(answer);
				}
				if (questionDelete == false) {
					ok = false;
					questionService.deleteQuestion(fourthQuestion);
				}
			}

			uiquestion = pui.getFifthQuestion();
			if (uiquestion != null && !uiquestion.getQuestion().equals("")) {
				ok = true;
				boolean questionDelete = false;
				Question fifthQuestion = questionConverter.createQuestion(uiquestion);
				fifthQuestion.setTest(test);
				fifthQuestion.setAvailable(false);
				questionService.addQuestion(fifthQuestion);

				uiAnswer = pui.getFifthQuestion().getFirstAnswer();
				if (uiAnswer != null && !uiAnswer.getAnswer().equals("")) {
					questionDelete = true;
					answer = answerConverter.createAnswer(uiAnswer);
					answer.setQuestion(fifthQuestion);
					answerService.addAnswer(answer);
				}

				uiAnswer = pui.getFifthQuestion().getSecondAnswer();
				if (uiAnswer != null && !uiAnswer.getAnswer().equals("")) {
					questionDelete = true;
					answer = answerConverter.createAnswer(uiAnswer);
					answer.setQuestion(fifthQuestion);
					answerService.addAnswer(answer);
				}

				uiAnswer = pui.getFifthQuestion().getThirdAnswer();
				if (uiAnswer != null && !uiAnswer.getAnswer().equals("")) {
					questionDelete = true;
					answer = answerConverter.createAnswer(uiAnswer);
					answer.setQuestion(fifthQuestion);
					answerService.addAnswer(answer);
				}

				uiAnswer = pui.getFifthQuestion().getFourthAnswer();
				if (uiAnswer != null && !uiAnswer.getAnswer().equals("")) {
					questionDelete = true;
					answer = answerConverter.createAnswer(uiAnswer);
					answer.setQuestion(fifthQuestion);
					answerService.addAnswer(answer);
				}
				if (questionDelete == false) {
					ok = false;
					questionService.deleteQuestion(fifthQuestion);
				}
			}
			if (ok == false) {
				testService.removeTest(test);
			} else {
				List<User> students = userService.getUsersByClass(clasForTest.getName());
				System.out.println(clasForTest.getName());
				for (User u : students) {
					Grade grade = new Grade();
					grade.setGrade(0);
					grade.setTest(test);
					grade.setUser(u);
					gradesService.addGrade(grade);
				}
			}
		}
		return "redirect:/test";

	}

	@RequestMapping(value = "/addQuestion/{testId}", method = RequestMethod.POST)
	public String addQuestion(@ModelAttribute("question") UIQuestion pui, @PathVariable("testId") int id) {
		UIAnswer uiAnswer = new UIAnswer();
		Answer answer;
		if (pui != null && !pui.getQuestion().equals("")) {
			Question question = questionConverter.createQuestion(pui);
			question.setTest(testService.getTestById(id));
			question.setAvailable(false);
			questionService.addQuestion(question);

			uiAnswer = pui.getFirstAnswer();
			if (uiAnswer != null && !uiAnswer.getAnswer().equals("")) {
				answer = answerConverter.createAnswer(uiAnswer);
				answer.setQuestion(question);
				answerService.addAnswer(answer);
			}

			uiAnswer = pui.getSecondAnswer();
			if (uiAnswer != null && !uiAnswer.getAnswer().equals("")) {
				answer = answerConverter.createAnswer(uiAnswer);
				answer.setQuestion(question);
				answerService.addAnswer(answer);
			}

			uiAnswer = pui.getThirdAnswer();
			if (uiAnswer != null && !uiAnswer.getAnswer().equals("")) {
				answer = answerConverter.createAnswer(uiAnswer);
				answer.setQuestion(question);
				answerService.addAnswer(answer);
			}

			uiAnswer = pui.getFourthAnswer();
			if (uiAnswer != null && !uiAnswer.getAnswer().equals("")) {
				answer = answerConverter.createAnswer(uiAnswer);
				answer.setQuestion(question);
				answerService.addAnswer(answer);
			}
		}
		return "redirect:/test";

	}

	@RequestMapping(value = "/clone", method = RequestMethod.POST)
	public String cloneTest(@ModelAttribute("testClone") UITest ui) {
		Test test = testService.getTestById(ui.getTestId());
		Test copyOfTest = new Test();
		copyOfTest.setName(test.getName());
		copyOfTest.setUserCreator(test.getUserCreator());
		copyOfTest.setStartDate(test.getStartDate());
		copyOfTest.setClassForTest(classService.getClassByName(ui.getNameClass()));
		copyOfTest.setAvailable(false);
		copyOfTest.setOpened(true);
		testService.addTest(copyOfTest);
		List<Question> questions = questionService.getQuestionByTestId(ui.getTestId());
		for (Question q : questions) {
			Question question = new Question();
			question.setQuestion(q.getQuestion());
			question.setTest(copyOfTest);
			questionService.addQuestion(question);
			List<Answer> answers = answerService.getAnswersByQuestionId(q.getQuestionId());
			for (Answer a : answers) {
				Answer answer = new Answer();
				answer.setAnswer(a.getAnswer());
				answer.setGood(a.isGood());
				answer.setQuestion(question);
				answerService.addAnswer(answer);
			}
		}
		List<User> students = userService.getUsersByClass(copyOfTest.getClassForTest().getName());
		for (User u : students) {
			Grade grade = new Grade();
			grade.setGrade(0);
			grade.setTest(copyOfTest);
			grade.setUser(u);
			gradesService.addGrade(grade);
		}

		return "redirect:/test";
	}

	@RequestMapping(value = "/addQuestion", method = RequestMethod.POST)
	public String addQuestion(@ModelAttribute("questionAdd") UIQuestion ui) {
		if (ui.getQuestion() != null && !ui.getQuestion().equals("")) {
			Question question = questionConverter.createQuestion(ui);
			question.setTest(testService.getTestById(ui.getTestId()));
			question.setAvailable(false);
			boolean questionDelete = false;
			questionService.addQuestion(question);
			Answer answer = new Answer();
			UIAnswer uiAnswer = ui.getFirstAnswer();
			if (uiAnswer != null && !uiAnswer.getAnswer().equals("")) {
				answer = answerConverter.createAnswer(uiAnswer);
				questionDelete = true;
				answer.setQuestion(question);
				answerService.addAnswer(answer);
			}
			uiAnswer = ui.getSecondAnswer();
			if (uiAnswer != null && !uiAnswer.getAnswer().equals("")) {
				questionDelete = true;
				answer = answerConverter.createAnswer(uiAnswer);
				answer.setQuestion(question);
				answerService.addAnswer(answer);
			}
			uiAnswer = ui.getThirdAnswer();
			if (uiAnswer != null && !uiAnswer.getAnswer().equals("")) {
				questionDelete = true;
				answer = answerConverter.createAnswer(uiAnswer);
				answer.setQuestion(question);
				answerService.addAnswer(answer);
			}
			uiAnswer = ui.getFourthAnswer();
			if (uiAnswer != null && !uiAnswer.getAnswer().equals("")) {
				questionDelete = true;
				answer = answerConverter.createAnswer(uiAnswer);
				answer.setQuestion(question);
				answerService.addAnswer(answer);
			}
			if (questionDelete == false) {
				questionService.deleteQuestion(question);
			}
		}

		return "redirect:/test";
	}

	@RequestMapping("/remove/{testId}")
	public String removeTest(@PathVariable("testId") int id) {
		Test test = testService.getTestById(id);
		List<Question> questions = questionService.getQuestionByTestId(test.getTestId());
		List<StudentAnswer> studentAnswers = studentAnswerService.getAllAnswersOfTest(id);
		for (StudentAnswer answer : studentAnswers) {
			studentAnswerService.removeAnswer(answer);
		}
		if (questions != null) {
			for (Question q : questions) {
				List<Answer> particularAnswers = answerService.getAnswersByQuestionId(q.getQuestionId());
				for (Answer a : particularAnswers) {
					answerService.deleteAnswe(a);
				}
				questionService.deleteQuestion(q);
			}
		}

		List<Grade> gradesToRemove = gradesService.getGradesWithTestId(id);
		for (Grade g : gradesToRemove) {
			gradesService.removeGrade(g);
		}
		testService.removeTest(test);
		return "redirect:/test";
	}

	@RequestMapping("/search")
	public String searchPerson(@ModelAttribute("testAdd") UITest test, Model model) {
		model.addAttribute("testAdd", new UITest());
		if (test.getName() != null && !test.getName().equals("")) {
			List<UITest> tests = transformList(testService.getTestByName(test.getName()));
			model.addAttribute("listTests", tests);
		} else {
			List<UITest> tests = transformList(testService.getTestsByUserId(LoginUtils.userLogedIn.getUserId()));
			model.addAttribute("listTests", tests);
		}
		return "test";

	}

	@RequestMapping("/get/{testId}")
	public String getTest(@PathVariable("testId") int id, Model model) {
		model.addAttribute("test", new UITest());
		model.addAttribute("testAdd", new UITest());
		model.addAttribute("firstQuestion", new UIQuestion());
		List<UITest> testList = transformList(testService.getTestsByUserId(LoginUtils.userLogedIn.getUserId()));
		model.addAttribute("listTests", testList);
		Test test = testService.getTestById(id);
		List<Question> questions = questionService.getQuestionByTestId(id);
		for (Question q : questions) {
			List<Answer> answers = answerService.getAnswersByQuestionId(q.getQuestionId());
			Set<Answer> ans = new LinkedHashSet<Answer>(answers);
			q.setAnswers(ans);
		}
		UITestEdit uiTest = new UITestEdit();
		uiTest.setName(test.getName());
		uiTest.setClassName(test.getClassForTest().getName());
		uiTest.setStartDate(formatter.format(test.getStartDate()));
		uiTest.setQuestions(convertQuestions(questions));
		uiTest.setTestId(test.getTestId());
		model.addAttribute("testB", uiTest);
		return "test";
	}

	public List<UITest> transformList(List<Test> list) {
		List<Test> tlist = list;
		List<UITest> uiList = new ArrayList<UITest>();
		for (Test t : tlist) {
			uiList.add(converter.createUITest(t));
		}
		return uiList;
	}

	public List<UIQuestionEdit> convertQuestions(List<Question> question) {
		List<UIQuestionEdit> ui = new ArrayList<UIQuestionEdit>();
		for (Question q : question) {
			UIQuestionEdit uiq = new UIQuestionEdit();
			uiq.setText(q.getQuestion());
			List<UIAnswer> answers = new ArrayList<UIAnswer>();
			for (Answer a : q.getAnswers()) {
				answers.add(answerConverter.createUIAnswer(a));
			}
			uiq.setAnswers(answers);
			uiq.setQuestionId(q.getQuestionId());
			ui.add(uiq);
		}
		return ui;
	}
}
