package student;

public class StudentDetails {
	private String name;
	private int age;
	private String phoneNumber;
    static int studentId = 2022001;
    public int sId;
	public int isPresent;
	public int count;
	public int isAbsent;

	public int getIsPresent() {
		return ++count;
	}



	public void setIsPresent(int count) {
		 this.count = count;
	}



	public int getIsAbsent() {
		return --count;
	}



	public void count(int count) {
		this.isAbsent = count;
	}



	@Override
	public String toString() {
		return "StudentDetails [name=" + name + ", age=" + age + ", phoneNumber=" + phoneNumber + ", total Present =" + isPresent + ", total Absent =" + isAbsent + "]";
	}



	public StudentDetails( String name, int age, String phoneNumber) {
		super();
		this.name = name;
		this.age = age;
		this.phoneNumber = phoneNumber;
		
	}







	public static int getStudentId() {
		return studentId++;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public int getAge() {
		return age;
	}



	public void setAge(int age) {
		this.age = age;
	}



	public String getPhoneNumber() {
		return phoneNumber;
	}



	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	
	

}
