package com.rf.khan.api.iq.recursion;

public class BinarySearchRecurssion {
	public static void main(String[] args) {

		int[] arr = { 1, 3, 7, 9, 11, 12, 45 };
		boolean result = isPresentBS(arr, 0, arr.length - 1, 1);

		System.out.println(result ? "Is present" : "Not present");

	}

	/**
	 * Binary Search using recursion
	 * 
	 * @param arr
	 * @param start
	 * @param end
	 * @param targetNumber
	 * @return
	 */
	static boolean isPresentBS(int[] arr, int start, int end, int targetNumber) {

		// base case
		// if element not found crossing both the pointers
		if (start > end)
			return false;

		// checking mid
		int mid = start + (end - start) / 2;

		// if element found;
		if (arr[mid] == targetNumber)
			return true;

		// if mid is less than the target means, we need to go to the right hand side.
		if (arr[mid] < targetNumber) {
			// right me jao
			return isPresentBS(arr, mid + 1, end, targetNumber);
		} else {
			return isPresentBS(arr, start, mid - 1, targetNumber);
		}
	}
}
