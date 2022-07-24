package com.rf.khan.api.iq.stack;

import java.util.Stack;

public class IsValidParenthesis {

	public static void main(String[] args) {
		System.out.println(isValidParenthesis("{([}])}"));
	}

	/**
	 * Approach: if opening bracket, stack push if close bracket, stack top check
	 * and pop
	 * 
	 * @param expression
	 * @return
	 */
	public static boolean isValidParenthesis(String expression) {
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < expression.length(); i++) {
			char ch = expression.charAt(i);
			if (ch == '(' || ch == '{' || ch == '[') {
				stack.push(ch);
			} else {
				// check the top element with the ch opposite parenthesis
				if (!stack.isEmpty()) {
					char top = stack.peek();
					// check
					if (ch == ')' && top == '(' || ch == '}' && top == '{' || ch == ']' && top == '[') {
						stack.pop();
					} else {
						return false;
					}
				} else {
					return false;
				}
			}
		}

		if (stack.isEmpty()) {
			return true;
		}

		return false;
	}
}
