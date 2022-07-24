package com.rf.khan.api.iq.array;

import java.util.Arrays;

public class Test {

	public static void main(String[] args) {
		bubbleSort(new int[] { 64, 25, 12, 22, 11 }, 5);
	}

	private static void bubbleSort(int[] arr, int n) {
		for (int i = 1; i < n; i++) {
			boolean swap = false;
			for (int j = 0; j < n - i; j++) {
				if (arr[j] > arr[j + 1]) {
					// swap kardo alternate number ko if you find the condition is true
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					swap = true;
				}
			}

			if (!swap)
				break;
		}
		printArray(arr);

	}

	private static void printArray(int[] result) {
		Arrays.stream(result).forEach(i -> {
			System.out.print(i + ", ");
		});

	}
}
