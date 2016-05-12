package com.android;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.android.domain.StudentGrade;
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
	UserService userService=new UserServiceImplementation();

	@GET
	@Path("/getStatistics/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<StudentGrade> getAllGrades(@PathParam("id") int id) {
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
		return studentGrades;
	}
	
	@GET
	@Path("/getGradesOfTest/{testId}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<StudentGrade> getAllGradesOfTest(@PathParam("testId") int testId){
		List<StudentGrade> studentGrades=new ArrayList<>();
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
		return studentGrades;
	}

}
