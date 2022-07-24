package com.rf.khan.api.iq.array.ques;

import java.util.Arrays;

public class ReverseArray {

	public static void main(String[] args) {
		reverseArray(5, new int[] { 64, 25, 12, 22, 11 });
	}

	public static void reverseArray(int n, int[] arr) {
		int start = 0;
		int end = n - 1;

		while (start <= end) {
			int temp = arr[end];
			arr[end] = arr[start];
			arr[start] = temp;

			start++;
			end--;
		}
		printArray(arr);
	}

	private static void printArray(int[] arr) {
		Arrays.stream(arr).forEach(i -> {
			System.out.print(i + ", ");
		});

	}
}
