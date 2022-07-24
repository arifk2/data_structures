package com.rf.khan.api.iq.pattern;

public class Pattern22 {
	public static void main(String[] args) {

		int n = 4;
		int row = 1;

		while (row <= n) {

			// to print space
			int space = row - 1;
			int spaceCounter = 1;
			while (spaceCounter <= space) {
				System.out.print(" ");
				spaceCounter++;
			}
			// to print number
			int col = 1;
			int numTime = n - row + 1;
			while (col <= numTime) {
				System.out.print(row);
				col++;
			}
			System.out.println();
			row++;
		}
	}
}
