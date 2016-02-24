package com.converter;

import com.domain.StudentAnswer;
import com.ui.domain.UIStudentAnswer;

public interface StudentAnswerConverter {

	public StudentAnswer createStudentAnswer(UIStudentAnswer ui);
	public UIStudentAnswer createUIStudentAnswer(StudentAnswer answer);
}
