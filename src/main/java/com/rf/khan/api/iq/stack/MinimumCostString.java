package com.rf.khan.api.iq.stack;

import java.util.Stack;

/**
 * This class is created to get the minimum cost for the string to correct
 * 
 * @author mkhan339
 *
 */
public class MinimumCostString {

	public static void main(String[] args) {
		System.out.println(findMinimumCost("{{{}"));
		System.out.println(findMinimumCost("{{}{}}"));
		System.out.println(findMinimumCost("{{{{"));
	}

	public static int findMinimumCost(String str) {
		// check if the string has the odd bracket the return -1, which is impossible to
		// correct
		if (str.length() % 2 == 1)
			return -1;

		// create a stack, and then insert open bracket
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (ch == '{') {
				stack.push(ch);
			} else {
				// ch is } bracket, we need to check in the stack for the valid brackets
				// peek element should pe { bracket
				if (!stack.isEmpty() && stack.peek() == '{') {
					stack.pop();
				} else {
					// pushed invalid brackets
					stack.push(ch);
				}
			}
		}
		// now stack has invalid brackets
		int a = 0, b = 0;

		while (!stack.isEmpty()) {
			if (stack.peek() == '{') {
				a++;
			} else {
				b++;
			}
			stack.pop();
		}

		// check behalf of the formula
		int ans = (a + 1) / 2 + (b + 1) / 2;

		return ans;
	}
}
