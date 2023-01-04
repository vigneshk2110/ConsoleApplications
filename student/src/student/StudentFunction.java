package student;

import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;

public class StudentFunction extends TeacherFunctions {
	TeacherFunctions teacherFunctionObject = new TeacherFunctions();
	Scanner scanner = new Scanner(System.in);
	 void viewAttendance(int studId) {
			if(Main.studentDetail.containsKey(studId)) {
				System.out.println("Your Attendance Detail");
				var currentStudent = TeacherFunctions.attendanceMap.get(studId);
				System.out.println("total Attendance Count " + currentStudent);
		 }
	}
	 void applyLeave(int studId) {
		StudentDetails studentDetailsObject = new StudentDetails();
		System.out.println("Enter number of days you want to apply leave");
		int noOfDays = scanner.nextInt();
		TeacherFunctions.attendanceMap.put(studId, studentDetailsObject.getIsPresent()-noOfDays);
	}
		
	 void viewEligibility(int studId) {
		int noOfDays = 10;
		for(Map.Entry<Integer, Integer> entry : TeacherFunctions.attendanceMap.entrySet() ) {
			Integer key = entry.getKey();
			Integer value = entry.getValue();
			double percentage = (entry.getValue()/noOfDays)*100;
			
			
			if(value>noOfDays) {
				System.out.println(key  + " You are Eligible for Exam");
				System.out.println(percentage);
				
			}
			else {
				System.out.println(key + " You are not Eligible for Exam");
				System.out.println(percentage);
			}	
		}
	}
}


