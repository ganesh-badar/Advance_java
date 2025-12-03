package JDBC;

import java.sql.*;
import java.util.Scanner;

import com.mysql.*;

public class Demo2 {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			
			Connection  con = DriverManager.getConnection("jdbc:mysql://localhost:3306/voter?useSSL=false","root","Ganesh@1351");
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter Employee Id :- ");
			int id = sc.nextInt();
			
			
			PreparedStatement pst = con.prepareStatement("select *from voters where voter_id =?");
			pst.setInt(1,id);
			
			ResultSet rs = pst.executeQuery();
			
			
			if(rs.next()) {
				System.out.println(rs.getInt(1)+" "+ rs.getString(2)+ " "+rs.getInt(3) );
			}
			else {
				System.out.println("Voter Is Not Exist...");
			}
			rs.close();
			con.close();
		}
		catch(Exception ex) {
			System.out.println(ex);
		}

	}

}
