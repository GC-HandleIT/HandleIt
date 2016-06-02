package com.servlets;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.HandleIT.Developer;
import com.HandleIT.NonProfit;
import com.dao.DevDAO;
import com.dao.NonProfitDAO;

@WebServlet("/UpdateProfileServlet")
public class UpdateProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UpdateProfileServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Developer devToUpdate = new Developer();

		String devOrNP = request.getParameter("update-first_name");

		try {

			if (!(devOrNP.equals(null))) {

				String verifyEmail = request.getParameter("verify-email_address");
				String verifyPass = request.getParameter("verify-password");

				// Collecting and formating project types and skills w/o
				// brackets
				String[] projectTypes = request.getParameterValues("update-project_type");
				String projectTypesString = Arrays.toString(projectTypes);
				String projectTypesSubString = projectTypesString.substring(1, projectTypesString.length() - 1);

				String[] skillTypes = request.getParameterValues("update-skills");
				String skillsTypesString = Arrays.toString(skillTypes);
				String skillsTypesSubString = skillsTypesString.substring(1, skillsTypesString.length() - 1);

				System.out.println(skillsTypesSubString);

				// adding the collected form data to the DB
				devToUpdate.setFirstName(request.getParameter("update-first_name"));
				devToUpdate.setLastName(request.getParameter("update-last_name"));
				devToUpdate.setPassword(request.getParameter("update-password"));
				devToUpdate.setEmailAddress(request.getParameter("update-email_address"));
				devToUpdate.setLocation(request.getParameter("update-location"));
				devToUpdate.setProfileUrl(request.getParameter("update-profile_url"));
				devToUpdate.setProjects(projectTypesSubString);
				devToUpdate.setSkills(skillsTypesSubString);

				System.out.println("Collected a dev update entry.");

				DevDAO.updateDevTable(devToUpdate, verifyEmail, verifyPass);

				if (com.dao.DevDAO.passOrFail) {
					response.sendRedirect("devlogin.jsp");
					System.out.println("Dev has been added to the db.");
				}
			}

		} catch (NullPointerException e) {

			String verifyEmail = request.getParameter("verify-email_address");
			String verifyPass = request.getParameter("verify-password");

			// Collecting and formating project types and skills w/o brackets
			String[] theFocus = request.getParameterValues("update-focus");
			String focusString = Arrays.toString(theFocus);
			String focusSubString = focusString.substring(1, focusString.length() - 1);

			String[] theProjectType = request.getParameterValues("update-project_type");
			String projectTypeString = Arrays.toString(theProjectType);
			String projectTypeSubString = projectTypeString.substring(1, projectTypeString.length() - 1);

			NonProfit npToUpdate = new NonProfit();

			npToUpdate.setName(request.getParameter("update-name"));
			npToUpdate.setPassword(request.getParameter("update-password"));
			npToUpdate.setLink(request.getParameter("update-link"));
			npToUpdate.setContactPerson(request.getParameter("update-contact_person"));
			npToUpdate.setEmailAddress(request.getParameter("update-email"));
			npToUpdate.setLocation(request.getParameter("update-location"));
			npToUpdate.setFocus(focusSubString);
			npToUpdate.setProjectType(projectTypeSubString);
			npToUpdate.setProjectDescription(request.getParameter("update-project_description"));

			System.out.println("Collected a NP table entry.");

			NonProfitDAO.updateNpTable(npToUpdate, verifyEmail, verifyPass);

			if (com.dao.NonProfitDAO.passOrFail) {
				response.sendRedirect("nplogin.jsp");
				System.out.println("Np has been added to the db.");
			}
		}
	}
}
