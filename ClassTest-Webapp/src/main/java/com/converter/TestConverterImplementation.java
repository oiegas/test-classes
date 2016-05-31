package com.converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.domain.Test;
import com.service.providers.TestService;
import com.service.providers.TestServiceImplementation;
import com.ui.domain.UITest;

public class TestConverterImplementation implements TestConverter{

	DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	TestService service=new TestServiceImplementation();
	
	public Test createTest(UITest ui) {
		Test test;
		Date date=null;
		if(service.getTestById(ui.getTestId())!=null)
			test=service.getTestById(ui.getTestId());
		else
			test=new Test();
		if((!ui.getName().equals(""))||ui.getName()!=null)
			test.setName(ui.getName());
		if (ui.getStartDate() != null){
			try {
				date = formatter.parse(ui.getStartDate());
			} catch (ParseException e) {
				e.printStackTrace();
			}
			test.setStartDate(date);
		}
		return test;
	}

	public UITest createUITest(Test test) {
		
		UITest ui=new UITest();
		ui.setTestId(test.getTestId());
		if((!test.getName().equals(""))||test.getName()!=null)
			ui.setName(test.getName());
		if(test.getStartDate()!=null){
			ui.setStartDate(formatter.format(test.getStartDate()));
		}
		return ui;
	}

}
