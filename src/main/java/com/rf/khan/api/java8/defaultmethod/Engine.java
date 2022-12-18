package com.rf.khan.api.java8.defaultmethod;

public interface Engine {

	public abstract void start();

	public default void pinkColor() {
		System.out.println("Engine class, pink color method..");
	}

	public static void main(String[] args) {
		System.out.println("Engine static main method..");
	}
}
