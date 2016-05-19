package com.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SearchRedirectServlet")
public class SearchRedirectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SearchRedirectServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String goToSearchByNPPage = request.getParameter("searchNPTable");
		
		System.out.println(goToSearchByNPPage);

		if (!(goToSearchByNPPage.equals(null))) {

			try {
				request.getRequestDispatcher("/WEB-INF/searchnptable.jsp").forward(request, response);

			} catch (NullPointerException e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
				request.getRequestDispatcher("/WEB-INF/searchdevtable.jsp").forward(request, response);
			}

		} else {
			request.getRequestDispatcher("index.jsp");
		}

//		if (!(goToSearchByDevPage.equals(null))) {
//
//			try {
//				
//
//			} catch (NullPointerException e) {
//				e.printStackTrace();
//				System.out.println(e.getMessage());
//				request.getRequestDispatcher("index.jsp");
//			}
//
//		} else {
//			request.getRequestDispatcher("index.jsp");
//		}

		// doGet(request, response);
	}

}
