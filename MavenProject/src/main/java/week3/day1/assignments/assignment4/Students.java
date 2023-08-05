package week3.day1.assignments.assignment4;

public class Students {
	
	public void getStudentInfo() {
		System.out.println("Base method: getstudentinfo - base method");	
	}
	
	public void getStudentInfo(int id) {
		System.out.println("Overload 01: ID: " + id);
	}
	
	public void getStudentInfo(int id, String name) {
		System.out.println("Overload 02: ID: " + id + " " + " Name: " + name);
	}
	
	public void getStudentInfo(String email, long phoneNumber) {
		System.out.println("Overload 03: Email: " + email + " " + " Phonenumber: " + phoneNumber);
	}
	
	public static void main(String[] args) {
		Students stdnt = new Students();
		stdnt.getStudentInfo();
		stdnt.getStudentInfo(112);
		stdnt.getStudentInfo(125, "Philips");
		stdnt.getStudentInfo("test@gmail.com", 8989898989l);
	}

}
