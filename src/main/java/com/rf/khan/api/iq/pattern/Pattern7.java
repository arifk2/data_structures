package com.rf.khan.api.iq.pattern;

public class Pattern7 {
	public static void main(String[] args) {

		int n = 4;
		int row = 1;
		int count = 1;
		while (row <= n) {

			int col = 1;
			while (col <= row) {
				System.out.print(count);
				count++;
				col++;
			}
			System.out.println();
			row++;
		}
	}
}
