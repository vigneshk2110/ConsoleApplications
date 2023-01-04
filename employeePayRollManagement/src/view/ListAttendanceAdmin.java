package view;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import controller.DBConnection;

public class ListAttendanceAdmin {
	public boolean showAttendance() {
		boolean result = false;
		System.out.println("EMPLOYEE ATTENDANCE");
		Connection connection;
		try {
			String DISPLAYQUERY="SELECT * FROM `attendance`";
			connection = DBConnection.getConnection();
			Statement psmt = connection.createStatement();
			ResultSet rs = psmt.executeQuery(DISPLAYQUERY);
			while(rs.next()) {
				int id1 = rs.getInt(1);
				int attendanceId = rs.getInt(2);
				String attendance = rs.getString(3);
				String date = rs.getString(4);
				System.out.println("Employee Id  : " +id1+"\nAttendance Id :"+attendanceId+"\nEmployee attendance Status :"+attendance+"\nDate  :"+date);
				System.out.println("--------------------------------");
				result = true;
				}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
