package com.rf.khan.api.iq.recursion;

public class ArraySumRecurssion {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 9, 0 };
		System.out.println(getArraySum(arr, 4));
	}

	private static int getArraySum(int[] arr, int size) {

		if (size == 0)
			return 0;

		int ans = getArraySum(arr, size - 1) + arr[size - 1];
		return ans;
	}

}
