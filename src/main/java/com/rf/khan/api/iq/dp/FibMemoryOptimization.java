package com.rf.khan.api.iq.dp;

public class FibMemoryOptimization {
	public static void main(String[] args) {
		System.out.println(fib(6));
	}

	/**
	 * This method is created for the memory optimization in dynamic programming
	 * 
	 * @param n
	 * @return
	 */
	public static int fib(int n) {
		int prev1 = 1;
		int prev2 = 0;
		int current = 0;

		if (n == 0)
			return prev2;
		
		for (int i = 2; i <= n; i++) {
			current = prev1 + prev2;

			// shifting
			prev2 = prev1;
			prev1 = current;
		}
		return current;
	}
}
