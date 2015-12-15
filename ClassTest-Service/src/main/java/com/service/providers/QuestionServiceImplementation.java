package com.service.providers;

import com.domain.Question;
import com.services.QuestionDAOService;
import com.services.QuestionDAOServiceImplementation;

public class QuestionServiceImplementation implements QuestionService{
	QuestionDAOService dao=new QuestionDAOServiceImplementation();
	public Question addQuestion(Question question) {
		return dao.addQuestion(question);
	}

	public Question updateQuestion(Question question) {
		return dao.updateQuestion(question);
	}

	public void deleteQuestion(Question question) {
dao.deleteQuestion(question);		
	}

}
