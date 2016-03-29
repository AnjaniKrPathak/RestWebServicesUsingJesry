package com.anjani.restjersey;

import org.springframework.web.client.RestTemplate;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class RestManagerClient {
	public static void main(String[] args) {
		Client client=Client.create();
		String url="http://localhost:8088/RESTJerseyExample/anjani/ktogservice/20";
		WebResource webResource=client.resource("http://localhost:8088/RESTJerseyExample/anjani/ktogservice/20");
		ClientResponse clientResponse=webResource.accept("application/json").get(ClientResponse.class);
		if(clientResponse.getStatus()!= 200){
			throw new RuntimeException("Failed HTTP request "+clientResponse.getStatus());
			
		}
		String output=clientResponse.getEntity(String.class);
		//System.out.println("Output from Server .... \n");
		//System.out.println(output);
		consumeWebServiceUsingRestTemplate(url);
	}

	private static void consumeWebServiceUsingRestTemplate(String url) {
		// TODO Auto-generated method stub
		RestTemplate restTemplate=new RestTemplate();
		String response=restTemplate.getForObject(url, String.class);
		System.out.println("Using Rest template "+response);
	}

}
