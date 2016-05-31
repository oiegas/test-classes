package com.android.domain;

import java.util.List;

/**
 * Created by AlexandruOi on 5/19/2016.
 */
public class StudentAnswerToken {
	private String token;
	private int userId;
	private List<StudentAnswerResponse> studentResponse;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public List<StudentAnswerResponse> getStudentResponse() {
		return studentResponse;
	}

	public void setStudentResponse(List<StudentAnswerResponse> studentResponse) {
		this.studentResponse = studentResponse;
	}
}
