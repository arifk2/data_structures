package com.rf.khan.api.iq.array;

public class PairSum {
	public static void main(String[] args) {

		int[] inputArray = { 1, 2, 3, 4, 5 };
		pairSum(inputArray, 5);
	}

	public static void pairSum(int[] arr, int s) {

		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] + arr[j] == s) {
					System.out.println(arr[i] + ", " + arr[j]);
				}
			}
		}
	}

}
