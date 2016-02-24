package com.converter;

import com.domain.Test;
import com.service.providers.TestService;
import com.service.providers.TestServiceImplementation;
import com.ui.domain.UITest;

public class TestConverterImplementation implements TestConverter{

	TestService service=new TestServiceImplementation();
	public Test createTest(UITest ui) {
		Test test=service.getTestById(ui.getTestId());
		
		
		return null;
	}

	public UITest createUITest(Test test) {
		// TODO Auto-generated method stub
		return null;
	}

}
