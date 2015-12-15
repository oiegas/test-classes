package com.service.providers;

import java.util.List;

import com.domain.Grades;
import com.services.GradesDAOService;
import com.services.GradesDAOServiceImplementation;

public class GradesServiceImplementation implements GradesService {

	GradesDAOService dao=new GradesDAOServiceImplementation();
	public Grades addGrade(Grades grade) {
		return dao.addGrade(grade);
	}

	public Grades updateGrade(Grades grade) {
		return dao.updateGrade(grade);
	}

	public List<Grades> getGradesOfStudent(String name) {
		return dao.getGradesOfStudent(name);
	}

	public void removeGrade(Grades grade) {
		dao.removeGrade(grade);		
	}

}
