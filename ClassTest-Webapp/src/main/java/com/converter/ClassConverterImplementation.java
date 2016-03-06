package com.converter;

import com.domain.Clas;
import com.service.providers.ClassService;
import com.service.providers.ClassServiceImplementation;
import com.ui.domain.UIClass;

public class ClassConverterImplementation implements ClassConverter{

	ClassService service=new ClassServiceImplementation();
	public Clas createClass(UIClass ui) {
		Clas c;
		if(service.getClassById(ui.getClassId())!=null)
			c=service.getClassById(ui.getClassId());
		else
			c=new Clas();
		if((!ui.getClassName().equals(""))||ui.getClassName()!=null)
			c.setName(ui.getClassName());
		return c;
	}

	public UIClass createUIClass(Clas clas) {
		UIClass ui=new UIClass();
		if((clas.getClassId()!=0))
			ui.setClassId(clas.getClassId());
		if((!clas.getName().equals(""))||clas.getName()!=null)
			ui.setClassName(clas.getName());
		return ui;
	}

}
