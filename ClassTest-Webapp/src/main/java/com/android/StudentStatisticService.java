package com.android;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.android.domain.StudentGrade;
import com.android.domain.StudentGradesTokenResponse;
import com.android.domain.TokenResponse;
import com.domain.Grade;
import com.service.providers.GradesService;
import com.service.providers.GradesServiceImplementation;
import com.service.providers.TestService;
import com.service.providers.TestServiceImplementation;
import com.service.providers.UserService;
import com.service.providers.UserServiceImplementation;

@Path("/student")
public class StudentStatisticService {

	TestService testService = new TestServiceImplementation();
	GradesService gradeService = new GradesServiceImplementation();
	UserService userService = new UserServiceImplementation();
	LoginService loginService = new LoginService();

	@GET
	@Path("/getStatistics/{id}/{token}")
	@Produces(MediaType.APPLICATION_JSON)
	public StudentGradesTokenResponse getAllGrades(@PathParam("id") int id, @PathParam("token") String token) {
		TokenResponse tokenResponse = new TokenResponse();
		StudentGradesTokenResponse response = new StudentGradesTokenResponse();
		if (loginService.verifyIfTokenIsAvailable(token).isAvailability() == true) {
			List<StudentGrade> studentGrades = new ArrayList<StudentGrade>();
			List<Grade> gradesOfStudent = gradeService.getGradesOfStudentWithId(id);
			for (Grade g : gradesOfStudent) {
				if (g.getTest().isOpened() == false) {
					StudentGrade grade = new StudentGrade();
					grade.setUserName(userService.getUserById(id).getName());
					grade.setGrade(g.getGrade());
					grade.setTestName(g.getTest().getName());
					grade.setUserId(id);
					studentGrades.add(grade);
				}
			}
			response.setGrades(studentGrades);
			tokenResponse.setAvailability(true);
			response.setResponse(tokenResponse);
			return response;
		} else {
			tokenResponse.setAvailability(false);
			response.setResponse(tokenResponse);
			return response;
		}
	}

	@GET
	@Path("/getGradesOfTest/{testId}/{token}")
	@Produces(MediaType.APPLICATION_JSON)
	public StudentGradesTokenResponse getAllGradesOfTest(@PathParam("testId") int testId,
			@PathParam("token") String token) {
		TokenResponse tokenResponse = new TokenResponse();
		StudentGradesTokenResponse response = new StudentGradesTokenResponse();
		if (loginService.verifyIfTokenIsAvailable(token).isAvailability() == true) {
			List<StudentGrade> studentGrades = new ArrayList<>();
			List<Grade> gradesOfStudent = gradeService.getGradesWithTestId(testId);
			for (Grade g : gradesOfStudent) {
				if (g.getTest().isOpened() == false) {
					StudentGrade grade = new StudentGrade();
					grade.setUserName(g.getUser().getName());
					grade.setGrade(g.getGrade());
					grade.setTestName(g.getTest().getName());
					grade.setUserId(g.getUser().getUserId());
					studentGrades.add(grade);
				}
			}
			tokenResponse.setAvailability(true);
			response.setGrades(studentGrades);
			response.setResponse(tokenResponse);
			return response;
		} else {
			tokenResponse.setAvailability(false);
			response.setResponse(tokenResponse);
			return response;
		}
	}

}
