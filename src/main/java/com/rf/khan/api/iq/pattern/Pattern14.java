package com.rf.khan.api.iq.pattern;

public class Pattern14 {
	public static void main(String[] args) {
		int n = 5;
		int i = 1;
		while (i <= n) {

			int j = 1;
			while (j <= i) {
				char ch = (char) ('A' + i - 1);
				System.out.print(ch);
				j++;
			}
			System.out.println();
			i++;
		}
	}
}
