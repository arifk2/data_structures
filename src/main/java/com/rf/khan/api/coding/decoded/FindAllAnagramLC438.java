package com.rf.khan.api.coding.decoded;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagramLC438 {

	public static void main(String[] args) {
		String s = "cbaebabacdxynabc", p = "abc";
		FindAllAnagramLC438 f = new FindAllAnagramLC438();
		System.out.println(f.findAnagrams(s, p));
	}

	public List<Integer> findAnagrams(String s, String p) {
		List<Integer> ans = new ArrayList<>();
		if (p.length() > s.length())
			return ans;

		int unMatchedCount = p.length();

		// Calculate the frequency count of the character of the p
		int[] freqCount = new int[26];
		for (int i = 0; i < p.length(); i++) {
			int index = p.charAt(i) - 'a';
			freqCount[index]++;
		}

		// two pointer approach
		int start = 0;
		int end = 0;

		while (end < p.length()) {
			int index = s.charAt(end) - 'a';

			if (freqCount[index] > 0) {
				unMatchedCount--;
			}
			freqCount[index]--;
			end++;
		}

		if (unMatchedCount == 0) {
			ans.add(start);
		}

		// update start and end index
		while (end < s.length()) {
			int indexStart = s.charAt(start) - 'a';
			if (freqCount[indexStart] >= 0) {
				unMatchedCount++;
			}
			freqCount[indexStart]++;
			start++;

			int indexEnd = s.charAt(end) - 'a';
			if (freqCount[indexEnd] > 0) {
				unMatchedCount--;
			}
			freqCount[indexEnd]--;

			if (unMatchedCount == 0)
				ans.add(start);
			end++;
		}

		return ans;
	}

}
