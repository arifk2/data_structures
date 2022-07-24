package com.rf.khan.api.iq.pattern;

public class Pattern9 {

	public static void main(String[] args) {
		int n = 4;
		int i = 1;
		while (i <= n) {
			int j = 1;
			while (j <= i) {
				System.out.print(i - j + 1);
				j++;
			}
			System.out.println();
			i++;
		}
	}

}
