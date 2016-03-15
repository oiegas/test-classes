package com.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "StudentAnswer")
public class StudentAnswer implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name= "student_answer_id",unique=true,nullable=false)
	private int studentAnswerId;
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "studentAnswer_user", joinColumns = { 
			@JoinColumn(name = "student_answer_id", nullable = false, updatable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "user_id", 
					nullable = false, updatable = false) })
	private Set<User> users;
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "studentAnswer_test", joinColumns = { 
			@JoinColumn(name = "student_answer_id", nullable = false, updatable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "test_id", 
					nullable = false, updatable = false) })
	private Set<Test> tests;
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "studentAnswer_question", joinColumns = { 
			@JoinColumn(name = "student_answer_id", nullable = false, updatable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "question_id", 
					nullable = false, updatable = false) })
	private Set<Question> question;
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "studentAnswer_answer", joinColumns = { 
			@JoinColumn(name = "student_answer_id", nullable = false, updatable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "answer_id", 
					nullable = false, updatable = false) })
	private Set<Answer> answer;
	
	public int getStudentAnswerId() {
		return studentAnswerId;
	}
	public void setStudentAnswerId(int studentAnswerId) {
		this.studentAnswerId = studentAnswerId;
	}
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}
	public Set<Test> getTests() {
		return tests;
	}
	public void setTests(Set<Test> tests) {
		this.tests = tests;
	}
	public Set<Question> getQuestion() {
		return question;
	}
	public void setQuestion(Set<Question> question) {
		this.question = question;
	}
	public Set<Answer> getAnswer() {
		return answer;
	}
	public void setAnswer(Set<Answer> answer) {
		this.answer = answer;
	}
	
	

}
