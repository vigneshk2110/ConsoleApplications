package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;

import model.EmployeePojo;

public class UpdateEmployee {	
public static boolean updateInfo(int value, String toUpdate, int emp_id, EmployeePojo employee) {
	boolean result = false;
	Connection connection;
	try {
		connection = DBConnection.getConnection();
		if(value==1) {
			//updating name
			String query = "update employee set emp_name=? where emp_id=?";
			PreparedStatement psmt = connection.prepareStatement(query);
			psmt.setString(1, toUpdate);
			psmt.setInt(2,emp_id);
			psmt.executeUpdate();
			result = true;
		}
		else if(value==2) {
			//updatind phone
			String query = "update employee set emp_phone=? where emp_Id=?";
			PreparedStatement psmt = connection.prepareStatement(query);
			psmt.setString(1, toUpdate);
			psmt.setInt(2, emp_id);
			psmt.executeUpdate();
			result = true;
		}
		else if(value==3) {
			//update address
			String query = "update employee set emp_address=? where emp_Id=?";
			PreparedStatement psmt = connection.prepareStatement(query);
			psmt.setString(1, toUpdate);
			psmt.setInt(2, emp_id);
			psmt.executeUpdate();
			result = true;
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
	return result;
}
}
