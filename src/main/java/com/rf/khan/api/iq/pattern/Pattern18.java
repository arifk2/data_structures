package com.rf.khan.api.iq.pattern;

public class Pattern18 {
	public static void main(String[] args) {

		int n = 3;
		int i = 1;

		while (i <= n) {

			int j = 1;
			char value = (char) ('A' + i - j);
			while (j <= n) {
				System.out.print(value);
				value++;
				j++;
			}
			System.out.println();
			i++; 
		}
	}
}
