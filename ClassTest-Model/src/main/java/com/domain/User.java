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
@Table(name = "User")
public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "user_id", unique = true, nullable = false)
	private int userId;
	@Column(name = "name", nullable = false, length = 30)
	private String name;
	@Column(name = "username", nullable = false,unique = true, length = 30)
	private String username;
	@Column(name = "password", nullable = false, length = 30)
	private String password;
	@Column(name = "email", nullable = false, length = 30)
	private String email;
	@ManyToOne(optional = false,targetEntity = Role.class)
	private Role role;
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "test_users", joinColumns = { 
			@JoinColumn(name = "user_id", nullable = false, updatable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "test_id", 
					nullable = false, updatable = false) })
	private Set<Test> tests;
	@ManyToOne
	 @JoinColumn(name = "class_id")
	private Clas classForUser;
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	public Set<Test> testsMadeByUser;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@OneToMany(fetch = FetchType.LAZY)
	private Set<Grade> grades;
	@OneToMany(fetch = FetchType.LAZY,orphanRemoval=true)
	private Set<StudentAnswer> studAnswer;
	public Set<Test> getTests() {
		return tests;
	}
	public void setTests(Set<Test> tests) {
		this.tests = tests;
	}
	public Set<Grade> getGrades() {
		return grades;
	}
	public void setGrades(Set<Grade> grades) {
		this.grades = grades;
	}
	public String getName() {
		return name;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Set<StudentAnswer> getStudAnswer() {
		return studAnswer;
	}
	public void setStudAnswer(Set<StudentAnswer> studAnswer) {
		this.studAnswer = studAnswer;
	}
	public Clas getClassForUser() {
		return classForUser;
	}
	public void setClassForUser(Clas classForUser) {
		this.classForUser = classForUser;
	}
	public Set<Test> getTestsMadeByUser() {
		return testsMadeByUser;
	}
	public void setTestsMadeByUser(Set<Test> testsMadeByUser) {
		this.testsMadeByUser = testsMadeByUser;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	

}
