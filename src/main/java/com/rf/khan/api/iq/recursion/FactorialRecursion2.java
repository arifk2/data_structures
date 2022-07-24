package com.rf.khan.api.iq.recursion;

public class FactorialRecursion2 {

	public static void main(String[] args) {
		System.out.println(factorial(4));
	}

	public static int factorial(int n) {

		// base case

		if (n == 0) {
			return 1;
		}

		// recursive relation

		int smallerproblem = factorial(n - 1);
		int biggerProblem = n * smallerproblem;

		return biggerProblem;
	}
}
