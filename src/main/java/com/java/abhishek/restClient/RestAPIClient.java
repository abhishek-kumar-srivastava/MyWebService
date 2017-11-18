package com.java.abhishek.restClient;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.koushik.javabrains.messenger.model.Message;

public class RestAPIClient {
	public static void main(String[] args) {
		
		Client client=ClientBuilder.newClient();
		/*Response response=client.target("http://localhost:8090/advanced-jaxrs-2/webapi/messages/1").request().get();
		Message message=response.readEntity(Message.class);
		System.out.println(message.getMessage());
		*/
		
		WebTarget baseTarget=client.target("http://localhost:8090/advanced-jaxrs-2/webapi/");
		WebTarget messageTarget=baseTarget.path("messages");
		WebTarget singleMessageTarget=messageTarget.path("{messageId}");
		
	/*	Message message1=singleMessageTarget.resolveTemplate("messageId","1")
				         .request(MediaType.APPLICATION_JSON).get(Message.class);
		
		Message message2=singleMessageTarget.resolveTemplate("messageId","2")
		         .request(MediaType.APPLICATION_JSON).get(Message.class);
		System.out.println(message1.getMessage());
		System.out.println(message2.getMessage()); */
		
		Message message=new Message(4, "Hi Abhishek", "Ansu");
		Response response=messageTarget.request().post(Entity.json(message));
		if(response.getStatus() !=201){
			System.out.println("Error !!!");
		}
		System.out.println(response.readEntity(Message.class).getMessage());	         
		
	}

}
