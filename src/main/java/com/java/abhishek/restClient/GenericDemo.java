package com.java.abhishek.restClient;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import org.koushik.javabrains.messenger.model.Message;

public class GenericDemo {
	public static void main(String[] args) {
		Client client=ClientBuilder.newClient();
		List<Message> messages=client
				.target("http://localhost:8090/advanced-jaxrs-2/webapi/")
				.path("messages")
				.queryParam("year", 2017)
				.request(MediaType.APPLICATION_JSON)
				.get(new GenericType<List<Message>>(){});
		System.out.println(messages);
		
		
	}

}
