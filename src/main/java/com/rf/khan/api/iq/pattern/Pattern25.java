package com.rf.khan.api.iq.pattern;

public class Pattern25 {
	public static void main(String[] args) {

		int n = 9;
		int row = 1;

		while (row <= n) {

			// print 1st triangle

			int col = 1;
			int print1 = n - row + 1;
			while (col <= print1) {
				System.out.print(col);
				col++;
			}

			// print second triangle - for space

			int col3 = 1;
			int startTimes = 2 * (row - 1);
			while (col3 <= startTimes) {
				System.out.print(" ");
				col3++;

			}
			startTimes--;

			// print third triangle
			int col2 = 1;
			int print2 = n - row + 1;
			while (col2 <= print2) {
				System.out.print(print2 - col2 + 1);
				col2++;
			}
			print2--;

			System.out.println();
			row++;
		}
	}
}
