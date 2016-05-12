package com.android;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.android.domain.StudentAnswerResponse;
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

	QuestionService questionService = new QuestionServiceImplementation();
	AnswerServiceImplementation answerService = new AnswerServiceImplementation();

	@POST
	@Path("/studentAnswer")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response sendAnswer(List<StudentAnswerResponse> answers) {
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
			System.out.println("TEST ID" + test.getTestId());
			System.out.println("USER ID" + user.getUserId());
			System.out.println("ANSWER ID" + s.getAnswerId());
			System.out.println("QUESTION ID" + question.getQuestionId());
		}
		return Response.status(201).entity(answers).build();
	}

}
