package com.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TokenUser")
public class TokenUser {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "token_id", unique = true, nullable = false)
	private int tokenId;
	@Column(name = "token", unique = false, nullable = false)
	private String token;
	@Column(name = "userId", unique = false, nullable = false)
	private int userId;
	@Column(name = "tokenDate", unique = false, nullable = false)
	private Date tokenDate;

	public int getTokenId() {
		return tokenId;
	}

	public void setTokenId(int tokenId) {
		this.tokenId = tokenId;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Date getTokenDate() {
		return tokenDate;
	}

	public void setTokenDate(Date tokenDate) {
		this.tokenDate = tokenDate;
	}
}
