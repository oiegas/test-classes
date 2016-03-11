package com.service.providers;

import java.util.List;

import com.domain.Answer;
import com.services.AnswerDAOService;
import com.services.AnswerDAOServiceImplementation;

public class AnswerServiceImplementation implements AnswerService {

	AnswerDAOService dao=new AnswerDAOServiceImplementation();
	public Answer addAnswer(Answer answer) {
		return dao.addAnswer(answer);
	}

	public void deleteAnswe(Answer answer) {
		dao.deleteAnswe(answer);
		
	}

	public Answer updateAnswer(Answer answer) {
		return dao.updateAnswer(answer);
	}

	public Answer getAnswerById(int id) {
		return dao.getAnswerById(id);
	}

	public List<Answer> getAnswersByQuestionId(int questionId) {
		return dao.getAnswersByQuestionId(questionId);
	}

}
