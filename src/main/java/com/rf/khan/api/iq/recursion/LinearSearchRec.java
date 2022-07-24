package com.rf.khan.api.iq.recursion;

public class LinearSearchRec {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 9, 0, 3, 4, 5 };
		System.out.println(isPresent(arr, 7, 3));
	}

	private static boolean isPresent(int[] arr, int size, int target) {

		if (size == 0) {
			return false;
		}
		if (arr[size - 1] == target) {
			return true;
		}
		printArr(arr, size);
		return isPresent(arr, size - 1, target);

	}

	private static void printArr(int[] arr, int size) {
		for (int i = 0; i < size; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();

	}
}
