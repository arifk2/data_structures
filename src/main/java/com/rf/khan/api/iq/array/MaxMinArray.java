package com.rf.khan.api.iq.array;

public class MaxMinArray {
	public static void main(String[] args) {
		System.out.println("Maxmimum element in the array: " + getMax(new int[] { 1, 2, 4, 6, 12, 12, 3 }));
		System.out.println("Minimum element in the array: " + getMin(new int[] { 10, 9, 4, 6, 12, 12, 3 }));
		System.out.println("Maxmimum element in the array: " + getMaxMath(new int[] { 1, 2, 4, 6, 12, 12, 3 }));
	}

	static int getMax(int[] input) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < input.length; i++) {

			if (input[i] > max) {
				max = input[i];
			}
		}

		return max;
	}

	static int getMin(int[] input) {
		int min = Integer.MAX_VALUE;

		for (int i = 0; i < input.length; i++) {
			if (input[i] < min) {
				min = input[i];
			}
		}
		return min;
	}

	static int getMaxMath(int[] input) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < input.length; i++) {

			max = Math.max(max, input[i]);
		}

		return max;
	}
}
