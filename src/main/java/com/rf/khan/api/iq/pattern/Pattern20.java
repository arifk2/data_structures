package com.rf.khan.api.iq.pattern;

public class Pattern20 {
	public static void main(String[] args) {

		int n = 10;
		int row = 1;

		while (row <= n) {

			int startime = n - row + 1;
			int count = 1;
			while (count <= startime) {
				System.out.print("*");
				count++;
			}
			startime--;
			System.out.println();
			row++;
		}
	}
}
