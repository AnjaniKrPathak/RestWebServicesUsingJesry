package com.crunchify.restjersey;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONObject;

@Path("ktogservice")
public class KtoGService {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response convertKtoG(){
		JSONObject jsonObject=new JSONObject();
		int kilogram=5;
		int gram;
		gram=kilogram*1000;
		jsonObject.put("Kg value", kilogram);
		jsonObject.put("Gram value", gram);
		String result="@Produces(\"application/json\") Output: \n\nKg to Gram Converter Output: \n\n "+jsonObject;
		return Response.status(200).entity(result).build();
	}
	@Path("{kg}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response convertKtoGFromInput(@PathParam("kg") int kg){
		JSONObject jsonObject=new JSONObject();
		int gram;
		gram=kg*1000;
		jsonObject.put("Kg value", kg);
		jsonObject.put("Gram Value", gram);
		String result=" @Produces(\"application/json\") Kg to Gram Converter Output using user input : \n\n"+jsonObject;
		return Response.status(200).entity(result).build();
		
	}

}
