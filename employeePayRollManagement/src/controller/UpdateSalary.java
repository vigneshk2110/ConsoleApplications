package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateSalary {
	Scanner scanner = new Scanner(System.in);
	public boolean updateSalary() throws ClassNotFoundException, SQLException {
		boolean result = false;
		Connection connection;
		System.out.println("ENTER THE ID");
		int emp_id = scanner.nextInt();
		try {
			connection = DBConnection.getConnection();
			String LOGINQUERY = "SELECT * FROM `salary` WHERE emp_id_salary ='"+emp_id+"'";
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(LOGINQUERY);
			while(rs.next()) {
				int id1 = rs.getInt(1);
				int  id2 = rs.getInt(2);
				String role = rs.getString(3);
				double pf = rs.getInt(4);
				double salary1 = rs.getInt(5);
				System.out.println("Employee Id  : " +id1+"\nSalary Id :"+id2+"\nEmployee role :"+role+"\nEmployee pf :"+pf+"\nEmployee Salary :"+salary1);
				System.out.println("--------------------------------");
				Statement stmt1 = connection.createStatement();
				try {
					System.out.println("Enter Salary To Update");
					double salary2 = scanner.nextDouble();
					 String query = "UPDATE salary set basic_salary = ? where salary_id = ?";
				      PreparedStatement preparedStmt = connection.prepareStatement(query);
				      preparedStmt.setDouble(1, salary2);
				      preparedStmt.setInt(2, id2);
				      String query1 = "UPDATE employee set emp_salary = ? where emp_id = ?";
				      PreparedStatement preparedStmt1 = connection.prepareStatement(query1);
				      preparedStmt1.setDouble(1, salary2);
				      preparedStmt1.setInt(2, id2);
				      System.out.println("Updated Successfully");
				}finally {
					stmt1.close();
				}
				result = true;
				}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	public double pf_calculation(double salary) {
		double emp_pf = salary / 12;
		return emp_pf;
	}

}
