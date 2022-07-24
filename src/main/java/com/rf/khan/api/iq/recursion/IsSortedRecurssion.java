package com.rf.khan.api.iq.recursion;

public class IsSortedRecurssion {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 9, 0, 3, 4, 5 };
		boolean res = isSorted(arr, 7);

		if (res) {
			System.out.println("Sorted..");
		} else {
			System.out.println("Not Sorted..");
		}

	}

	private static boolean isSorted(int[] arr, int size) {

		if (size == 0 || size == 1)
			return true;

		if (arr[size - 1] < arr[size - 2])
			return false;

		return isSorted(arr, size - 1);

	}

}
