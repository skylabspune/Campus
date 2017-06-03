package com.campuseventtrackersystem.service;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.campuseventtrackersystem.proxy.EventTrackerProxy;
import com.google.gson.Gson;

@Path("/eventtracker")
public class EventTrackerService {

	Gson gson = new Gson();
	EventTrackerProxy proxy = new EventTrackerProxy();

	@GET
	@Path("/getallevents")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllEventsInfo() {
		Map<String, Object> result = new HashMap<>();

		result = proxy.getAllEventsInfo();

		if (result.containsValue("Success")) {
			return Response.ok(200).entity(gson.toJson(result)).build();
		}

		return Response.status(500).entity(gson.toJson(result)).build();

	}
}