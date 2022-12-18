package com.rf.khan.api.java8.methodreference;

public class Book {

	private String name;
	private String Description;

	public Book(String name, String description) {
		this.name = name;
		Description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	@Override
	public String toString() {
		return "Book [name=" + name + ", Description=" + Description + "]";
	}

}
