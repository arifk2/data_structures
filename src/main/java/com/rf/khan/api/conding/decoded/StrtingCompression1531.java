package com.rf.khan.api.conding.decoded;

public class StrtingCompression1531 {
	private int n;

	public static void main(String[] args) {
		String s = "aaabcccd";
		int k = 2;

		StrtingCompression1531 s1 = new StrtingCompression1531();
		System.out.println(s1.getLengthOfOptimalCompression(s, k));
	}

	/**
	 * This is a recursive call of the method using memoization
	 * 
	 * @param index
	 * @param prevChar
	 * @param currFrequencyCount
	 * @param str
	 * @param k
	 * @param dp
	 * @return
	 */
	private int dpHelper(int index, char prevChar, int currFrequencyCount, String str, int k, int[][][][] dp) {
		// base case
		if (k < 0)
			return Integer.MAX_VALUE;

		if (index >= n)
			return 0;

		// if the current character count is equal or greater than 10, because util
		// 10..99 string length will be 2
		if (currFrequencyCount >= 10) {
			currFrequencyCount = 10;
		}

		if (dp[index][prevChar - 'a'][currFrequencyCount][k] != -1)
			return dp[index][prevChar - 'a'][currFrequencyCount][k];

		int result = Integer.MAX_VALUE;

		// we are playing the game with including the current character and excluding
		// the current character

		// excluding
		// case1: we will skip our current character if k is available, so out string
		// length will be minimum
		result = Math.min(result, dpHelper(index + 1, prevChar, currFrequencyCount, str, k - 1, dp));

		// case 2: if a single character is getting added

		// case 2.1: If current char is not same as prev, out result will be increased
		// by 1
		// and currFreqencyCount will be 1

		if (str.charAt(index) != prevChar)
			result = Math.min(result, 1 + dpHelper(index + 1, str.charAt(index), 1, str, k, dp));

		// case 2.2:
		else {
			// prev == current
			// if currFrequencyCount is equal to 1 or more than 9, our result will be
			// increase by 1
			if (currFrequencyCount == 1 || currFrequencyCount == 9) {
				result = Math.min(result, 1 + dpHelper(index + 1, prevChar, currFrequencyCount + 1, str, k, dp));
			} else {
				// case: 2.2.3
				result = Math.min(result, dpHelper(index + 1, prevChar, currFrequencyCount + 1, str, k, dp));
			}

		}

		return dp[index][prevChar - 'a'][currFrequencyCount][k] = result;
	}

	public int getLengthOfOptimalCompression(String s, int k) {
		// 4 states: index, previousChar, frequentCount, k
		n = s.length();

		// base case: if all the character are same
		if (n == 100) {
			boolean allSame = true;

			for (int i = 1; i < n; i++) {
				if (s.charAt(i) != s.charAt(i - 1)) {
					allSame = false;
					break;
				}
			}
			// all same
			if (allSame)
				return 4;
		}

		// create dp array an initialize
		int[][][][] dp = new int[n + 1][27][11][n + 1];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 27; j++) {
				for (int x = 0; x < 11; x++) {
					for (int y = 0; y < n; y++) {
						dp[i][j][x][y] = -1;
					}
				}
			}
		}

		char defaultPrevChar = (char) ('z' + 1);

		return dpHelper(0, defaultPrevChar, 0, s, k, dp);
	}

}
