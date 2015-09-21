package chapter4;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowImage extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		response.setContentType("image/jpeg");
		OutputStream os = response.getOutputStream();
		byte[] buffer = new byte[8192];
		
		String imageName= request.getParameter("name");
		FileInputStream fis = new FileInputStream(imageName);
		int count = 0;
		while(true){
			count = fis.read(buffer);
			if(count<=0){
				break;
			}
			os.write(buffer, 0, count);
		}
		fis.close();
	}

}
