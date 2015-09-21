package chapter4;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ReadCookie extends HttpServlet {
	
	protected Cookie getCookieValue(Cookie[] cookies, String name){
		if(cookies != null){
			for(Cookie c:cookies){
				if(c.getName().equals(name))
					return c;
			}
		}
		return null;
	}
	
	public void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		Cookie tempCookie = getCookieValue(request.getCookies(), "temp");
		if(tempCookie != null)
			out.println("临时Cookie值:" + tempCookie.getValue() + "<br/>");
		else
			out.println("临时Cookie未设置!<br/>");
		
		Cookie cookie = getCookieValue(request.getCookies(), "cookie");
		if(cookie != null)
			out.println("cookie: " + cookie.getValue() + "<br/>");
		else
			out.println("cookie已经被删除！<br/>");
		
		Cookie userCookie = getCookieValue(request.getCookies(), "user");
		if(userCookie != null)
			out.println("user: " + userCookie.getValue());
		else
			out.println("user未设置！ ");
	}

}
