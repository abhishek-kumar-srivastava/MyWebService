package com.java.abhishek.restClient;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.koushik.javabrains.messenger.model.Message;

public class InvocationDemo {
	public static void main(String[] args) {
		InvocationDemo demo=new InvocationDemo();
		Invocation invocation=demo.prepareRequestforMessagesByYear(2017);
		Response response=invocation.invoke();
		System.out.println(response.readEntity(Message.class).getMessage());
		
	}

	private  Invocation prepareRequestforMessagesByYear(int year) {
		Client client=ClientBuilder.newClient();
		WebTarget target=client
				.target("http://localhost:8090/advanced-jaxrs-2/webapi/")
				.path("messages");
		return target.queryParam("year", year).request(MediaType.APPLICATION_JSON)
		.buildGet();
		
		
	}

}
