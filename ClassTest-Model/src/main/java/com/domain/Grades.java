package com.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Grades")
public class Grades {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name= "grades_id",unique=true,nullable=false)
	private int gradeId;
	@Column(name = "grade", unique = false, nullable = false)
	private int grade;
	@ManyToOne(optional = false)
	private User user;
	
	public int getGradeId() {
		return gradeId;
	}
	public void setGradeId(int gradeId) {
		this.gradeId = gradeId;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}
