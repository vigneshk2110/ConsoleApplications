package view;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import controller.AdminOperations;
import controller.DBConnection;
import controller.Validation;

public class LoginUserAndAdmin {
	AdminOperations adminOperation = new AdminOperations();
	Scanner scanner = new Scanner(System.in);
	public boolean loginOperation() {
		boolean result = false;
		Connection connection;
		System.out.println("Enter your UserName");
		String userName = scanner.next();
		System.out.println("Enter your password");
		String password = scanner.next();
		while(Validation.adminLogin(userName, password)) {
			if(Validation.adminLogin(userName, password)) {
				System.out.println("  WELCOME   ADMIN  " + userName);
				adminOperation.displayAdminOperation();
				break;
			}
		}
		try {
			connection = DBConnection.getConnection();
			String LOGINQUERY = "SELECT * FROM `employee` WHERE emp_name ='"+userName+"' AND emp_password = '"+password+"'";
			Statement psmt = connection.createStatement();
			ResultSet rs = psmt.executeQuery(LOGINQUERY);
			while(rs.next()) {
				int id1 = rs.getInt(1);
				String name = rs.getString(2);
				String address = rs.getString(3);
				String phone = rs.getString(4);
				String gender = rs.getString(5);
				String designation = rs.getString(7);
				float salary = rs.getFloat(8);
				if((userName.equals(name))) {
					System.out.println("Employee Id  : " +id1+"\nEmployee Name :"+name+"\nEmployee Phone :"+phone+"\nEmployee Address :"+address+"\nEmployee Gender :"+gender+"\nEmployee Designation :"+designation+"\nEmployee salary :"+salary);
				System.out.println("--------------------------------");
				result = true;
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	public boolean listEmployee() {
		boolean result = false;
		Connection connection;
		try {
			String DISPLAYQUERY="SELECT * FROM `employee`";
			connection = DBConnection.getConnection();
			Statement psmt = connection.createStatement();
			ResultSet rs = psmt.executeQuery(DISPLAYQUERY);
			while(rs.next()) {
				int id1 = rs.getInt(1);
				String name = rs.getString(2);
				String address = rs.getString(3);
				String phone = rs.getString(4);
				String gender = rs.getString(5);
				String designation = rs.getString(7);
				float salary = rs.getFloat(8);
				System.out.println("Employee Id  : " +id1+"\nEmployee Name :"+name+"\nEmployee Phone :"+phone+"\nEmployee Address :"+address+"\nEmployee Gender :"+gender+"\nEmployee Designation :"+designation+"\nEmployee salary :"+salary);
				System.out.println("--------------------------------");
				result = true;
				}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}