package com.ui.domain;


public class UIQuestion{

	private int questionId;
	private String question;
	private UIAnswer firstAnswer;
	private UIAnswer secondAnswer;
	private UIAnswer thirdAnswer;
	private UIAnswer fourthAnswer;
	public UIAnswer getFirstAnswer() {
		return firstAnswer;
	}
	public void setFirstAnswer(UIAnswer firstAnswer) {
		this.firstAnswer = firstAnswer;
	}
	public UIAnswer getSecondAnswer() {
		return secondAnswer;
	}
	public void setSecondAnswer(UIAnswer secondAnswer) {
		this.secondAnswer = secondAnswer;
	}
	public UIAnswer getThirdAnswer() {
		return thirdAnswer;
	}
	public void setThirdAnswer(UIAnswer thirdAnswer) {
		this.thirdAnswer = thirdAnswer;
	}
	public UIAnswer getFourthAnswer() {
		return fourthAnswer;
	}
	public void setFourthAnswer(UIAnswer fourthAnswer) {
		this.fourthAnswer = fourthAnswer;
	}
	private int testId;
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public int getTestId() {
		return testId;
	}
	public void setTestId(int testId) {
		this.testId = testId;
	}

}
