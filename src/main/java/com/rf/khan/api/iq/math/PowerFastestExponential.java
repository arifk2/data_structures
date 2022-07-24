package com.rf.khan.api.iq.math;

public class PowerFastestExponential {

	public static void main(String[] args) {
	}

	public static int modularExponentiation(int x, int n, int m) {

		long ans = 1;
		

		while (n > 0) {

			if (n % 2 != 0) {
				ans = ((1L *(ans * (x) % m)) % m);
			}
			x = (int) ((1L *  (x) % m * (x) % m) % m);
			n = n / 2;
		}

		return (int) ans;

	}

}
