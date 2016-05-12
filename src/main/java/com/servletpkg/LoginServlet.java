package com.servletpkg;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.HandleIT.DevObj;
import com.HandleIT.NonProfObj;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	DevObj loginDev = new DevObj();
	NonProfObj loginNP = new NonProfObj();

	public LoginServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String itsADev = request.getParameter("form-dev_login_email");
		String itsANP = request.getParameter("form-np_login_email");

		try {

			if (!(itsADev.equals(null))) {

				loginDev.setEmailAddress(request.getParameter("form-dev_login_email"));
				loginDev.setPassword(request.getParameter("form-dev_login_password"));

				System.out.println("Collected Dev to login.");

				boolean lostOrFound = DevConn.devLoginSearch(loginDev);

				if (lostOrFound) {
					response.sendRedirect("searchnptable.html");
					System.out.println("Dev was found and redirected to search.");

				} else {
					response.sendRedirect("index.html");
					System.out.println("Invalid user, please try again.");
				}
			}

		} catch (NullPointerException e) {

			try {

				if (!(itsANP.equals(null))) {

					loginNP.setEmailAddress(request.getParameter("form-np_login_email"));
					loginNP.setPassword(request.getParameter("form-np_login_password"));

					System.out.println("Collected NP to login");

					NonProfConn.npLoginSearch(loginNP);

					response.sendRedirect("searchdevtabe.html");
					System.out.println("NP was found and redirected.");
				}

			} catch (NullPointerException ex) {
				response.sendRedirect("index.html");
				System.out.println("Something went quite wrong");
			}

		}

	}
}