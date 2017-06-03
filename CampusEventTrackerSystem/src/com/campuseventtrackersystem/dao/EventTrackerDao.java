package com.campuseventtrackersystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.campuseventtrackersystem.connection.DBConnection;

public class EventTrackerDao {

	public List<Map<String, Object>> getAllEventsInfo() throws SQLException {

		List<Map<String, Object>> lst_events = new ArrayList<>();

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from event_info";

		con = DBConnection.getConnection();
		ps = con.prepareStatement(sql);

		rs = ps.executeQuery();

		while (rs.next()) {
			Map<String, Object> eventInfo = new HashMap<String, Object>();

			eventInfo.put("eventd", rs.getInt(1));
			eventInfo.put("latitude", rs.getDouble(2));
			eventInfo.put("Longitude", rs.getDouble(3));

			Timestamp eventEntireDate = rs.getTimestamp(4);
			if (eventEntireDate != null) {
				String eventDateTimeStr = eventEntireDate.toString();

				eventInfo.put("date", eventDateTimeStr.substring(0, 10));
				eventInfo.put("time", eventDateTimeStr.substring(11, eventDateTimeStr.length()));
			}

			eventInfo.put("eventName", rs.getString(5));

			lst_events.add(eventInfo);
		}

		con.close();

		return lst_events;
	}
}