package com.campusevent.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import com.campusevent.connection.DBConnection;

public class AdminDao {

	public boolean isEventNameTaken(String eventName) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from event_info where eventName = '" + eventName + "'";
		Boolean result = false;

		con = DBConnection.getConnection();
		ps = con.prepareStatement(sql);
		rs = ps.executeQuery();

		if (rs != null && rs.next()) {
			con.close();
			result = true;
		}

		con.close();
		return result;
	}

	public boolean saveEventNameDetails(String eventName, double latitude, double longitude, Date time) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String query = "insert into event_info(eventName, latitude, longitude, time) values(?,?,?,?)";

		con = DBConnection.getConnection();
		ps = con.prepareStatement(query);

		ps.setString(1, eventName);
		ps.setDouble(2, latitude);
		ps.setDouble(3, longitude);
		ps.setTimestamp(4, new Timestamp(time.getTime()));

		result = ps.executeUpdate();

		System.out.println("Result : " + result);

		con.close();

		if (result > 0) {
			return true;
		}

		return false;
	}
}