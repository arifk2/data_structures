package com.rf.khan.api.coding.decoded;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NonDecreasingSubsequenceLC491 {

	public static void main(String[] args) {
		NonDecreasingSubsequenceLC491 n = new NonDecreasingSubsequenceLC491();
		System.out.println(n.findSubsequences(new int[] { 4, 6, 7, 7 }));
	}

	public List<List<Integer>> findSubsequences(int[] nums) {
		Set<List<Integer>> result = new HashSet<>();
		List<Integer> sequence = new ArrayList<>();
		backtrack(nums, 0, sequence, result);
		return new ArrayList<>(result);
	}

	private void backtrack(int[] nums, int index, List<Integer> sequence, Set<List<Integer>> result) {
		// base case: as minimum sub-sequence should be equal to greater than 2
		if (index == nums.length) {
			if (sequence.size() >= 2) {
				result.add(new ArrayList<>(sequence));
			}
			return;
		}

		// check of the sequence list is empty or the last element of the sequence list
		// is greater than or less the current element
		if (sequence.isEmpty() || sequence.get(sequence.size() - 1) <= nums[index]) {
			// add num[i] into the sequence
			sequence.add(nums[index]);

			// recursive call
			backtrack(nums, index + 1, sequence, result);

			// backtracking: remove last number from the sequence
			sequence.remove(sequence.size() - 1);
		}

		// call recursively not appending any element
		backtrack(nums, index + 1, sequence, result);
	}
}
