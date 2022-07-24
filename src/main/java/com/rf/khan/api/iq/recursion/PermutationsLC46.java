package com.rf.khan.api.iq.recursion;

import java.util.ArrayList;
import java.util.List;

public class PermutationsLC46 {

	public static void main(String[] args) {
		System.out.println(permute(new int[] { 1, 2, 3 }));
	}

	/**
	 * This method is created to get the permute combinations
	 * 
	 * @param nums holds the information of the input array
	 * @return
	 */
	public static List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> ans = new ArrayList<>();

		List<Integer> output = new ArrayList<>();
		int index = 0;

		/// call the method to handle the permutation
		solve(nums, output, ans, index);

		return ans;
	}

	private static void solve(int[] nums, List<Integer> output, List<List<Integer>> ans, int index) {

		// base case
		if (index >= nums.length) {
			ans.add(new ArrayList<>(output));
			return;
		}

		for (int j = index; j < nums.length; j++) {
			// swap the number
			int temp = nums[index];
			nums[index] = nums[j];
			nums[j] = temp;

			// printArray(nums);
			output.add(nums[index]);

			// recursive call
			solve(nums, output, ans, index + 1);

			// backtracking
			temp = nums[index];
			nums[index] = nums[j];
			nums[j] = temp;
			output.remove(output.size() - 1);
		}

	}
}
