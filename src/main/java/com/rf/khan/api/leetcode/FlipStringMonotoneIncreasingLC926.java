package com.rf.khan.api.leetcode;

public class FlipStringMonotoneIncreasingLC926 {
	public static void main(String[] args) {
		FlipStringMonotoneIncreasingLC926 f = new FlipStringMonotoneIncreasingLC926();
		System.out.println(f.minFlipsMonoIncr("00110"));
		System.out.println(f.minFlipsMonoIncr("010110"));
	}

	public int minFlipsMonoIncr(String s) {
		int index = 0;
		int zeroToOne = 0;
		int oneCount = 0;

		// skip all starting zeros
		while (index < s.length() && s.charAt(index) == '0') {
			index++;
		}

		// remaining all
		while (index < s.length()) {
			char ch = s.charAt(index);

			if (ch == '0')
				zeroToOne++;
			else
				oneCount++;

			if (zeroToOne > oneCount) {
				zeroToOne = oneCount;
			}
			index++;
		}

		return zeroToOne;
	}
}
