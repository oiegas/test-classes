package com.converter;

import com.domain.Question;
import com.ui.domain.UIQuestion;

public interface QuestionConverter {

	public Question createQuestion(UIQuestion ui);
	public UIQuestion createUIQuestion(Question question);
}
