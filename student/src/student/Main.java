package student;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class Main {
	Main(){
		hardcode();
	}
	static  Map<String,Teacher> teacherDetail = new TreeMap<String,Teacher>();
	 static TreeMap<Integer,StudentDetails> studentDetail = new TreeMap<Integer,StudentDetails>();
	
	public static void main(String[] args) throws Exception{
		Validation validationObject = new Validation();
		Main mainObject = new Main();
		TeacherFunctions teacherObject = new TeacherFunctions();
		StudentFunction studentFunctionObject = new StudentFunction();
		boolean loop = true;
		while(loop) {
			try {
		System.out.println("-------------------");
		System.out.println("1.Teacher Login");
		System.out.println("2.Teacher Registration");
		System.out.println("3.View Student");
		System.out.println("4.Student Login");
		System.out.println("5.Exit");
		System.out.println("--------------------");
		Scanner scanner = new Scanner(System.in);
		int choice = scanner.nextInt();
		if(choice<1||choice>6) throw new Exception();
		switch(choice) {
		case 1:
			System.out.println("Enter your UserName");
			String userNameforLogin = scanner.next();
			System.out.println("Enter yout Password");
			String password = scanner.next();
		   if( validationObject.passwordValidationForTeacher(password, userNameforLogin)) {
			   teacherObject.teacherFunction();
		   }
		   else {
			   System.out.println("Deatails not Found");
		   }
		   break;
		case 2:
			System.out.println("Enter your Username");
			String userName = scanner.next();
			
			System.out.println("Enter your Password");
			String RegPassword = scanner.next();
			System.out.println("Enter your name");
			String name = scanner.next();
			System.out.println("Enter your age");
			short age = scanner.nextShort();
		    System.out.println("Enter your address");
		    String address = scanner.next();
		    System.out.println("Enter your phone Number");
		    String phoneNum = scanner.next();
		    Teacher teacherValue = new Teacher(name,age,address,phoneNum,RegPassword);
		    	Main.teacherDetail.put(userName,teacherValue);
		    	System.out.println(Arrays.asList(teacherDetail));
		    teacherObject.teacherAfterLogin(teacherValue);
		    break;
		case 3:
			for (Entry entry : studentDetail.entrySet()) {
			    Integer key = (Integer) entry.getKey();
			    Object values = (Object) entry.getValue();
			    System.out.println("StudentId = " + key);
			    System.out.println("StudentValues = " + values.toString());
			}
             break;
		case 4:
			System.out.println("Enter your Student Id");
			int studId = scanner.nextInt();
			while(!studentDetail.containsKey(studId)) {
				System.out.println("Enter the correct student Id");
				studId = scanner.nextInt();
			}
			if(studentDetail.containsKey(studId)) {
				System.out.println("Welcome Student " + "\n" + studentDetail.get(studId));
					 boolean loopForStudent = true;
					while(loopForStudent) {
					System.out.println("1.To View Your Attendance");
					System.out.println("2.View Eligibility");
					System.out.println("3.Apply Leave");
					System.out.println("4.Exit");
					int studentChoice = scanner.nextInt();
					switch(studentChoice) {
					case 1:
						studentFunctionObject.viewAttendance(studId);
						break;
					case 2:
						studentFunctionObject.viewEligibility(studId);
						break;
					case 3:
						studentFunctionObject.applyLeave(studId);
						break;
					case 4:
						loopForStudent = false;
						break;
						
					}
					}
				}
			
			break;
		case 5:
			loop = false;
			return;
	      }
	
		}catch(Exception e) {
			System.out.println("you have entered the wrong option");
		}
		}
		
		
	}
	
	public final  String[][] studentdetailsArray = {
				{"giri","23","9876543210"},
				{"bala","23","9876543210"},
				{"sabari","23","9876543210"},
				{"giri","23","9876543210"},
				{"giri","23","9876543210"},
				{"giri","23","9876543210"},
				{"giri","23","9876543210"},
		};
	
	
public void hardcode() {
		for(String[] details : studentdetailsArray) {
				studentDetail.put(StudentDetails.getStudentId(), 
						new StudentDetails(details[0],Integer.parseInt(details[1]),details[2]));
		
	}
	  
	
	}

}
