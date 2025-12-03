

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/loginservlet")
public class loginservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		
		 String s1 = request.getParameter("t1");
		 String s2 = request.getParameter("t2");
		 
		 
		 if(s1.equals("admin") && s2.equals("admin")) {
			 RequestDispatcher rd = request.getRequestDispatcher("loginservlet1");
			 rd.forward(request, response);
			
		 }
		 else {
			 out.println("<h3>login failed...</h3>");
			 
			 RequestDispatcher rd = request.getRequestDispatcher("login.html");
			 rd.forward(request, response);
			 
		 }
		 
		 out.close();
		
	}

}
