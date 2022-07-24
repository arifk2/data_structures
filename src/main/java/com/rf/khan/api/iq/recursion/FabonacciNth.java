package com.rf.khan.api.iq.recursion;

public class FabonacciNth {

	public static void main(String[] args) {
		System.out.println(fib(8));

		printFibSeries();
	}

	public static int fib(int n) {
		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		int ans = fib(n - 1) + fib(n - 2);
		return ans;
	}

	public static void printFibSeries() {
		int max = 10;
		for (int i = 0; i < max; i++) {
			System.out.print(fib(i) + " ");
		}

	}

}
