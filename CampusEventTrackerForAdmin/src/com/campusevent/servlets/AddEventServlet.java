package com.campusevent.servlets;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.campusevent.service.AdminService;

public class AddEventServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	AdminService adminService = new AdminService();

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, NumberFormatException {
		System.out.println("Inside add employee method");
		String eventName = request.getParameter("eventName");
		String latitude = request.getParameter("latitude");
		String longitude = request.getParameter("longitude");
		String date = request.getParameter("date");
		String hour = request.getParameter("hour");
		String min = request.getParameter("min");

		String time = hour + ":" + min;

		Map<String, String> result = adminService.addEvent(eventName, latitude, longitude, date, time);

		if (result.containsValue("success")) {
			RequestDispatcher rd = request.getRequestDispatcher("admin.jsp");
			request.setAttribute("message", result.get("message"));
			rd.forward(request, response);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("admin.jsp");
			request.setAttribute("error", result.get("message"));
			rd.forward(request, response);
		}
	}
}
