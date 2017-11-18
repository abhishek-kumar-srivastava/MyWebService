package com.java.abhishek.customMedia;



import java.util.Calendar;
import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("test2")
public class MyResource {
	
	@GET
	@Produces("text/shortdate")
	public Date getMessage(){
		return Calendar.getInstance().getTime();
	}

}
