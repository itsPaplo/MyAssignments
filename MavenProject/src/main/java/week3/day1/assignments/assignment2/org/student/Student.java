package week3.day1.assignments.assignment2.org.student;

import week3.day1.assignments.assignment2.org.department.Department;

public class Student extends Department {

	public void studentName() {
		System.out.println("Method 05: Student name called from Student class");
	}
	
	public void studentDept() {
		System.out.println("Method 06: Student Department called from Student class");
	}
	
	public void studentId() {
		System.out.println("Method 07: Student ID called from Student class");
	}
	
	public static void main(String[] args) {
		Student stdnt1 = new Student();
		stdnt1.collegeName();
		stdnt1.collegeCode();
		stdnt1.collegeRank();
		stdnt1.deptName();
		stdnt1.studentName();
		stdnt1.studentDept();
		stdnt1.studentId();
	}
}
