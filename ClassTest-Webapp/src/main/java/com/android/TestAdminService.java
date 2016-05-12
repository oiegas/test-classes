package com.android;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.android.domain.AnswerAndroid;
import com.android.domain.QuestionAndroid;
import com.android.domain.QuestionResponse;
import com.android.domain.TestResponse;
import com.domain.Answer;
import com.domain.Clas;
import com.domain.Grade;
import com.domain.Question;
import com.domain.StudentAnswer;
import com.domain.Test;
import com.domain.User;
import com.service.providers.AnswerServiceImplementation;
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

@Path("/test/testService")
public class TestAdminService {
	TestService testService = new TestServiceImplementation();
	QuestionService questionService = new QuestionServiceImplementation();
	AnswerServiceImplementation answersService = new AnswerServiceImplementation();
	UserService userService = new UserServiceImplementation();
	StudentAnswerService studentAnswerService = new StudentAnswerImplementation();
	GradesService gradeService=new GradesServiceImplementation();

	public void computeGrades(int testId) {
		Test test = testService.getTestById(testId);
		List<Question> questions = questionService.getQuestionByTestId(testId);
		int numberOfQuestion = questions.size();
		float grade = 0;
		float gradeQuestion = 10 / (float)numberOfQuestion;
		List<User> students = userService.getUsersByClass(test.getClassForTest().getName());
		List<StudentAnswer> allStudentAnswers = new ArrayList<>();
		for (User user : students) {
			grade = 0;
			allStudentAnswers = studentAnswerService.getAllAnswersOfStudentAndTest(user.getUserId(), testId);
			if (allStudentAnswers.size() > 0) {
				for (Question q : questions) {
					List<Answer> answers = answersService.getAnswersByQuestionId(q.getQuestionId());
					float questionSum = 0;
					float sum = 1 / (float)answers.size();
					List<StudentAnswer> studentAnswers = studentAnswerService
							.getAllAnsweresOfQuestionsAndStudent(q.getQuestionId(), user.getUserId());
					if (studentAnswers != null) {
						for (Answer a : answers) {
							int ok = 0;
							for (StudentAnswer studAnswer : studentAnswers) {
								if (studAnswer.getAnswer().getAnswerId() == a.getAnswerId()) {
									ok = 1;
									if (a.isGood())
										questionSum = questionSum + sum;
									else
										questionSum = questionSum - sum;
								}
							}
							if (ok == 0) {
								if (a.isGood() == false)
									questionSum = questionSum + sum;
							}
						}
					}
					if (questionSum > 0)
						grade = grade + gradeQuestion * questionSum;
				}
			}
			Grade studentGrade=gradeService.getGradeOfStudentFromTest(user.getUserId(), testId);
			studentGrade.setGrade((int)grade);
			gradeService.updateGrade(studentGrade);
			System.out.println("THE GRADE IS" + grade);
		}

	}

	@GET
	@Path("/getTestsOfUser/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Test> getAllAvailableTestsOfUser(@PathParam("id") int id) {
		List<Test> tests = testService.getTestsByUserId(id);
		return tests;
	}

	@POST
	@Path("/makeAvailable")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response makeTestAvailable(Test test) {

		Test newTest = testService.getTestById(test.getTestId());
		newTest.setAvailable(true);
		testService.updateTest(newTest);
		List<Question> questions = questionService.getQuestionByTestId(test.getTestId());
		Question q = questions.get(0);
		q.setAvailable(true);
		questionService.updateQuestion(q);
		return Response.status(201).entity(test).build();
	}

	@POST
	@Path("/makeQuestionAvailable")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response makeQuestionAvailable(Question question) {
		Question newQuestion = questionService.getQuestionById(question.getQuestionId());
		newQuestion.setAvailable(true);
		questionService.updateQuestion(newQuestion);
		return Response.status(201).entity(newQuestion).build();
	}

	@POST
	@Path("/makeUnavailableAndClosed")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response makeTestClosedAndUnavailable(Test test) {
		Test newTest = testService.getTestById(test.getTestId());
		newTest.setAvailable(false);
		newTest.setOpened(false);
		testService.updateTest(newTest);
		computeGrades(test.getTestId());
		return Response.status(201).entity(newTest).build();
	}

	@GET
	@Path("getTestWithId/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Test getTestWithId(@PathParam("id") int id) {
		Test test = testService.getTestById(id);
		return test;
	}

	@GET
	@Path("getQuestionWithTestId/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<QuestionAndroid> getQuestionWithTestId(@PathParam("id") int id) {
		List<Question> questions = questionService.getQuestionByTestId(id);
		List<QuestionAndroid> sendQuestions = new ArrayList<>();
		for (Question q : questions) {
			QuestionAndroid question = new QuestionAndroid();
			question.setAvailable(q.isAvailable());
			question.setQuestion(q.getQuestion());
			question.setQuestionId(q.getQuestionId());
			question.setTestId(id);
			List<Answer> answers = answersService.getAnswersByQuestionId(q.getQuestionId());
			List<AnswerAndroid> androidAnswers = new ArrayList<>();
			for (Answer a : answers) {
				AnswerAndroid answer = new AnswerAndroid();
				answer.setAnswer(a.getAnswer());
				answer.setAnswerId(a.getAnswerId());
				answer.setGood(a.isGood());
				androidAnswers.add(answer);
			}
			question.setAnswers(androidAnswers);
			sendQuestions.add(question);
		}
		return sendQuestions;
	}

	@GET
	@Path("getAvailableTest/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Test getAvailableTestForUser(@PathParam("userId") int userId) {
		User user = userService.getUserById(userId);
		Clas clas = user.getClassForUser();
		Test test = testService.getAvailableTestForClass(clas.getClassId());
		return test;
	}

	@GET
	@Path("/verifyIfQuestionIsAvailable/{questionId}")
	@Produces(MediaType.APPLICATION_JSON)
	public QuestionResponse verifyIfQuestionIsAvailable(@PathParam("questionId") int questionId) {
		Question question = questionService.getQuestionById(questionId);
		QuestionResponse response = new QuestionResponse();
		if (question.isAvailable())
			response.setAvailability(true);
		else
			response.setAvailability(false);
		return response;
	}

	@GET
	@Path("/verifyIfTestIsAvailable/{testId}")
	@Produces(MediaType.APPLICATION_JSON)
	public TestResponse verifyIfTestIsAvailable(@PathParam("testId") int testId) {
		TestResponse response = new TestResponse();
		Test test = testService.getTestById(testId);
		if (test.isAvailable())
			response.setAvailability(true);
		else
			response.setAvailability(false);
		return response;
	}

}
