package com.rf.khan.api.iq.dp;

/**
 * Dynamic Programming + Hashing
 * 
 * @author mkhan339
 *
 */
public class LongestArthemeticSequenceRec {

	int lengthOfLongestAP(int[] A, int n) {
		if (n <= 2)
			return n;

		int answer = 0;

		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				// including 2 in recursion call because check the difference of two number so
				// that
				// number count should also be added.
				answer = Math.max(answer, 2 + solveRecursion(i, A[j] - A[i], A));
			}
		}
		return answer;
	}

	/**
	 * This method is created for the backward check element with the difference of
	 * the element at current index
	 * 
	 * @param index
	 * @param diffrence
	 * @param arr
	 * @return
	 */
	private int solveRecursion(int index, int diffrence, int[] arr) {
		// backward check
		if (index < 0)
			return 0;

		int ans = 0;
		for (int j = index - 1; j >= 0; j--) {
			if (arr[index] - arr[j] == diffrence) {
				ans = Math.max(ans, 1 + solveRecursion(j, diffrence, arr));
			}
		}

		return ans;
	}

	/**
	 * This is driver main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = { 1, 7, 10, 13, 14, 19 };
		int n = arr.length;

		LongestArthemeticSequenceRec l = new LongestArthemeticSequenceRec();
		System.out.println(l.lengthOfLongestAP(arr, n));
	}
}
