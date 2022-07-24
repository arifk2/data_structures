package com.rf.khan.api.iq.array.ques;

import java.util.Arrays;

public class RotateArray {

	public static void main(String[] args) {

		int[] inputArray = { 1, 2, 3, 4, 5, 6, 7 };
		int steps = 3;
		rotate(inputArray, steps);
	}

	public static void rotate(int[] nums, int k) {
		int[] result = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			result[(i + k) % nums.length] = nums[i];
		}
		// copy nums into temp array
		nums = result;
		printArray(nums);
	}

	public static void printArray(int[] result) {
		Arrays.stream(result).forEach(i -> System.out.print(i + " "));
	}
}
