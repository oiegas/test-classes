package com.service.providers;

import java.util.List;

import com.domain.Test;
import com.services.TestDAOService;
import com.services.TestDAOServiceImplementation;

public class TestServiceImplementation implements TestService{
	TestDAOService dao=new TestDAOServiceImplementation();
	public Test addTest(Test test) {
		return dao.addTest(test);
	}

	public Test updateTest(Test test) {
		return dao.updateTest(test);
	}

	public void removeTest(Test test) {
dao.removeTest(test);		
	}

	public Test getTestById(int id) {
		return dao.getTestById(id);
	}

	public List<Test> getAllTests() {
		return dao.getAllTests();
	}

	public List<Test> getTestByName(String name) {
		return dao.getTestsByName(name);
	}

	public List<Test> getTestsByUserId(int id) {
		return dao.getTestsByUserId(id);
	}

	@Override
	public Test getAvailableTestForClass(int classId) {
		return dao.getAvailableTestForClass(classId);
	}

	@Override
	public List<Test> getTestForClass(int classId) {
		return dao.getTestForClass(classId);
	}

}
