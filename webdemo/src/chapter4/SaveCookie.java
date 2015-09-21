package chapter4;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SaveCookie extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws 
	ServletException, IOException{
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		Cookie tempCookie = new Cookie("temp", "87654321");
		response.addCookie(tempCookie);
		
		Cookie cookie = new Cookie("cookie", "6666");
		cookie.setMaxAge(0);
		response.addCookie(cookie);
		
		String user = request.getParameter("user");
		
		if(user!= null){
			Cookie userCookie = new Cookie("user", user);
			userCookie.setMaxAge(60*60*24);
			userCookie.setPath("/");
			response.addCookie(userCookie);
		}
		RequestDispatcher readCookie = getServletContext().getRequestDispatcher("/servlet/ReadCookie");
		readCookie.include(request, response);
	}

}
