package com.java.abhishek;

import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("{value}/test")
public class MyResource {
	@PathParam("value") private String pathParamExample;
	@QueryParam("query")private String queryParamExample;
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getMessage(){
		
		return "Its Works "+"pathParamExample "+pathParamExample+ "queryParamExample "+queryParamExample;
	}

}
