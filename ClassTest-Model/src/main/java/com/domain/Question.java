package com.domain;

import java.io.Serializable;
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
@Table(name = "Question")
public class Question implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "question_id", unique = true, nullable = false, length = 3)
	private int questionId;
	@Column(name = "question", unique = false, nullable = false)
	private String question;
	@ManyToOne
	 @JoinColumn(name = "test_id")
	private Test test;
	@OneToMany(fetch = FetchType.LAZY)
	private Set<Answer> answers;
	@OneToMany(fetch = FetchType.LAZY)
	private Set<StudentAnswer> studAnswer;
	public Set<Answer> getAnswers() {
		return answers;
	}
	public void setAnswers(Set<Answer> answers) {
		this.answers = answers;
	}
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
	public Test getTest() {
		return test;
	}
	public void setTest(Test test) {
		this.test = test;
	}
	public Set<StudentAnswer> getStudAnswer() {
		return studAnswer;
	}
	public void setStudAnswer(Set<StudentAnswer> studAnswer) {
		this.studAnswer = studAnswer;
	}

}
