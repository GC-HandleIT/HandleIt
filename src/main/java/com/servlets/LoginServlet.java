package com.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.HandleIT.Developer;
import com.HandleIT.NonProfit;
import com.dao.DevDAO;
import com.dao.NonProfitDAO;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Developer loginDev = new Developer();
	NonProfit loginNP = new NonProfit();

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

				boolean lostOrFound = DevDAO.devLoginSearch(loginDev);

				if (lostOrFound) {
					System.out.println("Dev was found and redirected to profile.");
					HttpSession session = request.getSession();
					session.setAttribute("user", true);
					request.getRequestDispatcher("/WEB-INF/developerportal.jsp").forward(request, response);

				} else {
					response.sendRedirect("index.jsp");
					System.out.println("Invalid user, please try again.");
				}
			}

		} catch (NullPointerException e) {

			try {

				if (!(itsANP.equals(null))) {

					loginNP.setEmailAddress(request.getParameter("form-np_login_email"));
					loginNP.setPassword(request.getParameter("form-np_login_password"));

					System.out.println("Collected NP to login");

					boolean lostOrFound = NonProfitDAO.npLoginSearch(loginNP);

					if (lostOrFound) {
						System.out.println("Success, redirected to search.");
						HttpSession session = request.getSession();
						session.setAttribute("user", true);
						request.getRequestDispatcher("/WEB-INF/nonprofitportal.jsp").forward(request, response);
						System.out.println("NP was found and redirected.");

					} else {
						response.sendRedirect("index.jsp");
						System.out.println("Invalid user, please try again.");
					}
				}

			} catch (NullPointerException ex) {
				response.sendRedirect("index.jsp");
				System.out.println("Something went quite wrong");
			}

		}

	}
}
