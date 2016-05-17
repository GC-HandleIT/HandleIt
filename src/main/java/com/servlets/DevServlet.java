package com.servlets;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.HandleIT.Developer;
import com.dao.DevDAO;

@WebServlet("/DevServlet")
public class DevServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Developer devToAddToDB = new Developer();
	Developer searchADev = new Developer();

	public DevServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String theFirstName = request.getParameter("form-first_name");

		try {

			if (!(theFirstName.equals(null))) {
				
				String[] projectTypes = request.getParameterValues("project_type");
				String[] skillTypes = request.getParameterValues("skills");
				
				devToAddToDB.setFirstName(request.getParameter("form-first_name"));
				devToAddToDB.setLastName(request.getParameter("form-last_name"));
				devToAddToDB.setPassword(request.getParameter("form-password"));
				devToAddToDB.setEmailAddress(request.getParameter("form-email_address"));
				devToAddToDB.setLocation(request.getParameter("form-location"));
				devToAddToDB.setPicUrl(request.getParameter("form-picture_url"));
				devToAddToDB.setProfileUrl(request.getParameter("form-profile_url"));
				devToAddToDB.setProjects(Arrays.toString(projectTypes));
				devToAddToDB.setSkills(Arrays.toString(skillTypes));

				System.out.println("Collected a dev table entry.");

				DevDAO.writeToDevTable(devToAddToDB);

				if (com.dao.DevDAO.passOrFail) {
					response.sendRedirect("devlogin.jsp");
					System.out.println("Dev has been added to the db.");
				}
			}
 
		} catch (NullPointerException e) {

			boolean foundADev;

			String searchByProjects = request.getParameter("project_type");
			String searchBySkills = request.getParameter("skill_sets");

			System.out.println(searchByProjects);
			System.out.println(searchBySkills);

			foundADev = DevDAO.searchForADev(searchByProjects, searchBySkills);

			if (foundADev) {
				response.sendRedirect("readdevtable.jsp");
			}
		}
	}
}
