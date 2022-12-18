package com.rf.khan.api.java8.funtionalinterface;

import java.util.function.BiFunction;
import java.util.function.Function;

public class BookImpl {

	public static void main(String[] args) {
		// Predicate
		Book book = (a, b) -> {
			System.out.println(a + b);
		};
		book.getsum(10, 20);

		// Function
		Function<String, Integer> function = (a) -> {
			System.out.println("Hello " + a);
			return 100;
		};

		int ans = function.apply("Arif");
		System.out.println(ans);

		BiFunction<String, String, String> str = (a, b) -> a + " ji " + b;

		System.out.println(str.apply("Arif", "khan"));
	}
}
