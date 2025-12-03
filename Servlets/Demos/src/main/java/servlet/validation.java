package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/validation")
public class validation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public validation() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out  =response.getWriter();
		response.setContentType("text/html");
		
		String uname1 = request.getParameter("t1");
		String pwd1 = request.getParameter("t2");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con  = DriverManager.getConnection("jdbc:mysql://localhost:3306/userlogin?useSSL=false","root","Ganesh@1351");
			PreparedStatement pst = con.prepareStatement("select * from login where uname=? and pwd=?");
			pst.setString(1, uname1);
			pst.setString(2, pwd1);
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()) {
				out.print("<h1>Welcome : "+uname1+ "</h1>");
			}
			else {
				out.print("<h1>Login Failed</h1>");
			}
			
			out.close();
			rs.close();	
			con.close();
		}
		catch(Exception ex){
			System.out.println(ex);
		}
	}

}
