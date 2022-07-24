package com.rf.khan.api.iq.array;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ArrayExample2 {

	public static void main(String[] args) {

		Integer[] str = { 1, 2, 3, 4, 5 };

		ArrayList<Integer> list1 = Stream.of(str).collect(Collectors.toCollection(ArrayList::new));
		System.out.println(list1);

	}
}