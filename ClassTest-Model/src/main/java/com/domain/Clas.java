package com.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Clas")
public class Clas implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "class_id", unique = true, nullable = false)
	private int classId;
	@Column(name = "name", nullable = false, length = 30)
	private String name;
	@OneToMany(fetch = FetchType.LAZY)
	public Set<User> users;
	@OneToMany(fetch = FetchType.LAZY)
	public Set<Test> tests;
	
	
	public int getClassId() {
		return classId;
	}
	public void setClassId(int classId) {
		this.classId = classId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	

}
