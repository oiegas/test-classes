package com.services;

import java.util.List;

import com.domain.Clas;

public interface ClassDAOService {
	
	public Clas addClass(Clas c);
	public void deleteClass(Clas c);
	public Clas updateClass(Clas c);
	public Clas getClassById(int id);
	public List<Clas> getAllClasses();

}
