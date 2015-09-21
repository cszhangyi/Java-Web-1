package chapter4;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestPrintWriter extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		response.setContentType("text/html; charset=utf-8");
		response.setHeader("myhead1", "value1");
		PrintWriter out = response.getWriter();
		response.setHeader("Content-type", "text/html; charset=utf-8");
		response.setHeader("myhead2", "value2");
		out.println("<b>œÏ”¶œ˚œ¢</b>");
		
	}

}
