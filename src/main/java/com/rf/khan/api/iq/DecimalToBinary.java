package com.rf.khan.api.iq;

public class DecimalToBinary {

	public static void main(String[] args) {
		int n = 1000;
		int ans = 0;
		int i = 0;
		while (n != 0) {
			int bit = n & 1;
			ans = (int) ((bit * Math.pow(10, i)) + ans);
			n = n >> 1;
			i++;
		}

		System.out.println(ans);

	}
}
