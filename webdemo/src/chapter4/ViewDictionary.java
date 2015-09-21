package chapter4;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewDictionary extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		try {
			javax.naming.Context ctx = new javax.naming.InitialContext();
			javax.sql.DataSource ds = (javax.sql.DataSource) ctx
					.lookup("java:/comp/env/jdbc/webdb");
			Connection conn = ds.getConnection();
			PreparedStatement pstmt = conn
					.prepareStatement("select * from t_dictionary");
			ResultSet rs = pstmt.executeQuery();
			StringBuilder table = new StringBuilder();
			table.append("<table border='1'>");
			table.append("<tr><td>书名</td><td>价格</td></tr>");
			while (rs.next()) {
				table.append("<tr><td>" + rs.getString("english") + "</td><td>");
				table.append(rs.getString("chinese") + "</td></tr>");
			}
			table.append("</table>");
			out.println(table.toString());
			pstmt.close();

		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
