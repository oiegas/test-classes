package com.android.domain;

import com.domain.Question;

public class QuestionToken {

	private Question question;
	private String token;

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}
