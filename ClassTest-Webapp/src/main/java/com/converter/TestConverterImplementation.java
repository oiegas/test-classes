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
		
		Date date=null;
		Test test=service.getTestById(ui.getTestId());
		if((!ui.getName().equals(""))||ui.getName()!=null)
			test.setName(ui.getName());
		if (ui.getStartDate() != null){
			try {
				date = formatter.parse(ui.getStartDate());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			test.setStartDate(date);
		}
		if (ui.getEndDate() != null){
			try {
				date = formatter.parse(ui.getEndDate());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			test.setEndDate(date);
		}
		return test;
	}

	public UITest createUITest(Test test) {
		
		UITest ui=new UITest();
		if((!test.getName().equals(""))||test.getName()!=null)
			ui.setName(test.getName());
		if(test.getStartDate()!=null){
			ui.setStartDate(formatter.format(test.getStartDate()));
		}
		if(test.getEndDate()!=null)
			ui.setEndDate(formatter.format(test.getEndDate()));
		return ui;
	}

}
