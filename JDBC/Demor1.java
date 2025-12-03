/*Resultset MetaData Interface
1)getcolumnCount(); --> return the number of column in table
2)getcolumnName(); --> return the name of column
3)getcolumnTypeName(); --> return the datatype of the column
*/
package JDBC;
import java.sql.*;
import java.util.*;

public class Demor1 {

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection com = DriverManager.getConnection("jdbc:mysql://localhost:3306/voter?useSSL=false","root","Ganesh@1351");

            Statement st = com.createStatement();
            ResultSet rs = st.executeQuery("select * from voters");
            ResultSetMetaData remd = rs.getMetaData();   // Now matches java.sql.ResultSetMetaData

            int cnt = remd.getColumnCount();
            System.out.println("Total NO Of Column = " + cnt);

            for(int i = 1; i <= cnt; i++) {
                System.out.println(remd.getColumnName(i) + "  " + remd.getColumnTypeName(i));
            }

            rs.close();
            com.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
