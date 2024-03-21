package com.rf.khan.api.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class InterviewQues {
	public static void main(String[] args) {
		List<Integer> listOfInteger = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 13, 14, 15, 16, 17);
		Map<Boolean, List<Integer>> result = listOfInteger.stream().collect(Collectors.partitioningBy(i -> i % 2 == 0));
		System.out.println(result);

		List<Integer> sortInReverseOrder = listOfInteger.stream().sorted(Comparator.reverseOrder()).toList();
		System.out.println("Sorted in Reverse Order :-> " + sortInReverseOrder);

		String inputString = "arifKhan";
		Map<Character, Long> ans = inputString.chars().mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(ans);
	}
}
