package com.campuseventtrackersystem.proxy;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.campuseventtrackersystem.dao.EventTrackerDao;
import com.google.gson.Gson;

public class EventTrackerProxy {

	EventTrackerDao dao = new EventTrackerDao();
	Gson gson = new Gson();

	public Map<String, Object> getAllEventsInfo() {
		Map<String, Object> resultMap = new HashMap<>();
		try {
			List<Map<String, Object>> eventInfoList = dao.getAllEventsInfo();

			if (eventInfoList == null) {
				resultMap.put("Result", "Error");
				resultMap.put("Message", "No car available");
				return resultMap;
			}

			resultMap.put("Result", "Success");
			resultMap.put("eventList", eventInfoList);
		} catch (SQLException e) {
			resultMap.put("Result", "Error");
			resultMap.put("Message", "DB Connection error");
			resultMap.put("Exception", e.getMessage());
		}

		return resultMap;
	}
}