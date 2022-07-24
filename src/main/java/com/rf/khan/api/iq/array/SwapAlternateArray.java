package com.rf.khan.api.iq.array;

public class SwapAlternateArray {

	public static void main(String[] args) {
		alternateSwap(new int[] { 1, 2, 5, 6, 0, -1, 3, 4 });
		System.out.println();
		alternateSwap(new int[] { 1, 2, 5, 6, 0, -1, 3, 4, 3 });
	}

	public static void alternateSwap(int[] inputArray) {

		// we need to increment the i with 2, as we need to swap next two numbers
		for (int i = 0; i < inputArray.length; i += 2) {
			if (i + 1 < inputArray.length) {
				int temp = inputArray[i];
				inputArray[i] = inputArray[i + 1];
				inputArray[i + 1] = temp;
			}
		}
		printArray(inputArray);

	}

	public static void printArray(int[] inputArray) {
		for (int i = 0; i < inputArray.length; i++) {
			System.out.print(inputArray[i] + ", ");
		}
	}
}