package com.rf.khan.api.iq.stack;

import java.util.Stack;

public class RedundantBracket {
	public static void main(String[] args) {
		System.out.println(findRedundantBrackets("((a+b))"));
	}

	public static boolean findRedundantBrackets(String s) {
		// Step1: create a stack and push with conditions
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);

			if (ch == '(' || ch == '+' || ch == '-' || ch == '*' || ch == '/') {
				stack.push(ch);
			} else {
				// ch ya to ) bracket hoga ya to a-z hoga
				if (ch == ')') {
					boolean isRedundant = true;
					while (stack.peek() != '(') {
						char top = stack.peek();
						if (top == '+' || top == '-' || top == '*' || top == '/') {
							isRedundant = false;
						}
						// to remove the operation character from stack
						stack.pop();
					}
					if (isRedundant) {
						return true;
					}
					// now remove close (
					stack.pop();
				}
			}
		}
		return false;
	}
}
