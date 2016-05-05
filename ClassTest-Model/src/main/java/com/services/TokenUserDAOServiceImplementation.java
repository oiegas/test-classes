package com.services;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.domain.TokenUser;
import com.domain.User;
import com.repository.EntityManagerUtil;

public class TokenUserDAOServiceImplementation implements TokenUserDAOService {

	private EntityManager entityM;

	public TokenUserDAOServiceImplementation() {
		entityM = EntityManagerUtil.entityM;
	}

	@Override
	public TokenUser addToken(TokenUser token) {
		entityM.getTransaction().begin();
		entityM.persist(token);
		entityM.getTransaction().commit();
		return token;
	}

	@Override
	public void remove(TokenUser token) {
		entityM.getTransaction().begin();
		entityM.remove(token);
		entityM.getTransaction().commit();

	}

	@Override
	public TokenUser updateToken(TokenUser token) {
		entityM.getTransaction().begin();
		entityM.merge(token);
		entityM.getTransaction().commit();
		return token;
	}

	public TokenUser findTokenByUserId(int id) {
		entityM = EntityManagerUtil.entityM;
		entityM.clear();
		try {
			TypedQuery<TokenUser> query = entityM.createQuery("Select x from TokenUser x where x.userId =:id",
					TokenUser.class);
			query.setParameter("id", id);
			if (query.getSingleResult() != null)
				return query.getSingleResult();
			else
				return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public TokenUser findTokenByToken(String token) {
		entityM = EntityManagerUtil.entityM;
		entityM.clear();
		try {
			TypedQuery<TokenUser> query = entityM.createQuery("Select x from TokenUser x where x.token =:token",
					TokenUser.class);
			query.setParameter("token", token);
			if (query.getSingleResult() != null)
				return query.getSingleResult();
			else
				return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
