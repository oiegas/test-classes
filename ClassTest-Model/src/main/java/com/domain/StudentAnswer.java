package com.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "StudentAnswer")
public class StudentAnswer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "student_answer_id", unique = true, nullable = false)
	private int studentAnswerId;
	@ManyToOne(optional = false)
	@JoinColumn(name = "user_id")
	private User user;
	@JoinColumn(name = "test_id")
	@ManyToOne(optional = false)
	private Test test;
	@JoinColumn(name = "question_id")
	@ManyToOne(optional = false)
	private Question question;
	@JoinColumn(name = "answer_id")
	@ManyToOne(fetch = FetchType.EAGER)
	private Answer answer;

	public int getStudentAnswerId() {
		return studentAnswerId;
	}

	public void setStudentAnswerId(int studentAnswerId) {
		this.studentAnswerId = studentAnswerId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Test getTest() {
		return test;
	}

	public void setTest(Test test) {
		this.test = test;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public Answer getAnswer() {
		return answer;
	}

	public void setAnswer(Answer answer) {
		this.answer = answer;
	}

}
