package com.campusevent.service;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.campusevent.dao.AdminDao;

public class AdminService {
	AdminDao adminDao = new AdminDao();

	public Map<String, String> addEvent(String eventName, String latitude, String longitude, String date, String time) {
		Map<String, String> resultMap = new HashMap<String, String>();

		try {
			boolean isEvenNameTaken = adminDao.isEventNameTaken(eventName);

			if (isEvenNameTaken) {
				resultMap.put("result", "error");
				resultMap.put("message", "Event Name already taken, please enter another Event Name!!!");
			} else {
				String completeTimeAndDate = date + " " + time;
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy HH:mm");

				Date timeStamp = sdf.parse(completeTimeAndDate);

				boolean eventAdded = adminDao.saveEventNameDetails(eventName, Double.parseDouble(latitude), Double.parseDouble(longitude), timeStamp);

				if (eventAdded) {
					resultMap.put("result", "success");
					resultMap.put("message", "Event added successfully!!!");
				} else {
					resultMap.put("result", "error");
					resultMap.put("message", "Unable to add the Event!!!");
				}
			}
		} catch (SQLException e) {
			resultMap.put("result", "error");
			resultMap.put("message", "Some error occured : " + e.getMessage());
		} catch (NumberFormatException nfe) {
			resultMap.put("result", "error");
			resultMap.put("message", "Please enter proper inputs");
		} catch (ParseException e) {
			resultMap.put("result", "error");
			resultMap.put("message", "Some error occured : " + e.getMessage());
		}

		return resultMap;
	}
}