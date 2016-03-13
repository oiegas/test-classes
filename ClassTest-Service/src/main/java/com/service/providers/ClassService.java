package com.service.providers;

import java.util.List;

import com.domain.Clas;

public interface ClassService {

	public Clas addClass(Clas c);
	public void deleteClass(Clas c);
	public Clas updateClass(Clas c);
	public Clas getClassById(int id);
	public List<Clas> getAllClasses();
	public Clas getClassByName(String name);
}
