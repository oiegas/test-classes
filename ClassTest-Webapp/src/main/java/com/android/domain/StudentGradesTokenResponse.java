package com.android.domain;

import java.util.List;

public class StudentGradesTokenResponse {
	private List<StudentGrade> grades;
	private TokenResponse response;

	public List<StudentGrade> getGrades() {
		return grades;
	}

	public void setGrades(List<StudentGrade> grades) {
		this.grades = grades;
	}

	public TokenResponse getResponse() {
		return response;
	}

	public void setResponse(TokenResponse response) {
		this.response = response;
	}

}
