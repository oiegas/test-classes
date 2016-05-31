package com.ui.domain;


public class UITest{

	/**
	 * 
	 */
	private int testId;
	private String name;
	private String startDate;
	private UIQuestion firstQuestion;
	private UIQuestion secondQuestion;
	private UIQuestion thirdQuestion;
	private UIQuestion fourthQuestion;
	private UIQuestion fifthQuestion;
	public int userId;
	public String nameClass;
	public UIQuestion getSecondQuestion() {
		return secondQuestion;
	}
	public void setSecondQuestion(UIQuestion secondQuestion) {
		this.secondQuestion = secondQuestion;
	}
	public UIQuestion getThirdQuestion() {
		return thirdQuestion;
	}
	public void setThirdQuestion(UIQuestion thirdQuestion) {
		this.thirdQuestion = thirdQuestion;
	}
	public UIQuestion getFourthQuestion() {
		return fourthQuestion;
	}
	public void setFourthQuestion(UIQuestion fourthQuestion) {
		this.fourthQuestion = fourthQuestion;
	}
	public UIQuestion getFifthQuestion() {
		return fifthQuestion;
	}
	public void setFifthQuestion(UIQuestion fifthQuestion) {
		this.fifthQuestion = fifthQuestion;
	}
	public UIQuestion getFirstQuestion() {
		return firstQuestion;
	}
	public void setFirstQuestion(UIQuestion firstQuestion) {
		this.firstQuestion = firstQuestion;
	}
	
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
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getNameClass() {
		return nameClass;
	}
	public void setNameClass(String nameClass) {
		this.nameClass = nameClass;
	}

}
