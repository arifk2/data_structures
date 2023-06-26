package com.rf.khan.api.java8;

import java.util.ArrayList;
import java.util.List;

public class ConvertArrayListInStreams {
	public static void main(String[] args) {
		List<String> stringList = new ArrayList<>();
		stringList.add("ank");
		stringList.add("sam");
		stringList.add("az");
		stringList.add("neh");
		stringList.add("ad");

		// display all the record starting with a
		System.out.println("\n1. Use stream and filtering and display");
		stringList.stream().filter(i -> i.startsWith("a")).forEach(System.out::println);

		// In one line display all records (in sorted manner - ASCENDING) that start
		// with 'a' in stringList
		System.out.println("\n2. Use stream for filtering, sorting and display (in sorted manner - ASCENDING order )");
		stringList.stream().filter(s -> s.startsWith("a")).sorted().forEach(System.out::println);

		// In one line display all records (in sorted manner - DESCENDING) that start
		// with 'a' in stringList
		System.out.println("\n3. Use stream for filtering, sorting and display(in sorted manner - DESCENDING order)");
		stringList.stream().filter(s -> s.startsWith("a")).sorted((a, b) -> b.compareTo(a))
				.forEach(System.out::println);

		// In one line display all records (in sorted manner) in UPPERCASE that start
		// with 'a' in stringList
		System.out.println("\n4. Use stream for filtering, UPPERCASE conevrsion, sorting and display");
		stringList.stream().filter(s -> s.startsWith("a")).map(String::toUpperCase).forEach(System.out::println);

	}
}