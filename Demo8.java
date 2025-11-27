//create a function for addition of two numbers 
//write java code to execute that function



package JDBC;

import java.sql.*;
import java.util.Scanner;


public class Demo8 {

	

	

	public static void main(String[] args) {
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con  = DriverManager.getConnection("jdbc:mysql://localhost:3306/company?useSSL=false","root","YOUR_PASSWORD");
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter Two Number : ");
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			CallableStatement cst  = con.prepareCall("{?=call add_no(?,?)}");

			cst.registerOutParameter(1,Types.INTEGER);
			cst.setInt(3, x);
			cst.setInt(2, y);
			cst.execute();
			
			System.out.println("Addition of two no  is :  "  + cst.getInt(1));
			con.close();
			
			
			
			
			
			
			
			
			
		}
		catch(Exception Ex) {
			System.out.println(Ex);
		}
	}

}

