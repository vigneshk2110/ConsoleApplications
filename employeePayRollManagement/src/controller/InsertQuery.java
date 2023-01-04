package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import model.EmployeePojo;

public class InsertQuery {
	public boolean insertEmployee(EmployeePojo employee) {
	boolean result = false;
	try {
		Connection connection;
		String name = employee.getName();
		String address = employee.getAddress();
		String phone = employee.getPhone();
		String gender = employee.getGender();
		String password = employee.getPassword();
		String designation = employee.getDesignation();
		float salary = employee.getSalary();
		String INSERTQUERY = "INSERT INTO `employee` VALUES(null,'"+name+"','"+address+"','"+phone+"','"+gender+"','"+password+"','"+designation+"','"+salary+"')";
		String INSERSALARY = "SELECT * FROM `employee`";
		connection = DBConnection.getConnection();
		Statement psmt = connection.createStatement();
		psmt.execute(INSERTQUERY);
		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery(INSERSALARY);
		while(rs.next()) {
			try {
				int id = rs.getInt(1);
				String query = "UPDATE salary set basic_salary = ? where salary_id = ?";
			      PreparedStatement preparedStmt = connection.prepareStatement(query);
			      preparedStmt.setFloat(1, salary);
			      preparedStmt.setInt(2, id);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("DATA ADDED SUCCESSFULLY");
		result = true;
	}catch(Exception e) {
		e.printStackTrace();
		System.out.println("Errors at Inserting UserDetails!!!");
	}
	return result;

}
	public float emp_pfMethod(float salary) {
		float emp_pf = salary/12;
		return emp_pf;
	}
}
