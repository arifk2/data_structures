package com.rf.khan.api.leetcode;

import java.util.HashSet;
import java.util.Set;

/*Given two strings s and goal, return true if you can swap two 
 	letters in s so the result is equal to goal, otherwise, return false.

Swapping letters is defined as taking two indices i and j (0-indexed) 
	such that i != j and swapping the characters at s[i] and s[j].

For example, swapping at indices 0 and 2 in "abcd" results in "cbad".*/

public class BuddyStringsLC859 {
	public static void main(String[] args) {
		String s = "ab", goal = "ba";
		String s1 = "ab", goal1 = "ab";
		String s2 = "aaaaaaabc", goal2 = "aaaaaaacb";

		BuddyStringsLC859 b = new BuddyStringsLC859();

		System.out.println(b.buddyStrings(s, goal));
		System.out.println(b.buddyStrings(s1, goal1));
		System.out.println(b.buddyStrings(s2, goal2));
	}

	public boolean buddyStrings(String s, String goal) {
		int n = s.length();

		if (s.equals(goal)) {
			Set<Character> temp = new HashSet<>();
			for (char ch : s.toCharArray()) {
				temp.add(ch);
			}
			return temp.size() < goal.length(); //swapping
		}
		int i = 0;
		int j = n - 1;

		while (i < j && s.charAt(i) == goal.charAt(i)) {
			i++;
		}
		while (j >= 0 && s.charAt(j) == goal.charAt(j)) {
			j--;
		}

		if (i < j) {
			char[] sArr = s.toCharArray();
			char temp = sArr[i];
			sArr[i] = sArr[j];
			sArr[j] = temp;

			s = new String(sArr);
		}
		return s.equals(goal);
	}
}
