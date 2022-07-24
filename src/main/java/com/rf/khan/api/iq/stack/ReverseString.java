package com.rf.khan.api.iq.stack;

import java.util.Stack;

public class ReverseString {
	public static void main(String[] args) {

		String name = "GeeksforGeeks";
		Stack stack = new Stack();
		for (int i = 0; i < name.length(); i++) {
			stack.push(name.charAt(i));
		}

		String ans = "";
		while (!stack.isEmpty()) {
			ans = ans + stack.pop();
		}
		System.out.println(ans);
	}
}
