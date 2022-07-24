package com.rf.khan.api.iq.pattern;

public class Pattern13 {
	public static void main(String[] args) {

		int n = 3;
		int i = 1;
		while (i <= n) {

			int j = 1;
			while (j <= n) {
				char ch = (char) (i + j - 2 + 'A');
				System.out.print(ch);
				j++;
			}
			System.out.println();
			i++;
		}
	}
}
