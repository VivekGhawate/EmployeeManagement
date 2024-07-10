package employee.management.system;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
public class conn {
	Connection c;
	Statement s;
	public conn() {
		try {
			//load the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//db info
			String url="jdbc:mysql://localhost:3306/employeemanagement";
			String username="root";
			String password="";
			c=DriverManager.getConnection(url, username, password);
			
			s= c.createStatement();
			
			
		}
		catch(Exception e) {
			System.out.println("Error in connection to db"+e);
		}
	}

}
