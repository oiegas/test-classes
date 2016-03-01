package com.service.providers;

import java.util.List;

import com.domain.Test;

public interface TestService {
	public Test addTest(Test test);
	public Test updateTest(Test test);
	public void removeTest(Test test);
	public Test getTestById(int id);
	public List<Test> getAllTests();
}
