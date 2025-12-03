package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/updateservlet")
public class updateservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		String uname1 = request.getParameter("t1");
		String pwd1 = request.getParameter("t2");
		String npwd1 = request.getParameter("t3");
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/userlogin?useSSL=false", "root", "Ganesh@1351");
			
			PreparedStatement pst = con.prepareStatement("UPDATE login set pwd=? where uname=? and pwd=?");
			pst.setString(1, npwd1);
			pst.setString(2, uname1);
			pst.setString(3, pwd1);
			
			
			int i = pst.executeUpdate();

			if(i > 0) {
			    out.println("<h1>Password Updated Successfully</h1>");
			} else {
			    out.println("<h1>Invalid Username or Old Password</h1>");
			}

			
			con.close();
			out.close();
			
		}
		catch(Exception ex) 
		{
			System.out.println(ex);
		}
}
}