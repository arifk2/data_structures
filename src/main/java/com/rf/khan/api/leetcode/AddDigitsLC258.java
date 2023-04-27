package com.rf.khan.api.leetcode;

public class AddDigitsLC258 {
	public static void main(String[] args) {
		AddDigitsLC258 add = new AddDigitsLC258();
		System.out.println(add.addDigits(38));
		System.out.println(add.addDigits(0));
	}

	/**
	 * This method is created to get the added digit in result
	 * 
	 * @param num holds the information of the number
	 * @return result
	 */
	public int addDigits(int num) {

		int digitRoot = 0;

		while (num > 0) {
			digitRoot += num % 10;
			num = num / 10;

			if (num == 0 && digitRoot > 9) {
				num = digitRoot;
				digitRoot = 0;
			}
		}
		return digitRoot;
	}
}
