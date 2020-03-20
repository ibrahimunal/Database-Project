import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
public class Runner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			Connection conn= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "ticketprogram", "ticketprogram");
			Statement st = conn.createStatement();
//			st.executeUpdate("INSERT INTO Get " + "VALUES ('101','123')");
			ResultSet rs = st.executeQuery("select name from Event");
			ResultSetMetaData rsmd = rs.getMetaData();

			int columnsNumber = rsmd.getColumnCount();
			while (rs.next()) {
				//Print one row          
				for(int i = 1 ; i <= columnsNumber; i++){

				      System.out.print(rs.getString(i) + " "); //Print one element of a row

				}

				  System.out.println();//Move to the next line to print the next row.           

				    }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}


}
