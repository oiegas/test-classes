package com.services;

import java.util.List;

import com.domain.Grades;

public interface GradesDAOService {
	
	public Grades addGrade(Grades grade);
	public Grades updateGrade(Grades grade);
	public List<Grades> getGradesOfStudent(String name);
	public void removeGrade(Grades grade);
	

}
