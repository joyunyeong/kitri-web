package com.kitri.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/counter")
public class Counter extends HttpServlet {
	private static final long serialVersionUID = 1L;

	int cnt;
	
	public void init() {
		cnt = 0;
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		cnt++;
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("	<body>");
		out.println("당신은 ");
		
		out.println("<img src=\"/basicservlet/img/0.png\" width=\"50\">");
		
		out.println("번째 방문자입니다.");
		out.println("	</body>");
		out.println("</html>");
	}


}
