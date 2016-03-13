package com.ui.domain;

import java.util.List;


public class UITest2{

	/**
	 * 
	 */
	private int testId;
	private String name;
	private String startDate;
	private String endDate;
	private List<UIQuestion2> questions;

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
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public List<UIQuestion2> getQuestions() {
		return questions;
	}
	public void setQuestions(List<UIQuestion2> questions) {
		this.questions = questions;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}

}
