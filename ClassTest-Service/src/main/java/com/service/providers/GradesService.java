package com.service.providers;

import java.util.List;

import com.domain.Grade;

public interface GradesService {
	public Grade addGrade(Grade grade);
	public Grade updateGrade(Grade grade);
	public List<Grade> getGradesOfStudent(String name);
	public void removeGrade(Grade grade);
	public List<Grade> getGradesOfStudentWithId(int id);
	public List<Grade> getGradesWithTestId(int id);
	public Grade getGradeOfStudentFromTest(int userId, int testId);
}
