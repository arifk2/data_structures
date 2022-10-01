package com.rf.khan.api.java8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

/**
 * This class is created to demonstrate the skip and limit method of the java 8
 * 
 * @author mkhan339
 *
 */
public class SplitLimit {

	public static void main(String[] args) throws IOException {

		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
		list.stream().skip(1).limit(5).forEach(System.out::print);

		System.out.println("\n========================================");

		/************************/
		Path path = Paths.get("table.txt");

		Files.lines(path).skip(1).limit(Files.lines(path).count() - 2).forEach(System.out::println);
	}
}
