package com.servletpkg;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.HandleIT.NonProfObj;

@WebServlet("/NonProfServlet")
public class NonProfServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	NonProfObj npToAddToDB = new NonProfObj();
	NonProfObj searchANP = new NonProfObj();

	public NonProfServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String theContactPerson = request.getParameter("form-contact_person");

		try {
			
			String[] theFocus = request.getParameterValues("focus");
			String[] theProjectType = request.getParameterValues("project_type");

			if (!(theContactPerson.equals(null))) {

				npToAddToDB.setName(request.getParameter("form-name"));
				npToAddToDB.setPassword(request.getParameter("form-password"));
				npToAddToDB.setLink(request.getParameter("form-link"));
				npToAddToDB.setContactPerson(request.getParameter("form-contact_person"));
				npToAddToDB.setEmailAddress(request.getParameter("form-email"));
				npToAddToDB.setLocation(request.getParameter("form-location"));
				npToAddToDB.setFocus(Arrays.toString(theFocus));
				npToAddToDB.setProjectType(Arrays.toString(theProjectType));
				npToAddToDB.setProjectDescription(request.getParameter("form-project_description"));

				System.out.println("Collected a NP table entry.");

				NonProfConn.writeToNPTable(npToAddToDB);

				if (NonProfConn.passOrFail) {
					response.sendRedirect("nplogin.jsp");
					System.out.println("Np has been added to the db.");
				}
			}

		} catch (NullPointerException e) {

			boolean foundANP;

			String searchByProjects = request.getParameter("project_type");
			String searchByFocus = request.getParameter("focus");

			System.out.println(searchByProjects + " & " + searchByFocus);

			foundANP = NonProfConn.searchForANP(searchByProjects, searchByFocus);

			if (foundANP) {
				response.sendRedirect("readnptable.jsp");
			}
		}
	}
}
