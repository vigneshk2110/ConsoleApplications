package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	static Connection connect = null;
  private DBConnection() {
	  
  }
  public static Connection getConnection() throws ClassNotFoundException, SQLException {
	  try {
		  if(connect==null) {
			  //Class.forName("com.mysql.cj.jdbc.Driver");
			  String user = "root";
			  String password = "root";
			  String url = "jdbc:mysql://localhost:3306/employee_payroll";
			  connect = DriverManager.getConnection(url,user,password);
		  }
	  }catch(Exception ex) {
		  ex.printStackTrace();
	  }
	return connect;
  }
}
