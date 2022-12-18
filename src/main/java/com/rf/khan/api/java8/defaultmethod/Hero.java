package com.rf.khan.api.java8.defaultmethod;

public class Hero implements Engine, Model {

	@Override
	public void model() {
		System.out.println("Hero model");
	}

	@Override
	public void start() {
		System.out.println("Hero Engine started");
	}

	public void pinkColor() {
		System.out.println("Hero class, pink color changes to blue..");
	}
}
