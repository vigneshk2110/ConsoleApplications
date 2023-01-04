package controller;

import java.util.Scanner;


import view.LoginUserAndAdmin;


public class Main {
	public static void main(String[] args) {
        
		LoginUserAndAdmin loginUser = new LoginUserAndAdmin();
		try (Scanner scanner = new Scanner(System.in)) {
			boolean outerLoop = true;
			try {
				while(outerLoop) {
					System.out.println("1.List Employee");
					System.out.println("2.User Login And Admin Login");
					int input = scanner.nextInt();
					switch(input) {
					case 1:
						loginUser.listEmployee();
						break;
					case 2:
						loginUser.loginOperation();
						break;
					}
				}
			}catch(Exception e) {
				
			}
		}
	}

}
