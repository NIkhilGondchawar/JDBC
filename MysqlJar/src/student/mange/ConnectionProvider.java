package student.mange;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider {
	
	static Connection con =null;
	
	public static Connection createc() {
	
	
	try {
		//load the driver....
		Class.forName("com.mysql.jdbc.Driver");
		
		//create the connection....
		String user="root";
		String password="system";
		String url="jdbc:mysql://localhost:3306/student_management";
		con=DriverManager.getConnection(url, user, password);
			
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return con;
	
}
}
