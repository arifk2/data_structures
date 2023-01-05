package com.rf.khan.api.coding.decoded;

public class PlusOneLC66 {
	public static void main(String[] args) {
		PlusOneLC66 p = new PlusOneLC66();
		int[] ans = p.plusOne(new int[] { 9, 9, 9 });
		System.out.println(ans);
	}

	public int[] plusOne(int[] digits) {

		for (int i = digits.length - 1; i >= 0; i--) {
			if (digits[i] < 9) {
				digits[i]++;
				return digits;
			}
			digits[i] = 0;
		}
		digits = new int[digits.length + 1];
		digits[0] = 1;
		return digits;
	}
}
