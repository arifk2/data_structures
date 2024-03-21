package com.rf.khan.api.java8;

import java.util.ArrayList;
import java.util.List;

class Student {
	private int id;
	private String firstName;
	private String lastName;
	private String gender;

	public Student(int id, String firstName, String lastName, String gender) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender + "]";
	}
}

public class Test {
	public static void main(String[] args) {
		List<Student> list = new ArrayList<Student>();
		list.add(new Student(1, "Arif", "Khan", "M"));
		list.add(new Student(2, "Rrif", "Phan", "M"));
		list.add(new Student(3, "Frif", "Shan", "F"));
		list.add(new Student(4, "Krif", "Nhan", "F"));

		System.out.println("Before Sorting \n" + list);
		list.sort((Student s1, Student s2) -> s1.getFirstName().compareTo(s2.getFirstName()));
		System.out.println("After Sorting \n" + list);

	}
}
