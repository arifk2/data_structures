package com.rf.khan.api.java8.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamJava8 {

	public static void main(String[] args) {

		List<String> departmentList = new ArrayList<>();
		departmentList.add("HR");
		departmentList.add("IT");
		departmentList.add("Sales");
		departmentList.add("Marketing");
		departmentList.add("Supply");

		departmentList.stream().forEach(System.out::println);
		System.out.println("---------------------------------");
		departmentList.parallelStream().forEach(System.out::println);

		Stream<Integer> randomStrem = Stream.generate(new Random()::nextInt).limit(10);

		randomStrem.forEach(System.out::println);

		departmentList.stream().map(word -> word.toUpperCase()).collect(Collectors.toList())
				.forEach(System.out::println);

		Stream<String> streamOfWords = Arrays.stream(new String[] { "Easy", "bytes" });

		streamOfWords.map(word -> word.split("")).flatMap(Arrays::stream).forEach(System.out::println);

		departmentList.stream().filter(word -> word.startsWith("S")).forEach(System.out::println);

		Stream.iterate(1, n -> n + 1).skip(10).limit(20).forEach(System.out::println);

		List<Product> productList = Arrays.asList(new Product("Iphone 14", 1200.00), new Product("Samsung", 1300),
				new Product("Washing Machine", 3800.00), new Product("Oven", 3800.00),
				new Product("Macbook Pro", 1000000), new Product("Ipad", 4500));

		String maxProductName = productList.stream()
				.collect(Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(Product::getPrice)),
						(Optional<Product> product) -> product.isPresent() ? product.get().getName() : "None"));
		System.out.println("Product With max Price tag is : " + maxProductName);

		Map<Double, List<Product>> groupByPrice = productList.stream()
				.collect(Collectors.groupingBy(Product::getPrice));
		System.out.println(groupByPrice);

		Map<Boolean, List<Product>> paritionByPrice = productList.stream()
				.collect(Collectors.partitioningBy(product -> product.getPrice() > 1300));
		System.out.println(paritionByPrice);

		List<Integer> streamInteger = Arrays.asList(new Integer[] { 5, 2, 11, 7, 4, 13, 9 });
		streamInteger.stream().filter(num -> num % 2 != 0).map(num -> num * num).sorted().forEach(System.out::println);

	}
}
