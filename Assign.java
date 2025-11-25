//a java code which accept emp_detail from user and inser into table
package JDBC;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Assign {

	
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/company?useSSL=false","root","YOUR_PASSWORD");
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter id , First_Name , Last_Name , salary and joinin_Date(yyyy-mm-dd) ");
			int id = sc.nextInt();
			String fnm=sc.next();
			String lnm = sc.next();
			Float sal = sc.nextFloat();
			String date = sc.next();
			
			
			PreparedStatement pst = con.prepareStatement("insert into employees values (?,?,?,?,?)");
			pst.setInt(1, id);
			pst.setString(2, fnm);
			pst.setString(3, lnm);
			pst.setFloat(4, sal);
			pst.setString(5, date);
			pst.execute();
			System.out.println("Record Inserted...");
			con.close();
			
		
		
		
		
		
		}
		
		catch(Exception Ex) {
			System.out.println(Ex);
		}
	}

}


