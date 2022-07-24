package com.rf.khan.api.iq.array.ques;

import java.util.Arrays;

public class Solution {
	public static int[] ninjaAndSortedArrays(int arr1[], int arr2[], int m, int n) {

		int i = 0;
		int j = 0;

		while (i < m && j < n) {
			if (arr1[i] > arr2[j]) {
				
			}

		}

		return arr1;

	}

	public static void main(String[] args) {

		int inputArray1[] = { 3, 6, 9 };
		int inputArray2[] = { 4, 10 };

		int[] result = ninjaAndSortedArrays(inputArray1, inputArray2, 3, 2);

		Arrays.stream(result).forEach(i -> {
			System.out.print(i + ", ");
		});

	}
}
