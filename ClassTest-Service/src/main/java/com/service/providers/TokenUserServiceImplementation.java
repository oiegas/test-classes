package com.service.providers;

import com.domain.TokenUser;
import com.services.TokenUserDAOService;
import com.services.TokenUserDAOServiceImplementation;

public class TokenUserServiceImplementation implements TokenUserService{

	TokenUserDAOService dao=new TokenUserDAOServiceImplementation();
	@Override
	public TokenUser addToken(TokenUser token) {
		return dao.addToken(token);
	}

	@Override
	public void remove(TokenUser token) {
		dao.remove(token);
	}

	@Override
	public TokenUser updateToken(TokenUser token) {
		return dao.updateToken(token);
	}

	public TokenUser findTokenByUserId(int id) {
		return dao.findTokenByUserId(id);
	}

	@Override
	public TokenUser getTokenByToken(String token) {
		return dao.findTokenByToken(token);
	}

}
