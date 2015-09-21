package chapter4;


import java.io.IOException;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ExploreResponseHeader extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		
		response.setContentType("text/html;charset=UTF-8");
		response.setHeader("Content-Length", "1234");
		response.addHeader("NEWField1", "value1");
		
		Calendar cal = Calendar.getInstance();
		cal.set(2014, 8, 01);
		response.addDateHeader("MyDate", cal.getTimeInMillis());
		response.setIntHeader("NewField2", 3000);
		
	}

}
