package com.android;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.domain.Test;
import com.service.providers.TestService;
import com.service.providers.TestServiceImplementation;

import rest.domain.TestForAdmin;

@Path("/test/testService")
public class TestAdminService {
	TestService testService=new TestServiceImplementation();
	
	@GET
	@Path("/getTestsOfUser/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Test> getAllTestsOfUser(@PathParam("id") int id){
		List<Test> tests=testService.getTestsByUserId(id);
		 List<TestForAdmin> list=new ArrayList<TestForAdmin>();
		 for(Test t:tests){
			 TestForAdmin newTest=new TestForAdmin();
			 newTest.setTestId(t.getTestId());
			 newTest.setEndDate(t.getEndDate());
			 newTest.setName(t.getName());
			 newTest.setQuestions(t.getQuestions());
			 newTest.setStartDate(t.getStartDate());
			 list.add(newTest);
		 }
		 return tests;
	}
	
	@POST
	@Path("/makeAvailable")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response makeTestAvailable(int id){
		Test test=testService.getTestById(id);
		test.setAvailable(true);
		testService.updateTest(test);
		return Response.status(201).entity(test).build();
	}
	
	
	
	@POST
	@Path("/makeUnavailableAndClosed")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response makeTestClosedAndUnavailable(int id){
		Test test=testService.getTestById(id);
		test.setAvailable(false);
		test.setOpened(false);
		testService.updateTest(test);
		return Response.status(201).entity(test).build();
	}
	
	
	
	
	
}
