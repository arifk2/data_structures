package com.rf.khan.api.iq.pattern;

public class Pattern11 {

	public static void main(String[] args) {
		int n = 4;
		int i = 1;

		while (i <= n) {

			int j = 1;
			while (j <= n) {
				char ch = (char) ('A' + j - 1);
				System.out.print(ch);
				j++;
			}
			System.out.println();
			i++;
		}
	}
}
