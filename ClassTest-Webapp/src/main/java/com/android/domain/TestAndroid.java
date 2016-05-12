package com.android.domain;

import java.util.Date;
import java.util.List;

import com.domain.Clas;
import com.domain.User;

public class TestAndroid {
	private int testId;
	private String name;
	private Date startDate;
	private Date endDate;
	private boolean opened;
	private boolean available;
	public List<QuestionAndroid> questions;
	private Clas classForTest;
	private User userCreator;
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
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public boolean isOpened() {
		return opened;
	}
	public void setOpened(boolean opened) {
		this.opened = opened;
	}
	public boolean isAvailable() {
		return available;
	}
	public void setAvailable(boolean available) {
		this.available = available;
	}
	public List<QuestionAndroid> getQuestions() {
		return questions;
	}
	public void setQuestions(List<QuestionAndroid> questions) {
		this.questions = questions;
	}
	public Clas getClassForTest() {
		return classForTest;
	}
	public void setClassForTest(Clas classForTest) {
		this.classForTest = classForTest;
	}
	public User getUserCreator() {
		return userCreator;
	}
	public void setUserCreator(User userCreator) {
		this.userCreator = userCreator;
	}
	
	
	
}
