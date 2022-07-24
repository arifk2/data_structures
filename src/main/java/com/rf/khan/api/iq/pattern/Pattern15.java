package com.rf.khan.api.iq.pattern;

public class Pattern15 {
	public static void main(String[] args) {

		int n = 4;
		int i = 1;
		char count = 'A';
		while (i <= n) {

			int j = 1;

			while (j <= i) {

				System.out.print(count);
				count = (char) (count + 1);
				j++;
			}
			System.out.println();
			i++;
		}
	}
}
