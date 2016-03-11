package com.service.providers;

import java.util.List;

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

	public Question getQuestionById(int id) {
		return dao.getQuestionById(id);
	}

	public List<Question> getQuestionByTestId(int id) {
		return dao.getQuestionByTestId(id);
	}

}
