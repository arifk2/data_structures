package com.rf.khan.api.conding.decoded;

import java.util.Stack;

public class EvaluteReversePolishNotationLC150 {

	public static void main(String[] args) {
		String[] tokens = { "4", "13", "5", "/", "+" };
		EvaluteReversePolishNotationLC150 e = new EvaluteReversePolishNotationLC150();
		System.out.println(e.evalRPN(tokens));
	}

	public int evalRPN(String[] tokens) {
		Stack<String> st = new Stack<>();
		for (String str : tokens) {
			if (!isOperator(str)) {
				st.push(str);
			} else {
				int element2 = Integer.parseInt(st.pop());
				int element1 = Integer.parseInt(st.pop());
				int ans = 0;

				switch (str) {
				case "*": {
					ans = element1 * element2;
					break;
				}
				case "/": {
					ans = element1 / element2;
					break;
				}
				case "+": {
					ans = element1 + element2;
					break;
				}
				case "-": {
					ans = element1 - element2;
					break;
				}
				}

				st.push(ans + "");
			}
		}
		return Integer.parseInt(st.peek());
	}

	private boolean isOperator(String str) {
		if (str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/"))
			return true;
		return false;
	}
}
