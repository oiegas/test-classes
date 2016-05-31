package com.android;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.domain.Clas;
import com.domain.Role;
import com.domain.User;
import com.service.providers.ClassService;
import com.service.providers.ClassServiceImplementation;
import com.service.providers.RoleService;
import com.service.providers.RoleServiceImplementation;
import com.service.providers.UserService;
import com.service.providers.UserServiceImplementation;

@Path("/test/register")
public class RegisterService {
	ClassService classService = new ClassServiceImplementation();
	UserService userService = new UserServiceImplementation();
	RoleService roleService = new RoleServiceImplementation();

	@GET
	@Path("/getClasses")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Clas> getAllClasses() {
		return classService.getAllClasses();
	}

	
	@POST
	@Path("/createUser")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createUser(User user) {
		User newUser = new User();
		System.out.println(user.getClassForUser());
		newUser.setEmail(user.getEmail());
		newUser.setName(user.getName());
		newUser.setPassword(user.getPassword());
		newUser.setUsername(user.getUsername());
		newUser.setClassForUser(user.getClassForUser());
		Role role = roleService.getRoleById(2);
		newUser.setRole(role);
		userService.addUser(newUser);
		return Response.status(201).entity(user).build();
	}
}
