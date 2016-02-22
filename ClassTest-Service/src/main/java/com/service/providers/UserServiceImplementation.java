package com.service.providers;

import com.domain.User;
import com.services.UserDAOService;
import com.services.UserDAOServiceImplementation;

public class UserServiceImplementation implements UserService{
	UserDAOService dao=new UserDAOServiceImplementation();
	public User addUser(User user) {
		return dao.addUser(user);
	}

	public User searchUserByName(String name) {
		return dao.searchUserByName(name);
	}

	public User updateUser(User user) {
		return dao.updateUser(user);
	}

	public void removeUser(User user) {
		dao.removeUser(user);
	}

	public String getRole(String user) {
		return dao.getRole(user);
	}

	public boolean verifyLogin(String username, String password) {
		return dao.verifyLogin(username, password);
	}

}
