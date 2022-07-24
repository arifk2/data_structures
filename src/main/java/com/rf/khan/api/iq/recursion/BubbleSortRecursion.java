package com.rf.khan.api.iq.recursion;

import java.util.Arrays;

/**
 * This class is created to solve the bubble sort using recursion
 * 
 * @author mkhan339
 *
 */
public class BubbleSortRecursion {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 9, 0, 10, 4, 3 };
		bubbleSortRecurssion(arr, arr.length);
		printArr(arr);

	}

	/**
	 * This method is created to sort bubble sort using recursion
	 * 
	 * @param arr  hold the array information
	 * @param size holds the size of the array
	 */
	private static void bubbleSortRecurssion(int[] arr, int size) {

		// because if the size is 0 or 1 then given arrays is already sorted
		if (size == 0 || size == 1) {
			return;
		}

		// 1 case solve karlo - largest element ko end me rakh do.
		for (int i = 0; i < size - 1; i++) {

			if (arr[i] > arr[i + 1]) {
				// swap kardo
				int temp = arr[i];
				arr[i] = arr[i + 1];
				arr[i + 1] = temp;
			}
		}
		bubbleSortRecurssion(arr, size - 1);
	}

	/**
	 * This method is created is created to print the array
	 * 
	 * @param arr hold the array input
	 */
	private static void printArr(int[] arr) {
		Arrays.stream(arr).forEach(i -> {
			System.out.print(i + " ");
		});
	}
}
