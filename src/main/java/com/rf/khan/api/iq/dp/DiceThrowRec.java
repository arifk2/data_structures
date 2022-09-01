package com.rf.khan.api.iq.dp;

/**
 * This class is create to get the number of the distinct throw of dice to make
 * the target.
 * 
 * @author mkhan339
 *
 */
public class DiceThrowRec {

	static long noOfWays(int M, int N, int X) {
		return solveUsingRecursion(N, M, X);
	}

	/**
	 * Soling using recursion
	 * 
	 * @param dices  number of dices
	 * @param faces  number of faces
	 * @param target target value
	 * @return
	 */
	private static long solveUsingRecursion(int dices, int faces, int target) {

		// base case
		if (target < 0)
			return 0;

		if (dices == 0 && target != 0)
			return 0;

		if (dices != 0 && target == 0)
			return 0;

		if (target == 0 && dices == 0)
			return 1;

		long ans = 0;
		for (int i = 1; i <= faces; i++) {
			ans = ans + solveUsingRecursion(dices - 1, faces, target - i);
		}

		return ans;
	}

	public static void main(String[] args) {
		int M = 6, N = 3, X = 12;
		System.out.println(noOfWays(M, N, X));
	}
}
