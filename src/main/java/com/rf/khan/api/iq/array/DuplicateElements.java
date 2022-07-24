package com.rf.khan.api.iq.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class DuplicateElements {

	public static void main(String[] args) {
		int[] input = { 1, 2, 3, 4, 5, 6, 2, 3, 4 };

		System.out.println(findDuplicates(input, input.length));
	}

	public static ArrayList<Integer> findDuplicates(int[] arr, int n) {

		ArrayList<Integer> duplicates = new ArrayList<>();
		Set<Integer> set = new HashSet<>();

		for (int i = 0; i < n; i++) {

			if (!set.add(arr[i])) {
				duplicates.add(arr[i]);

			} else {
				set.add(arr[i]);
			}
		}
		return duplicates;
	}

}
