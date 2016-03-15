package com.ui.domain;

import java.util.List;

public class UIQuestionEdit {
	private int questionId;
	private String text;
	private List<UIAnswer> answers;
	
	private int testId;
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	
	public int getTestId() {
		return testId;
	}
	public void setTestId(int testId) {
		this.testId = testId;
	}
	public List<UIAnswer> getAnswers() {
		return answers;
	}
	public void setAnswers(List<UIAnswer> answers) {
		this.answers = answers;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}


}
