package com.java.abhishek.restClient;

import java.io.IOException;
import java.util.List;
import java.util.StringTokenizer;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import org.glassfish.jersey.internal.util.Base64;

@Provider
public class SecuredFilter implements ContainerRequestFilter {
    private final static String Authorization_Header_Key="Authorization";
    private final static String Authorization_Header_Prefix="Basic";
    private final static String Secured_URL="secured";
    
	
	
	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		if(requestContext.getUriInfo().getPath().contains(Secured_URL)){
	  List<String> authHeader=requestContext.getHeaders().get(Authorization_Header_Key);
	  if(authHeader !=null && authHeader.size() > 0){
		  String authToken=authHeader.get(0);
		  authToken=authToken.replaceFirst(Authorization_Header_Prefix,"");
		  String decodedString=Base64.decodeAsString(authToken);
		  StringTokenizer tokenizer=new StringTokenizer(decodedString,":");
		  String username=tokenizer.nextToken();
		  
		  String password=tokenizer.nextToken();
		  
		  if("user".equals(username) && "password".equals(password)){
			  return;
		  }
		  
		  Response unAuthorizedStatus=Response.status(Response.Status.UNAUTHORIZED).entity("User cannot access the resource")
		       .build();
		  
		  requestContext.abortWith(unAuthorizedStatus);
		  
	  }
		}
	}

}
