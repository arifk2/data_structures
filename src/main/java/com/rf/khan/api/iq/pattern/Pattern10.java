package com.rf.khan.api.iq.pattern;

public class Pattern10 {
	public static void main(String[] args) {
		int n = 5;
		int row = 1;
		while (row <= n) {

			int col = 1;
			while (col <= n) {
				char ch =(char) ('A' + row - 1);
				System.out.print(ch);
				col++;
			}
			System.out.println();
			row++;
		}
	}
}
