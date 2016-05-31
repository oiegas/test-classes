package com.ui.domain;

import java.util.List;


public class UITestEdit{

	/**
	 * 
	 */
	private int testId;
	private String name;
	private String startDate;
	private List<UIQuestionEdit> questions;

	public int userId;
	public int getTestId() {
		return testId;
	}
	public void setTestId(int testId) {
		this.testId = testId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public List<UIQuestionEdit> getQuestions() {
		return questions;
	}
	public void setQuestions(List<UIQuestionEdit> questions) {
		this.questions = questions;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}

}
