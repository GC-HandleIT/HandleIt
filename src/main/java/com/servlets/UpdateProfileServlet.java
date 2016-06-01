package com.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

		String updateNPProfile = request.getParameter("updateNPTable");

		try {
			if (!(updateNPProfile.equals(null))) {
				request.getRequestDispatcher("/WEB-INF/updatenptable.jsp").forward(request, response);
			}

		} catch (NullPointerException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			request.getRequestDispatcher("/WEB-INF/updatedevtable.jsp").forward(request, response);
		}
	}
}
