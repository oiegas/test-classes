package com.services;

import com.domain.TokenUser;

public interface TokenUserDAOService {
	
	public TokenUser addToken(TokenUser token);
	public void remove(TokenUser token);
	public TokenUser updateToken(TokenUser token);
	public TokenUser findTokenByToken(String token);
	public TokenUser findTokenByUserId(int id);
}
