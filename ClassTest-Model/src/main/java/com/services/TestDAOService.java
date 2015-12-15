package com.services;

import com.domain.Test;

public interface TestDAOService {

	public Test addTest(Test test);
	public Test updateTest(Test test);
	public void removeTest(Test test);
}
