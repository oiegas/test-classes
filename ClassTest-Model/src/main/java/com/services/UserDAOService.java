package com.services;

import java.util.List;

import com.domain.User;

public interface UserDAOService {

	public User addUser(User user);
	public User searchUserByName(String name);
	public User updateUser(User user);
	public void removeUser(User user);
	public String getRole(String user);
	public boolean verifyLogin(String username, String password);
	public User getUserById(int id);
	public List<User> getAllUsers();
	public List<User> getAllStudents();
	public List<User> getUsersByName(String name);
}
