package com.android;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.domain.StudentAnswer;
import com.service.providers.StudentAnswerImplementation;
import com.service.providers.StudentAnswerService;

@Path("/test/answer")
public class AnswerService {
	
	StudentAnswerService service=new StudentAnswerImplementation();
	
	
	@POST
	@Path("/studentAnswer")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response sendAnswer(StudentAnswer answer){
		service.addStudentAnswer(answer);
		
		
		return Response.status(201).entity(answer).build();
	}

}
