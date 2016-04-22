package com.android;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.domain.User;
import com.service.providers.UserService;
import com.service.providers.UserServiceImplementation;

@Path("/test/login")
public class LoginService {

	UserService userService=new UserServiceImplementation();
	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	public User getUserWithUsernameAndPassword() {
		if(userService.verifyLogin("aaa", "aaa"))
			return userService.getUserByUsername("aaa");
		else
			return null;
	}
	
	@GET
	@Path("/get/{username}/{password}")
	@Produces(MediaType.APPLICATION_JSON)
	public User getUserWithUsernameAndPassword(@PathParam("username") String username, @PathParam("password") String password) {
		if(userService.verifyLogin(username, password))
			return userService.getUserByUsername(username);
		else
			return null;
	}
}
