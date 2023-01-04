package controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import model.EmployeePojo;
import view.ListAttendanceAdmin;

public class AdminOperations {
	Scanner scanner = new Scanner(System.in);
	Connection connection;
	AttendaceList attendance = new AttendaceList();
	ListAttendanceAdmin listAttendance = new ListAttendanceAdmin();
	UpdateSalary update = new UpdateSalary();
	public void displayAdminOperation() {
		boolean loop = true;
		try {
			while(loop) {
		System.out.println("1.Add Employee");
		System.out.println("2.view Employee");
		System.out.println("3.Take Attendance");
		System.out.println("4.View Attendance");
		System.out.println("5.Update Employee");
		System.out.println("6.Update Salary");
		System.out.println("7.Exit");
		int userChoice = scanner.nextInt();
			switch(userChoice) {
			case 1:
				addEmployee();
				break;
			case 2:
				displayEmployee();
				break;
			case 3:
				attendance.takeAttendance();
				break;
			case 4:
				listAttendance.showAttendance();
				break;
			case 5:
				updateEmployee();
				break;
			case 6:
				update.updateSalary();
				break;
			case 7:
				loop = false;
				break;
			}
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public boolean displayEmployee() {
		boolean result = false;
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
				System.out.println("Employee Id  : " +id1+"\nEmployee Name :"+name+"\nEmployee Phone :"+phone+"\nEmployee Address :"+address+"\nEmployee Gender :"+gender+"\nEmployee Designation :"+designation);
				System.out.println("--------------------------------");
				result = true;
				}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	public boolean addEmployee() {
		boolean result = false;
		InsertQuery insert = new InsertQuery();
		System.out.println("Enter Employee Name");
		String name = scanner.next();
		while (!name.matches(("^[aA-zZ][aA-zZ\\s.]{2,29}$"))) {
			System.out.println("Enter a Valid UserName");
            name = scanner.next();
	    }
		System.out.println("Enter Employee address");
		String address = scanner.next();
		System.out.println("Enter Employee phone");
		String phone = scanner.next();
		while (!phone.matches(("^[6789][0-9]{9}$"))) {
	         System.out.println("Enter a valid mobile Phone Number");
	         phone = scanner.next();
	     }
		System.out.println("Enter Employee Gender");
		String gender = scanner.next();
		System.out.println("Enter Employee password");
		String password = scanner.next();
		while (!password.matches("(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*_]).{8,}"))//catching exception
	    {
	        System.out.println("Enter The Valid Password");
	        password = scanner.next();
	    }
		System.out.println("Enter Designation");
		setDesignation();
		String designation = scanner.next();
		System.out.println("Enter the salary");
		float salary = scanner.nextFloat();
		EmployeePojo employee = new EmployeePojo(name,address,phone,gender,password,designation,salary);
		insert.insertEmployee(employee);
		result = true;
		return result;
	}
	public boolean updateEmployee() {
		boolean result = false;
		System.out.println("PRESS 1 to UPDATE name");
		System.out.println("PRESS 2 to UPDATE phone");
		System.out.println("PRESS 3 to UPDATE address");
		int value = scanner.nextInt();
		if(value==1) {
			System.out.println("Enter name to UPDATE...");
			String name1 = scanner.next();
			System.out.println("Enter ID to identify Employee!");
			int id = scanner.nextInt();
			EmployeePojo empPojo = new EmployeePojo();
			empPojo.setName(name1);
			boolean res = UpdateEmployee.updateInfo(value, name1, id, empPojo);
			if(res) {
				System.out.println("Employee Name Updated Successfully...");
			}else {
				System.out.println("Something Went Wrong Please try Again!");
			}
		}
		else if(value == 2) {
			System.out.println("Enter phone to UPDATE...");
			String phone1 = scanner.next();
			System.out.println("Enter ID to identify Employee!");
			int id = scanner.nextInt();
			EmployeePojo empPojo = new EmployeePojo();
			empPojo.setPhone(phone1);
			boolean res = UpdateEmployee.updateInfo(value, phone1, id, empPojo);
			if(res) {
				System.out.println("Employee Name Updated Successfully...");
			}else {
				System.out.println("Something Went Wrong Please try Again!");
			}
		}
		else if(value == 3) {
			System.out.println("Enter address to UPDATE...");
			String address1 = scanner.next();
			System.out.println("Enter ID to identify Employee!");
			int id = scanner.nextInt();
			EmployeePojo empPojo = new EmployeePojo();
			empPojo.setAddress(address1);
			boolean res = UpdateEmployee.updateInfo(value, address1, id, empPojo);
			if(res) {
				System.out.println("Employee Address Updated Successfully...");
			}else {
				System.out.println("Something Went Wrong Please try Again!");
			}
		}
		else {
			System.out.println("You have entered wrong option!!");
		}
		return result;
	}
	public void setDesignation() {
		System.out.println("1.Manager");
		System.out.println("2.Developer");
		System.out.println("3.Tester");
		System.out.println("4.Technical Support");
	}
}
