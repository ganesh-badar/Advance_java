//java program to accept the emp_id and delet that employee
package JDBC;
import java.sql.*;
import java.util.*;
public class Demo5 {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/company?useSSL=false","root","Ganesh@1351");
			System.out.println("Enter emp_id");
			Scanner sc = new Scanner(System.in);
			int emid = sc.nextInt();
			PreparedStatement pst = con.prepareStatement("DELETE from employees where id=?");
			pst.setInt(1, emid);
			int rows =pst.executeUpdate();
			if(rows > 0) {
			System.out.println("record deleted");
			}
			
			else {
			System.out.println("Record not present to delete");
			}
			con.close();
			}
			catch(Exception ex){
			System.out.println(ex);
		} 		}

	}
