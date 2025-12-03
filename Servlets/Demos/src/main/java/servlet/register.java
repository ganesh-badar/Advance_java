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


@WebServlet("/register")
public class register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public register() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out  =response.getWriter();
		response.setContentType("text/html");
		
		String userid1 = request.getParameter("uid");
		String uname = request.getParameter("uname");
		String pwd1 = request.getParameter("pwd");
		String add1 =request.getParameter("add");
		String contact=request.getParameter("cnt");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con  = DriverManager.getConnection("jdbc:mysql://localhost:3306/userlogin?useSSL=false","root","Ganesh@1351");
			PreparedStatement pst = con.prepareStatement("select * from info where user_id=?");
			pst.setString(1, userid1);
			
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()) {
				out.print("<h1>Welcome : "+uname+ "</h1>");
			}
			else {

				PreparedStatement pst1 = con.prepareStatement("insert into info values (?,?,?,?,?)");
				pst1.setString(1,userid1);
				pst1.setString(2, uname);
				pst1.setString(3,pwd1);
				pst1.setString(4, add1);
				pst1.setString(5, contact);
				pst1.executeUpdate();
				out.print("<h1>Registration Done...</h1>");
				
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
