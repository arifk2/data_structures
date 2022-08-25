package com.rf.khan.api.iq.dp;

public class HouseRobberyProblem {

	/**
	 * Driver method
	 * 
	 * @param valueInHouse
	 * @return
	 */
	public static long houseRobber(int[] valueInHouse) {
		int n = valueInHouse.length;

		// if only one house is their in the array
		if (n == 1)
			return valueInHouse[0];

		// create two array from the input
		// In which take first element and exclude last
		// Take last element and exclude first element

		int[] first = new int[n - 1];
		int[] second = new int[n - 1];
		int count1 = 0;
		int count2 = 0;
		for (int i = 0; i < n; i++) {
			if (i != n - 1)
				first[count1++] = valueInHouse[i];

			if (i != 0)
				second[count2++] = valueInHouse[i];
		}

		return Math.max(solveSpaceOpt(first), solveSpaceOpt(second));
	}

	public static long solveSpaceOpt(int[] valueInHouse) {
		int n = valueInHouse.length;

		long prev2 = 0;
		long prev1 = valueInHouse[0];

		for (int i = 1; i < n; i++) {
			long include = prev2 + valueInHouse[i];
			long exclude = prev1 + 0;
			long ans = Math.max(include, exclude);

			// shift
			prev2 = prev1;
			prev1 = ans;
		}
		return prev1;
	}

	/**
	 * driver
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int[] in = { 10, 2, 3, 11 };
		System.out.println(houseRobber(in));
	}
}
