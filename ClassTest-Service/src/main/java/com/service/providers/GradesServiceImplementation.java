package com.service.providers;

import java.util.List;

import com.domain.Grade;
import com.services.GradesDAOService;
import com.services.GradesDAOServiceImplementation;

public class GradesServiceImplementation implements GradesService {

	GradesDAOService dao=new GradesDAOServiceImplementation();
	public Grade addGrade(Grade grade) {
		return dao.addGrade(grade);
	}

	public Grade updateGrade(Grade grade) {
		return dao.updateGrade(grade);
	}

	public List<Grade> getGradesOfStudent(String name) {
		return dao.getGradesOfStudent(name);
	}

	public void removeGrade(Grade grade) {
		dao.removeGrade(grade);		
	}

	public List<Grade> getGradesOfStudentWithId(int id) {
		return dao.getGradesOfStudentWithId(id);
	}

	public List<Grade> getGradesWithTestId(int id) {
		return dao.getGradesWithTestId(id);
	}

	@Override
	public Grade getGradeOfStudentFromTest(int userId, int testId) {
		return dao.getGradeOfStudentFromTest(userId, testId);
	}

}
