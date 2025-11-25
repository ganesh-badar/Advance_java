//a java program to accept emp_id from user an upate name & salary
package JDBC;

import java.sql.*;
import java.util.Scanner;

public class Demo4 {

	public static void main(String[] args) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/company?useSSL=false","root","YOUR_PASSWORD");
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter emp_id , name and salary");
			int emp_id = sc.nextInt();
			String nm= sc.next();
			Float sal = sc.nextFloat();
			
			PreparedStatement pst = con.prepareStatement("Update employees set first_name = ? , salary = ? where id = ?");
			pst.setString(1, nm);
			pst.setFloat(2, sal);
			pst.setInt(3, emp_id);
			int rows = pst.executeUpdate();
			if(rows>0) {
				System.out.println("Updated....");
			}
			else {
				System.out.println("Sorry... emp not present...");
			}
			con.close();
			
		}
		catch(Exception Ex) {
			System.out.println(Ex);
		}
		

	}

}

