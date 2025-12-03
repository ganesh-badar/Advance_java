//Write a Java Code To Accept Customer_id , name,email and address at run timeand insert into department table


package JDBC;

import java.sql.*;
import java.util.Scanner;

public class Demo3 {

	public static void main(String[] args) {
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shopdb?useSSL=false","root","Ganesh@1351");
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter c_id , name ,email and addres : ");
			int c_id = sc.nextInt();
			String nm = sc.next();
			String email = sc.next();
			String add = sc.next();
			
			PreparedStatement pst = con.prepareStatement("insert into customers values (?,?,?,?)");
			pst.setInt(1, c_id);
			pst.setString(2, nm);
			pst.setString(3, email);
			pst.setString(4, add);
			pst.executeUpdate();
			System.out.println("Record Inserted....");
			con.close();
			
		}
		
		catch(Exception ex){
			System.out.println(ex);
		}
	}

}
