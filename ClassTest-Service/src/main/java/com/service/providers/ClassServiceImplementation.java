package com.service.providers;

import java.util.List;

import com.domain.Clas;
import com.services.ClassDAOService;
import com.services.ClassDAOServiceImplementation;

public class ClassServiceImplementation implements ClassService{

	ClassDAOService dao=new ClassDAOServiceImplementation();
	public Clas addClass(Clas c) {
		return dao.addClass(c);
	}
	
	public void deleteClass(Clas c) {
dao.deleteClass(c);		
	}

	public Clas updateClass(Clas c) {
		return dao.updateClass(c);
	}

	public Clas getClassById(int id) {
		return dao.getClassById(id);
	}

	public List<Clas> getAllClasses() {
		return dao.getAllClasses();
	}

}
