package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.EmailSessonBean;

import javax.ejb.EJB;

/**
 * Servlet implementation class EmailServlet
 */
@WebServlet(name = "EmailServlet", urlPatterns = {"/EmailServlet"})
public class EmailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private EmailSessonBean emailBean;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmailServlet() {
        super();
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String email =request.getParameter("email");
		String phone = request.getParameter("phone");
		String message = request.getParameter("message");
		String to = request.getParameter("to");
			
		emailBean.sendEmail(to);
		
		response.setContentType("text/html;charset=UTF=8");
		PrintWriter out = response.getWriter();
		
		try{
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Servlet EmailServlet</title>");
			out.println("</head>");
			out.println("<h1>Form Submitted</h1>");
			out.println("</body>");
			out.println("</html>");
		}finally{
			out.close();
		}
		
		
		
}
}	