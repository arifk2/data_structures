package com.rf.khan.api.iq.recursion;

public class Power {

	public static void main(String[] args) {
		System.out.println(power(10));

	}

	private static int power(int power) {

		// base case

		if (power == 0) {
			return 1;
		}

		int smallerProblem = power(power - 1);
		int biggerProblem = 2 * smallerProblem;

		return biggerProblem;
	}

}
