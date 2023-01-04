package student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;

public class TeacherFunctions {
	Teacher teacher;
	Scanner scannerObject = new Scanner(System.in);
	static Map<Integer,Integer> attendanceMap = new HashMap<>();
	int count = 0;
	
	@SuppressWarnings("unused")
	public void teacherAfterLogin(Teacher teacher) {
		Main mainObject = new Main();
		
		
		System.out.println("------TEACHER LOGIN------");
		System.out.println("Enter Your UserName");
		String teacherUserName = scannerObject.next();
		System.out.println("Enter your password");
		String teacherUserPassword = scannerObject.next();
		System.out.println(Arrays.asList(Main.teacherDetail));
		while(!Main.teacherDetail.containsKey(teacherUserName)) {
			System.out.println("Invalid UserName");
			return;
		}
		  if(Main.teacherDetail.containsKey(teacherUserName)) {
			  teacher = Main.teacherDetail.get(teacherUserName);
			  if(teacher.password.equals(teacherUserPassword)) {
				  System.out.println("Welcome Teacher " + teacherUserName);
				  teacherFunction();
		  }
			
			
		  }
		}
	void teacherFunction() {
		boolean loop = true;
		  while(loop) {
				
				System.out.println("1.Mark Attendance");
			    System.out.println("2.Add Student");
				System.out.println("3.View Attendance");
				System.out.println("4.Is Eligible");
				System.out.println("5.Exit");
				int teacherChoice = scannerObject.nextInt();
				switch(teacherChoice) {
				case 1:
					markAttendance();
					break;
				case 2:
					addStudent();
					break;
				case 3:
					viewAttendance();
					break;
				case 4:
					isEligible();
					break;
				case 5:
					loop = false;
					return;
					
				}
			}
	}
	private  void markAttendance() {
		StudentDetails studentDetailsObject = new StudentDetails();
		System.out.println("Enter the StudentId to make present or Absent");
		int studId = scannerObject.nextInt();
		while(!Main.studentDetail.containsKey(studId)) {
			System.out.println("Enter the Id Of a student Correctly");
			studId = scannerObject.nextInt();
		}
		if(Main.studentDetail.containsKey(studId)) {
			boolean loop = true;
			while(loop) {
				try {
		System.out.println("1.Present");
		System.out.println("2.Absent");
		System.out.println("3.Exit");
		int teacherChoice = scannerObject.nextInt();
		
			switch(teacherChoice) {
			case 1:
				attendanceMap.put(studId, studentDetailsObject.getIsPresent());
				System.out.println(attendanceMap);
				break;
			case 2:
				attendanceMap.put(studId, studentDetailsObject.getIsAbsent());
				System.out.println(attendanceMap);
				break;
			case 3:
				loop = false;
				return;
			}
				
		}catch(Exception e) {
			System.out.println("you have entered the wrong option");
		}
			}
		}
		else {
			System.out.println("Stduent Details not found");
		}
		
	}
	
	private void addStudent() {
		System.out.println("Enter Name");
		String stuName = scannerObject.next();
		System.out.println("Enter age");
		int age = scannerObject.nextInt();
		System.out.println("Enter mobile Number");
		String phone = scannerObject.next();
        StudentDetails studentDetails = new StudentDetails(stuName,age,phone);
        int currId = StudentDetails.getStudentId();
        Main.studentDetail.put(currId, studentDetails);
		System.out.println("Stduent Detail Added Successfully");
	}
	private void isEligible() {
		int noOfDays = 10;
		for(Map.Entry<Integer, Integer> entry : attendanceMap.entrySet() ) {
			Integer key = entry.getKey();
			Integer value = entry.getValue();
			double percentage = (entry.getValue()/noOfDays)*100;
			
			
			if(value>noOfDays) {
				System.out.println(key  + " You are Eligible for Exam");
				System.out.println("your Percentage is "+percentage);
				System.out.println(percentage);
				
			}
			else {
				System.out.println(key + " You are not Eligible for Exam");
				System.out.println("your Percentage is "+percentage);
				System.out.println(percentage);
			}	
		}
	}
private void viewAttendance() {
	for (@SuppressWarnings("rawtypes") Entry entry : attendanceMap.entrySet()) {
	    Integer key = (Integer) entry.getKey();
	    Object values = (Object) entry.getValue();
	    System.out.println("StudentId = " + key);
	    System.out.println("Total Attendance = " + values.toString());
	}
		
	}
}
	



