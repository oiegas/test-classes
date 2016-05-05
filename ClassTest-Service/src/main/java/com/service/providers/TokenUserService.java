package com.service.providers;

import com.domain.TokenUser;

public interface TokenUserService {

	public TokenUser addToken(TokenUser token);
	public void remove(TokenUser token);
	public TokenUser updateToken(TokenUser token);
	public TokenUser getTokenByToken(String token);
	public TokenUser findTokenByUserId(int id) ;
}
