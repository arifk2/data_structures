package com.rf.khan.api.java8.defaultmethod;

public interface Model {

	public abstract void model();

	public default void pinkColor() {
		System.out.println("Model class, pink color method..");
	}
}
