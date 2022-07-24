package com.rf.khan.api.iq.pattern;

public class Pattern1 {
	public static void main(String[] args) {

		int n = 3;
		int i = 1;
		while (i <= n) {
			int j = 1;
			while (j <= n) {
				System.out.print("*");
				j = j + 1;
			}
			System.out.println();
			i = i + 1;
		}
	}
}
