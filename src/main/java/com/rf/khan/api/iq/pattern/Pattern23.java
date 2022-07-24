package com.rf.khan.api.iq.pattern;

public class Pattern23 {
	public static void main(String[] args) {

		int n = 4;
		int row = 1;

		while (row <= n) {

			// to print space
			int space = n - row;
			int spaceCounter = 1;
			while (spaceCounter <= space) {
				System.out.print(" ");
				spaceCounter++;
			}
			// to print number
			int col = 1;
			while (col <= row) {
				System.out.print(row);
				col++;
			}
			System.out.println();
			row++;
		}

	}
}
