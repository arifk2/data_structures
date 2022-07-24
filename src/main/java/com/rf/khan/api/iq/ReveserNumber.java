package com.rf.khan.api.iq;

public class ReveserNumber {
	public static void main(String[] args) {

		int n = 590;
		int ans = 0, digit = 0;
		while (n != 0) {
			digit = n % 10;
			if ((ans > Integer.MAX_VALUE / 10) || (ans < Integer.MIN_VALUE / 10)) {
				ans = 0;
				break;
			}
			ans = ans * 10 + digit;
			n = n / 10;
		}
		System.out.println(ans);
	}
}
