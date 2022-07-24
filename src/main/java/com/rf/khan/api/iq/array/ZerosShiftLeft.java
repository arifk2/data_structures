package com.rf.khan.api.iq.array;

public class ZerosShiftLeft {

	public static void main(String[] args) {

		int[] inputArray = { 0, 1, 0, 1, 0, 1, 0 };

		zeroShift(inputArray);

	}

	public static void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ", ");
		}
	}

	private static void zeroShift(int[] inputArray) {
		int left = 0, right = inputArray.length - 1;
		// main loop

		while (left < right) {
			while (inputArray[left] == 0 && left < right) {
				left++;
			}
			while (inputArray[right] == 1 && left < right) {
				right--;
			}
			if (left < right) {
				int temp = inputArray[left];
				inputArray[left] = inputArray[right];
				inputArray[right] = temp;
				/*
				 * left++; right--;
				 */
			}
		}
		printArray(inputArray);
	}
}
