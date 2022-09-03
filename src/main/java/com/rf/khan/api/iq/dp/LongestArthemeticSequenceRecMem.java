package com.rf.khan.api.iq.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * Dynamic Programming + Hashing
 * (NOOOOOOOOOOooo)
 * @author mkhan339
 *
 */
public class LongestArthemeticSequenceRecMem {

	int lengthOfLongestAP(int[] A, int n) {
		if (n <= 2)
			return n;

		int answer = 0;
		Map<Integer, Integer> dp = new HashMap<>(n + 1);

		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				// including 2 in recursion call because check the difference of two number so
				// that
				// number count should also be added.
				answer = Math.max(answer, 2 + solveRecursionMem(i, A[j] - A[i], A, dp));
			}
		}
		return answer;
	}

	/**
	 * This method is created for the backward check element with the difference of
	 * the element at current index
	 * 
	 * @param index
	 * @param difference
	 * @param arr
	 * @return
	 */
	private int solveRecursionMem(int index, int difference, int[] arr, Map<Integer, Integer> dp) {
		// backward check
		if (index < 0)
			return 0;

		if (dp.containsKey(index) && dp.get(index) == difference)
			return dp.get(index);

		int ans = 0;
		for (int j = index - 1; j >= 0; j--) {
			if (arr[index] - arr[j] == difference) {
				ans = Math.max(ans, 1 + solveRecursionMem(j, difference, arr, dp));
			}
			dp.put(index, ans);
		}
		dp.put(index, ans);

		return dp.get(index);
	}

	/**
	 * This is driver main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = { 3, 6, 7, 12, 16, 17, 20, 21, 22, 24, 27, 30, 35, 40, 42, 46, 48, 52, 54, 56, 58 };
		int n = arr.length;

		LongestArthemeticSequenceRecMem l = new LongestArthemeticSequenceRecMem();
		System.out.println(l.lengthOfLongestAP(arr, n));
	}
}
