//create a function which accept city as input parameter and return sum of marks 
// write a java program to execute that function 
package JDBC;

import java.sql.*;
import java.util.*;



public class Demo9 {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/salesstore?useSSL=false","root","Ganesh@1351");

			

			Scanner sc = new Scanner(System.in);
			System.out.println("Enter City ");
			 String city11 = sc.next();
			 
//			 CallableStatement cst = con.prepareCall("{? = call stud_sum(?)}");
			
			 CallableStatement cst = con.prepareCall("{ ? = call stud_sum(?) }");

			 cst.registerOutParameter(1,Types.INTEGER);
			 cst.setString(2, city11);
			 cst.execute();
			 System.out.println("Sum:"+cst.getInt(1));
			 con.close();
		}
		catch(Exception ex){
			System.out.println(ex);
			
		}
	}

}
