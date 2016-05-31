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

import com.android.domain.AnswerAndroid;
import com.android.domain.ListQuestionsTokenResponse;
import com.android.domain.QuestionAndroid;
import com.android.domain.QuestionResponse;
import com.android.domain.QuestionToken;
import com.android.domain.SingleTestTokenResponse;
import com.android.domain.TestResponse;
import com.android.domain.TestToken;
import com.android.domain.TestTokenResponse;
import com.android.domain.TokenResponse;
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
	GradesService gradeService = new GradesServiceImplementation();
	LoginService loginService = new LoginService();

	public void computeGrades(int testId) {
		Test test = testService.getTestById(testId);
		List<Question> questions = questionService.getQuestionByTestId(testId);
		int numberOfQuestion = questions.size();
		float grade = 0;
		float gradeQuestion = 10 / (float) numberOfQuestion;
		List<User> students = userService.getUsersByClass(test.getClassForTest().getName());
		List<StudentAnswer> allStudentAnswers = new ArrayList<>();
		for (User user : students) {
			grade = 0;
			allStudentAnswers = studentAnswerService.getAllAnswersOfStudentAndTest(user.getUserId(), testId);
			if (allStudentAnswers.size() > 0) {
				for (Question q : questions) {
					int wrong = 0;
					int correctAnswers = 0;
					List<Answer> answers = answersService.getAnswersByQuestionId(q.getQuestionId());
					for (Answer a : answers) {
						if (a.isGood()) {
							correctAnswers++;
						}
					}
					float questionSum = 0;
					float sum = 1 / (float) correctAnswers;
					List<StudentAnswer> studentAnswers = studentAnswerService
							.getAllAnsweresOfQuestionsAndStudent(q.getQuestionId(), user.getUserId());
					if (studentAnswers != null) {
						for (Answer a : answers) {
							for (StudentAnswer studAnswer : studentAnswers) {
								if (studAnswer.getAnswer().getAnswerId() == a.getAnswerId()) {
									if (a.isGood())
										questionSum = questionSum + sum;
									else
										wrong = 1;
								}
							}
						}
					}
					if (wrong == 1)
						questionSum = 0;
					if (questionSum > 0)
						grade = grade + gradeQuestion * questionSum;
				}
			}
			Grade studentGrade = gradeService.getGradeOfStudentFromTest(user.getUserId(), testId);
			studentGrade.setGrade((int) grade);
			gradeService.updateGrade(studentGrade);
			System.out.println("THE GRADE IS" + grade);
		}

	}

	@GET
	@Path("/getTestsOfUser/{id}/{token}")
	@Produces(MediaType.APPLICATION_JSON)
	public TestTokenResponse getAllAvailableTestsOfUser(@PathParam("id") int id, @PathParam("token") String token) {
		TestTokenResponse response = new TestTokenResponse();
		TokenResponse tokenResponse = new TokenResponse();
		if (loginService.verifyIfTokenIsAvailable(token).isAvailability()) {
			List<Test> tests = testService.getTestsByUserId(id);
			response.setTests(tests);
			tokenResponse.setAvailability(true);
			response.setTokenResponse(tokenResponse);
			return response;
		} else {
			tokenResponse.setAvailability(false);
			response.setTokenResponse(tokenResponse);
			return response;
		}
	}

	@POST
	@Path("/makeAvailable")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public TokenResponse makeTestAvailable(TestToken testToken) {

		if (loginService.verifyIfTokenIsAvailable(testToken.getToken()).isAvailability() == true) {
			Test newTest = testService.getTestById(testToken.getTest().getTestId());
			newTest.setAvailable(true);
			testService.updateTest(newTest);
			List<Question> questions = questionService.getQuestionByTestId(testToken.getTest().getTestId());
			Question q = questions.get(0);
			q.setAvailable(true);
			questionService.updateQuestion(q);
		}
		return loginService.verifyIfTokenIsAvailable(testToken.getToken());
	}

	@POST
	@Path("/makeQuestionAvailable")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public TokenResponse makeQuestionAvailable(QuestionToken questionToken) {
		if (loginService.verifyIfTokenIsAvailable(questionToken.getToken()).isAvailability() == true) {
			Question newQuestion = questionService.getQuestionById(questionToken.getQuestion().getQuestionId());
			newQuestion.setAvailable(true);
			questionService.updateQuestion(newQuestion);
		}
		return loginService.verifyIfTokenIsAvailable(questionToken.getToken());

	}

	@POST
	@Path("/makeUnavailableAndClosed")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public TokenResponse makeTestClosedAndUnavailable(TestToken testToken) {
		if (loginService.verifyIfTokenIsAvailable(testToken.getToken()).isAvailability() == true) {
			Test newTest = testService.getTestById(testToken.getTest().getTestId());
			newTest.setAvailable(false);
			newTest.setOpened(false);
			testService.updateTest(newTest);
			computeGrades(testToken.getTest().getTestId());
		}
		return loginService.verifyIfTokenIsAvailable(testToken.getToken());
	}

	@GET
	@Path("getTestWithId/{id}/{token}")
	@Produces(MediaType.APPLICATION_JSON)
	public SingleTestTokenResponse getTestWithId(@PathParam("id") int id, @PathParam("token") String token) {
		SingleTestTokenResponse response = new SingleTestTokenResponse();
		TokenResponse tokenResponse = new TokenResponse();
		if (loginService.verifyIfTokenIsAvailable(token).isAvailability()) {
			Test test = testService.getTestById(id);
			response.setTest(test);
			tokenResponse.setAvailability(true);
			response.setTokenResponse(tokenResponse);
			return response;
		} else {
			tokenResponse.setAvailability(false);
			response.setTokenResponse(tokenResponse);
			return response;
		}
	}

	@GET
	@Path("getQuestionWithTestId/{id}/{token}")
	@Produces(MediaType.APPLICATION_JSON)
	public ListQuestionsTokenResponse getQuestionWithTestId(@PathParam("id") int id, @PathParam("token") String token) {
		ListQuestionsTokenResponse response = new ListQuestionsTokenResponse();
		TokenResponse tokenResponse = new TokenResponse();
		if (loginService.verifyIfTokenIsAvailable(token).isAvailability()) {
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
			response.setQuestions(sendQuestions);
			tokenResponse.setAvailability(true);
			response.setTokenResponse(tokenResponse);
			return response;
		} else {
			tokenResponse.setAvailability(false);
			response.setTokenResponse(tokenResponse);
			return response;
		}
	}

	@GET
	@Path("getAvailableTest/{userId}/{token}")
	@Produces(MediaType.APPLICATION_JSON)
	public SingleTestTokenResponse getAvailableTestForUser(@PathParam("userId") int userId,
			@PathParam("token") String token) {
		SingleTestTokenResponse response = new SingleTestTokenResponse();
		TokenResponse tokenResponse = new TokenResponse();
		if (loginService.verifyIfTokenIsAvailable(token).isAvailability()) {
			User user = userService.getUserById(userId);
			Clas clas = user.getClassForUser();
			Test test = testService.getAvailableTestForClass(clas.getClassId());
			response.setTest(test);
			tokenResponse.setAvailability(true);
			response.setTokenResponse(tokenResponse);
			return response;
		} else {
			tokenResponse.setAvailability(false);
			response.setTokenResponse(tokenResponse);
			return response;

		}
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
