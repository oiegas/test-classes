package com.ui.domain;


public class UIAnswer{

	private int answerId;
	private String answer;
	private int questionId;
	private int studAnswerId;
	private boolean good;
	public int getAnswerId() {
		return answerId;
	}
	public void setAnswerId(int answerId) {
		this.answerId = answerId;
	}
	public boolean isGood() {
		return good;
	}
	public void setGood(boolean good) {
		this.good = good;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	public int getStudAnswerId() {
		return studAnswerId;
	}
	public void setStudAnswerId(int studAnswerId) {
		this.studAnswerId = studAnswerId;
	}
	

}
