package com.rf.khan.api.iq.array.ques;

import java.util.Arrays;

public class SwapZeros {

	public static void main(String[] args) {
		moveZeroes(new int[] { 0, 1, 0, 21, 12 });
	}

	public static void moveZeroes(int[] nums) {
		int nonZeros = 0;
		for (int j = 0; j < nums.length; j++) {
			// if num is non zeros
			if (nums[j] != 0) {
				// swap kardo aur i ko badha do
				int temp = nums[j];
				nums[j] = nums[nonZeros];
				nums[nonZeros] = temp;

				nonZeros++;
			}
		}
		printArray(nums);
	}

	private static void printArray(int[] nums) {
		Arrays.stream(nums).forEach(i -> {
			System.out.print(i + " ");
		});
	}

}
