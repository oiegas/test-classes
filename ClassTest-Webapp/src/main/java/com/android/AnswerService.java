package com.android;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.android.domain.StudentAnswerResponse;
import com.android.domain.StudentAnswerToken;
import com.android.domain.TokenResponse;
import com.domain.Answer;
import com.domain.Question;
import com.domain.StudentAnswer;
import com.domain.Test;
import com.domain.User;
import com.service.providers.AnswerServiceImplementation;
import com.service.providers.QuestionService;
import com.service.providers.QuestionServiceImplementation;
import com.service.providers.StudentAnswerImplementation;
import com.service.providers.StudentAnswerService;
import com.service.providers.TestService;
import com.service.providers.TestServiceImplementation;
import com.service.providers.UserService;
import com.service.providers.UserServiceImplementation;

@Path("/test/answer")
public class AnswerService {

	StudentAnswerService service = new StudentAnswerImplementation();
	UserService userService = new UserServiceImplementation();
	TestService testService = new TestServiceImplementation();
	LoginService loginService=new LoginService();
	QuestionService questionService = new QuestionServiceImplementation();
	AnswerServiceImplementation answerService = new AnswerServiceImplementation();

	@POST
	@Path("/studentAnswer")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public TokenResponse sendAnswer(StudentAnswerToken answerToken) {
		if(loginService.verifyIfTokenIsAvailable(answerToken.getToken()).isAvailability()){
			List<StudentAnswerResponse> answers=answerToken.getStudentResponse();
		for (StudentAnswerResponse s : answers) {
			StudentAnswer studentAnswer = new StudentAnswer();
			Test test = testService.getTestById(s.getTestId());
			studentAnswer.setTest(test);
			Question question = questionService.getQuestionById(s.getQuestionId());
			studentAnswer.setQuestion(question);
			Answer newAnswer = answerService.getAnswerById(s.getAnswerId());
			studentAnswer.setAnswer(newAnswer);
			User user = userService.getUserById(s.getUserId());
			studentAnswer.setUser(user);
			service.addStudentAnswer(studentAnswer);
		}
		}
		return loginService.verifyIfTokenIsAvailable(answerToken.getToken());
	}

}
