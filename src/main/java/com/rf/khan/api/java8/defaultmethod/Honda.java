package com.rf.khan.api.java8.defaultmethod;

public class Honda implements Engine, Model {

	@Override
	public void start() {
		System.out.println("Honda Engine started");
	}

	@Override
	public void model() {
		System.out.println("Honda Model..");
	}

	@Override
	public void pinkColor() {
		Engine.super.pinkColor();
	}

}
