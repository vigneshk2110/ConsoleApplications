package controller;

public class Validation {
	public static boolean adminLogin(String name,String password) {
		return name.equals("vipin")&&password.equals("admin");
	}
}
