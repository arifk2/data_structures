package com.rf.khan.api.iq.pattern;

public class Pattern3 {

	public static void main(String[] args) {

		int n = 4;
		int i = 1;

		while (i <= n) {
			int j = 1;
			while (j <= n) {
				System.out.print(j);
				j++;
			}
			System.out.println();
			i++;
		}
	}
}
