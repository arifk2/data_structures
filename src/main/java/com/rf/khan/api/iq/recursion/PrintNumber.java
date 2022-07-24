package com.rf.khan.api.iq.recursion;

public class PrintNumber {
	public static void main(String[] args) {
		printNumber(100);
	}

	private static void printNumber(int n) {
		// base case
		if (n == 0) {
			return;
		}

		// recursive relation
		printNumber(n - 1);
		System.out.print(n + " ");
	}

}
