package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import controller.DBConnection;

public class AttendaceList {
	Scanner scanner = new Scanner(System.in);
	public boolean takeAttendance() {
		boolean result = false;
		Connection connection;
		try {
			System.out.println("Enter the EMPLOYEE_ID");
			int emp_id = scanner.nextInt();
			String ATTENDANCEQUERY="SELECT * FROM `employee`";
			connection = DBConnection.getConnection();
			Statement psmt = connection.createStatement();
			ResultSet rs = psmt.executeQuery(ATTENDANCEQUERY);
			while(rs.next()) {
				int id = rs.getInt(1);
				if(emp_id==id) {
					System.out.println("Enter the Attendance of " + emp_id);
					String attendance = scanner.next();
					if(attendance.equals("p")||attendance.equals("P")) {
						attendance = "PRSENT";
					}
					else if(attendance.equals("a")||attendance.equals("A")) {
						attendance = "ABSENT";
					}
					Date date = Calendar.getInstance().getTime();  
					DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");  
					String strDate = dateFormat.format(date);  
					Statement stmt1 = connection.createStatement();
					try {
						stmt1.executeUpdate("INSERT INTO `attendance` VALUES('"+id+"','"+id+"','"+attendance+"','"+date+"')");
					}
					finally {
						stmt1.close();
					}
					System.out.println("ATTENDANCE MARKED SUCCESSFULLY");
					result = true;
					
				}
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
