package chapter4;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IncludingServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		response.setContentType("text/html; charset=gb2312");
		PrintWriter out = response.getWriter();
		out.println("ÖÐ¹ú<br/>");
		out.println("IncludingServlet URI:" + request.getRequestURI() + "<p/>");
		RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/servlet/IncludedServlet");
		rd.include(request, response);
		rd = getServletContext().getRequestDispatcher("/chapter4/IncludedHtml.html");
		rd.include(request, response);
	}

}
