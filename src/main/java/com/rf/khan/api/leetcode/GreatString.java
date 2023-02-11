package com.rf.khan.api.leetcode;

import java.util.Stack;

public class GreatString {
	public static void main(String[] args) {
		String s = "leEeetcode";
		GreatString g = new GreatString();
		System.out.println(g.makeGoodS(s));
	}

	public String makeGood(String s) {
		StringBuilder sb = new StringBuilder(s);

		// until it is greater than two
		while (sb.length() > 1) {
			boolean find = false;

			for (int i = 0; i < sb.length() - 1; i++) {
				char currChar = sb.charAt(i), nextChar = sb.charAt(i + 1);

				if (Math.abs(currChar - nextChar) == 32) {
					sb.deleteCharAt(i);
					sb.deleteCharAt(i);
					find = true;
					break;
				}
			}

			if (!find)
				break;

		}

		return sb.toString();
	}

	public String makeGoodS(String s) {
		Stack<Character> st = new Stack<>();

		for (char currChar : s.toCharArray()) {
			if (!st.isEmpty() && Math.abs(st.peek() - currChar) == 32) {
				st.pop();
			} else {
				st.add(currChar);
			}
		}

		StringBuilder sb = new StringBuilder();

		for (char curChar : st) {
			sb.append(curChar);
		}

		return sb.toString();
	}
}
