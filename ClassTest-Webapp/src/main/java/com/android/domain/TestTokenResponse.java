package com.android.domain;

import java.util.List;

import com.domain.Test;

public class TestTokenResponse {
	
	private List<Test> tests;
	private TokenResponse tokenResponse;

	public List<Test> getTests() {
		return tests;
	}

	public void setTests(List<Test> tests) {
		this.tests = tests;
	}

	public TokenResponse getTokenResponse() {
		return tokenResponse;
	}

	public void setTokenResponse(TokenResponse tokenResponse) {
		this.tokenResponse = tokenResponse;
	}

}
