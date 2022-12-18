package com.rf.khan.api.java8.defaultmethod;

public class Test {
	public static void main(String[] args) {
		Engine hero = new Hero();
		Engine honda = new Honda();

		hero.start();
		hero.pinkColor();

		honda.start();
		honda.pinkColor();

	}
}
