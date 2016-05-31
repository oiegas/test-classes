package com.android.domain;

import com.domain.Test;

public class SingleTestTokenResponse {
	private Test test;
	private TokenResponse tokenResponse;

	public Test getTest() {
		return test;
	}

	public void setTest(Test test) {
		this.test = test;
	}

	public TokenResponse getTokenResponse() {
		return tokenResponse;
	}

	public void setTokenResponse(TokenResponse tokenResponse) {
		this.tokenResponse = tokenResponse;
	}

}
