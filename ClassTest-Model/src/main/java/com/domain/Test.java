package com.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Test")
public class Test implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "test_id", unique = true, nullable = false)
	private int testId;
	@Column(name = "name", nullable = false, length = 30)
	private String name;
	@Column(name = "start_date", nullable = false, length = 30)
	private Date startDate;
	@Column(name = "end_date", nullable = false, length = 30)
	private Date endDate;
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "test_users", joinColumns = { 
			@JoinColumn(name = "test_id", nullable = false, updatable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "user_id", 
					nullable = false, updatable = false) })
	public Set<User> users;
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	public Set<Question> questions;
	@ManyToOne
	 @JoinColumn(name = "class_id")
	private Clas classForTest;
	@ManyToOne
	 @JoinColumn(name = "user_id")
	private User userCreator;
	
	public Set<Question> getQuestions() {
		return questions;
	}
	public void setQuestions(Set<Question> questions) {
		this.questions = questions;
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
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
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
