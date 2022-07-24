package com.rf.khan.api.iq;

public class BinaryToDecimal {

	public static void main(String[] args) {

		int n = 1111;
		int ans = 0, i = 0;
		while (n != 0) {

			int digit = n % 10;
			if (digit == 1) {
				ans = (int) (ans + Math.pow(2, i));
			}
			n = n / 10;

			i++;
		}

		System.out.println(ans);
	}
}
