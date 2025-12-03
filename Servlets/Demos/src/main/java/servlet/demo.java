package servlet;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/demo")
public class demo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out =  response.getWriter();
		response.setContentType("text/html");
		out.println("<html>");
		out.println("</body>");
		out.print("<h1>Hello World</h1>");
		out.println("</body></html>");
		out.close();
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
