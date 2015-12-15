package com.service.providers;

import com.domain.User;

public interface UserService {
	public User addUser(User user);
	public User searchUserByName(String name);
	public User updateUser(User user);
	public void removeUser(User user);
	public String getRole(String user);
	public boolean verifyLogin(String username, String password);
}
