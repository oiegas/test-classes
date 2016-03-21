package com.converter;

import com.domain.Grade;
import com.ui.domain.UIGrades;

public interface GradesConverter {

	public Grade createGrade(UIGrades ui);
	public UIGrades createUIGrade(Grade grade);
}
