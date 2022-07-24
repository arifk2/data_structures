package com.rf.khan.api.iq.pattern;

public class Pattern16 {
	public static void main(String[] args) {
		int n = 4;
		int row = 1;
		while (row <= n) {

			int col = 1;
			while (col <= row) {
				char ch = (char) ('A' + row + col - 2);
				System.out.print(ch);
				col++;
			}
			System.out.println();
			row++;
		}

	}
}
