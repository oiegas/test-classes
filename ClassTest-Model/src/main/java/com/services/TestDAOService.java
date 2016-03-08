package com.services;

import java.util.List;

import com.domain.Test;

public interface TestDAOService {

	public Test addTest(Test test);
	public Test updateTest(Test test);
	public void removeTest(Test test);
	public Test getTestById(int id);
	public List<Test> getAllTests();
	public List<Test> getTestsByName(String name);
}
