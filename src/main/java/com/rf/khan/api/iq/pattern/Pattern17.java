package com.rf.khan.api.iq.pattern;

public class Pattern17 {
	public static void main(String[] args) {

		int n = 4;
		int row = 1;

		while (row <= n) {

			int col = 1;
			char start = (char) ('A' + n - row);
			while (col <= row) {
				System.out.print(start);
				start++;
				col++;
			}
			System.out.println();
			row++;
		}
	}
}
