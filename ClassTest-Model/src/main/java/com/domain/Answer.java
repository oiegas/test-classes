package com.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Answer")
public class Answer implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 @Column(name = "answer_id", unique = true, nullable = false)
	private int answerId;
	@Column(name = "answer", unique = false, nullable = false, length = 30)
	private String answer;
	@ManyToOne(optional = false)
	private Question question;
	@OneToMany(fetch = FetchType.LAZY)
	private Set<StudentAnswer> studAnswer;
	public int getAnswerId() {
		return answerId;
	}
	public void setAnswerId(int answerId) {
		this.answerId = answerId;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
	public Set<StudentAnswer> getStudAnswer() {
		return studAnswer;
	}
	public void setStudAnswer(Set<StudentAnswer> studAnswer) {
		this.studAnswer = studAnswer;
	}
	

}
