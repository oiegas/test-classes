package com.services;

import java.util.List;

import com.domain.Grade;

public interface GradesDAOService {
	
	public Grade addGrade(Grade grade);
	public Grade updateGrade(Grade grade);
	public List<Grade> getGradesOfStudent(String name);
	public void removeGrade(Grade grade);
	public List<Grade> getGradesOfStudentWithId(int id);

}
