package com.converter;

import com.domain.Grades;
import com.ui.domain.UIGrades;

public interface GradesConverter {

	public Grades createGrade(UIGrades ui);
	public UIGrades createUIGrade(Grades grade);
}
