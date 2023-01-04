package model;

public class EmployeePojo {
	private String name;
	private String address;
	private String phone;
	private String gender;
	private String password;
	private String designation;
	private float salary;
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	private int absent;
	private int present;
	public int getAbsent() {
		return absent;
	}
	public void setAbsent(int absent) {
		this.absent = absent;
	}
	public int getPresent() {
		return present;
	}
	public void setPresent(int present) {
		this.present = present;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public EmployeePojo(String name, String address, String phone, String gender,String password,String designation,float salary) {
		super();
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.gender = gender;   
		this.password = password;
		this.designation=designation;
		this.salary=salary;
	}
	
	public EmployeePojo(String name, String address, String phone, String gender, String password) {
		super();
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.gender = gender;
		this.password = password;
	}
	public EmployeePojo(int absent, int present) {
		super();
		this.absent = absent;
		this.present = present;
	}
	public EmployeePojo() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "EmployeePojo [name=" + name + ", address=" + address + ", phone="
				+ phone + ", gender=" + gender + "]";
	}
	

}
