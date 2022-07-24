package com.rf.khan.api.iq.array;

public class ReverseArray {
	public static void main(String[] args) {

		int[] inputArry = { 1, 5, -4, -2, 7, 4, 12, 0 };
		reverseWithSwap(inputArry);

	}

	static void reverseWithSwap(int[] inputArray) {
		int start = 0;
		int end = inputArray.length - 1;
		while (start < end) {
			int temp = inputArray[start];
			inputArray[start] = inputArray[end];
			inputArray[end] = temp;
			start++;
			end--;
		}

		for (int i = 0; i < inputArray.length; i++) {
			System.out.print(inputArray[i] + ",");
		}
	}

}
