package com.service.providers;

import java.util.List;

import com.domain.User;

public interface UserService {
	public User addUser(User user);

	public User searchUserByName(String name);

	public User updateUser(User user);

	public void removeUser(User user);

	public String getRole(String user);

	public User getUserById(int id);

	public boolean verifyLogin(String username, String password);

	public List<User> getAllUsers();
	public List<User> getAllProfesors();

	public List<User> getAllStudents();

	public List<User> getStudentsByName(String name);

	public List<User> getUsersByClass(String clas);

	public User getUserByUsername(String username);

	public User getUserByEmail(String email);
}
