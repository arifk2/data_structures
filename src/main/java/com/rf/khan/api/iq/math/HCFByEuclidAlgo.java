package com.rf.khan.api.iq.math;

public class HCFByEuclidAlgo {

	public static void main(String[] args) {

		System.out.println("GCD of the given number is: " + gcd(24, 72));
	}

	public static int gcd(int a, int b) {
		if (a == 0) {
			return b;
		}

		if (b == 0) {
			return a;
		}

		while (a != b) {
			if (a > b) {
				a = a - b;
			} else {
				b = b - a;
			}
		}

		return a;
	}

}
