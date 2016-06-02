package com.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/NPRedirectServlet")
public class NPRedirectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public NPRedirectServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String goToSearchByDevPage = request.getParameter("searchDevTable");
		System.out.println(goToSearchByDevPage);

		if (!(goToSearchByDevPage.equals(null))) {

			try {
				request.getRequestDispatcher("/WEB-INF/searchdevtable.jsp").forward(request, response);

			} catch (NullPointerException e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
			}

		} else {
			request.getRequestDispatcher("index.jsp");
		}

	}

}
