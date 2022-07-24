package com.rf.khan.api.iq;

/**
 * This is a class created to get the power of the number
 * 
 * @author mkhan339
 *
 */
public class PowerOfTwo {
	public static void main(String[] args) {
		System.out.println(power(15));

	}

	/**
	 * This method is create to get the power of the fourth
	 * 
	 * @param n input number
	 * @return result
	 */
	public static boolean power(int n) {
		int ans = 1;
		for (int i = 0; i <= 30; i++) {
			if (ans == n) {
				return true;
			}
			ans = ans * 4;
		}
		return false;

	}

	/*
	 * public static boolean power(int n) {
	 * 
	 * int ans = 1;
	 * 
	 * for (int i = 0; i <= 30; i++) { System.out.println(i); ans = (int)
	 * Math.pow(2, i); if (n == ans) { return true; } } return false; }
	 */

}
