package com.rf.khan.api.coding.decoded;

public class UglyNumberLC23 {

	public static void main(String[] args) {
		UglyNumberLC23 u = new UglyNumberLC23();
		System.out.println(u.isUgly(6));
	}

	public boolean isUgly(int n) {
		if (n <= 0)
			return false;

		for (int facor : new int[] { 2, 3, 5 }) {
			n = keepDividingWhenDivisible(n, facor);
		}

		return n == 1;
	}

	private int keepDividingWhenDivisible(int divident, int divisor) {
		while (divident % divisor == 0) {
			divident /= divisor;
		}
		return divident;
	}
}
