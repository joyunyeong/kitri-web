package com.kitri.hello;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();		
		response.setContentType("text/html;charset=UTF-8");
		out.println("<html>");
		out.println("	<body>");
		out.println("	Hello Servlet!!!<br>");
		out.println("	안녕 서블릿!!!");
		out.println("	</body>");
		out.println("</html>");
	}

}
