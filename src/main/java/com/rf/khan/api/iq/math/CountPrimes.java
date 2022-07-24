package com.rf.khan.api.iq.math;

public class CountPrimes {

	public static void main(String[] args) {
		int n = 10;
		System.out.println(countPrimes(n));
	}

	public static int countPrimes(int n) {
		boolean[] isPrime = new boolean[n];
		int count = 0;
		for (int i = 2; i < n; i++) {
			isPrime[i] = true;
		}

		// Loop's ending condition is i * i < n instead of i < sqrt(n)
		// to avoid repeatedly calling an expensive function sqrt().

		for (int i = 2; i < n; i++) {
			for (int j = 2 * i; j < n; j += i) {
				isPrime[j] = false;
			}
		}

		// checking boolean count in array
		for (boolean res : isPrime) {
			if (res) {
				count++;
			}
		}
		return count;
	}
}
