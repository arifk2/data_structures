package com.rf.khan.api.iq.recursion;

public class PowerRecursion {

	public static void main(String[] args) {
		System.out.println(powerRec(5, 2));
	}

	private static int powerRec(int a, int b) {

		if (b == 0)
			return 1;

		if (b == 1)
			return a;

		// recursive call
		int ans = powerRec(a, b / 2);

		// b is even case
		if (b % 2 == 0) {
			return ans = ans * ans;
		} else {
			// b is odd
			return 2 * ans * ans;
		}
	}
}
