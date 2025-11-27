//create a procedure which accept employee_id as input parrameter and name as output parameter
//write java program to execute that procedure

package JDBC;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;
import java.util.Scanner;

public class Demo7 {

	public static void main(String[] args) {
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection
			("jdbc:mysql://localhost:3306/company?useSSL=false", "root","YOUR_PASSWORD");
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter emp id=");
			int eid=sc.nextInt();
			CallableStatement cst=con.prepareCall("{call disp_emp(?,?)}");
			cst.setInt(1, eid);
			cst.registerOutParameter(2, Types.VARCHAR);
			cst.execute();
			System.out.println("Emp name : "+cst.getString(2));
			con.close();
			
		}
		catch(Exception ex) {
			System.out.println(ex);
		}

	}

}

