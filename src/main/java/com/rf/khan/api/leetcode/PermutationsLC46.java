package com.rf.khan.api.leetcode;

import java.util.ArrayList;
import java.util.List;

public class PermutationsLC46 {
	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 8 };
		PermutationsLC46 p = new PermutationsLC46();
		System.out.println(p.permute(nums));
	}

	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> ans = new ArrayList<>();
		backtrack(new ArrayList<>(), ans, nums);
		return ans;
	}

	private void backtrack(List<Integer> curr, List<List<Integer>> ans, int[] nums) {
		if (curr.size() == nums.length) {
			ans.add(new ArrayList<>(curr));
			return;
		}

		for (int num : nums) {
			if (!curr.contains(num)) {
				curr.add(num);
				backtrack(curr, ans, nums);

				// backtracking
				curr.remove(curr.size() - 1);
			}
		}
	}
}
