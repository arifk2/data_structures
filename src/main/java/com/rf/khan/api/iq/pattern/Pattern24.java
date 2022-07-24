package com.rf.khan.api.iq.pattern;

public class Pattern24 {

	public static void main(String[] args) {

		int n = 4;
		int row = 1;

		while (row <= n) {

			// print space
			int space = n - row;
			int spaceCounter = 1;
			while (spaceCounter <= space) {
				System.out.print(" ");
				spaceCounter++;
			}
			space = space - 1;

			// print first triangle
			int col = 1;
			while (col <= row) {
				System.out.print(col);
				col++;
			}
			// print third triangle
			int col2 = 1;
			int start = row - 1;
			while (col2 <= start) {
				System.out.print(start);
				start--;
			}

			System.out.println();
			row++;
		}
	}
}
