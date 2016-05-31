package com.android.domain;

import java.util.List;

public class ListQuestionsTokenResponse {

	private List<QuestionAndroid> questions;
	private TokenResponse tokenResponse;
	public List<QuestionAndroid> getQuestions() {
		return questions;
	}
	public void setQuestions(List<QuestionAndroid> questions) {
		this.questions = questions;
	}
	public TokenResponse getTokenResponse() {
		return tokenResponse;
	}
	public void setTokenResponse(TokenResponse tokenResponse) {
		this.tokenResponse = tokenResponse;
	}
}
