package com.rf.khan.api.iq.recursion;

import java.util.Arrays;

public class SelectionSortRecurssion {

	public static void main(String[] args) {
		int[] arr = { 2, 5, 6, 223, 45, 67, 34, 67, 343, 5656, 343, 656, 545 };
		selectionSortRecurssion(arr, 0, 1);
		printArr(arr);

	}

	/**
	 * This method is created to sort bubble sort using recursion
	 * 
	 * @param arr  hold the array information
	 * @param size holds the size of the array
	 */
	private static void selectionSortRecurssion(int[] arr, int firstPointer, int secondPointer) {

		if (arr.length == 0 || arr.length == 1) {
			return;
		}

		if (firstPointer > arr.length || secondPointer > arr.length) {
			return;
		}

		for (int i = firstPointer; i < arr.length - 1; i++) {
			int minIndex = i;
			for (int j = secondPointer; j < arr.length; j++) {
				if (arr[minIndex] > arr[j]) {
					minIndex = j;
				}
			}

			// swap kardo
			int temp = arr[minIndex];
			arr[minIndex] = arr[i];
			arr[i] = temp;
		}

		firstPointer++;
		secondPointer++;
		selectionSortRecurssion(arr, firstPointer, secondPointer);

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
