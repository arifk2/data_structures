package com.rf.khan.api.iq.pattern;

public class Pattern5 {

	public static void main(String[] args) {
		int n = 4;
		int row = 1;

		while (row <= n) {
			int column = 1;
			while (column <= row) {
				System.out.print(column);
				column++;
			}
			System.out.println();
			row++;
		}

	}
}
