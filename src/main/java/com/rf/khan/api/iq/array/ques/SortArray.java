package com.rf.khan.api.iq.array.ques;

import java.util.Arrays;

public class SortArray {
	public static void main(String[] args) {
		sortPointer(new int[] { 0, 2, 1, 1, 2, 0, 1 });
	}

	private static void sortPointer(int[] arr) {
		// section
		for (int i = 0; i < arr.length - 1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[minIndex] > arr[j]) {
					minIndex = j;
				}
			}

			// swap kardo
			int temp = arr[minIndex];
			arr[minIndex] = arr[i];
			arr[i] = temp;
		}
		printArray(arr);
	}

	private static void printArray(int[] arr) {
		Arrays.stream(arr).forEach(i -> {
			System.out.print(i + " ");
		});

	}

}
