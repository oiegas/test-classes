package com.service.providers;

import java.util.List;

import com.domain.Test;

public interface TestService {
	public Test addTest(Test test);
	public Test updateTest(Test test);
	public void removeTest(Test test);
	public Test getTestById(int id);
	public List<Test> getAllTests();
	public List<Test> getTestByName(String name);
	public List<Test> getTestsByUserId(int id);
	public Test getAvailableTestForClass(int classId);
	public List<Test> getTestForClass(int classId);
}
