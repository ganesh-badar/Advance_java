package JDBC;

import java.sql.*;


public class Demo1 {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/voter?useSSL=false","root","YOUR_PASSWORD");
			System.out.println("Connection Established...");
			Statement st = con.createStatement();
			ResultSet rs =st.executeQuery("select * from voters");
			
			
			while(rs.next()) {
				
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3));
				
			}
			rs.close();
			con.close();
		}
		
		catch(Exception ex){
			System.out.println(ex);
			
			
		}
	}

}

