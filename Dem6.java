//write a procedure which accept emp_id,name and salary as input in , wrte a java program to execute procedure
package JDBC;
import java.sql.*;
import java.util.Scanner;
public class Dem6 {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/company?useSSL=False","root","Ganesh@1351");
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter emp_id , name , salary");
			int eid = sc.nextInt();
			String nm = sc.next();
			float sal = sc.nextFloat();
			
			
			CallableStatement cst = con.prepareCall("{call add_emp(?,?,?)}");
			cst.setInt(1,eid);
			cst.setString(2, nm);
			cst.setFloat(3, sal);
			
			cst.execute();
			System.out.println("Done...");
			con.close();
			
			
		}
		
catch(Exception ex){
	System.out.println(ex);
	
}
	}

}
