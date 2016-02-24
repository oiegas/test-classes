package com.service.providers;

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

}
