package com.android;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.domain.Clas;
import com.domain.User;
import com.service.providers.ClassService;
import com.service.providers.ClassServiceImplementation;

@Path("/test/register")
public class RegisterService {
ClassService classService=new ClassServiceImplementation();

@GET
@Path("/getClasses")
@Produces(MediaType.APPLICATION_JSON)
public List<Clas> getAllClasses(){
	return classService.getAllClasses();
}

@POST
@Path("/createUser")
@Consumes(MediaType.APPLICATION_JSON)
public void createUser(User user){
	System.out.println("Acesta este userul:"+ user.getName());
}
}
