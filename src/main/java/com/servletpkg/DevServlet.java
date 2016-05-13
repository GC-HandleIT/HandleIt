package com.servletpkg;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.HandleIT.DevObj;

@WebServlet("/DevServlet")
public class DevServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	DevObj devToAddToDB = new DevObj();
	DevObj searchADev = new DevObj();

	public DevServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String theID = request.getParameter("form-id");

		try {

			if (!(theID.equals(null))) {

				devToAddToDB.setId(request.getParameter("form-id"));
				devToAddToDB.setFirstName(request.getParameter("form-first_name"));
				devToAddToDB.setLastName(request.getParameter("form-last_name"));
				devToAddToDB.setPassword(request.getParameter("form-password"));
				devToAddToDB.setEmailAddress(request.getParameter("form-email_address"));
				devToAddToDB.setLocation(request.getParameter("form-location"));
				devToAddToDB.setPicUrl(request.getParameter("form-picture_url"));
				devToAddToDB.setProfileUrl(request.getParameter("form-profile_url"));
				devToAddToDB.setProjects(request.getParameter("form-projects"));
				devToAddToDB.setSkills(request.getParameter("form-skills"));

				System.out.println("Collected a dev table entry.");

				DevConn.writeToDevTable(devToAddToDB);

				if (DevConn.passOrFail) {
					response.sendRedirect("writedevtable.html");
					System.out.println("Dev has been added to the db.");
				}
			}

		} catch (NullPointerException e) {

			boolean foundADev;

			String searchByProjects = request.getParameter("project_type");
			String searchBySkills = request.getParameter("skill_sets");

			System.out.println(searchByProjects);
			System.out.println(searchBySkills);

			foundADev = DevConn.searchForADev(searchByProjects, searchBySkills);

			if (foundADev) {
				response.sendRedirect("readdevtable.jsp");
			}
		}
	}
}
