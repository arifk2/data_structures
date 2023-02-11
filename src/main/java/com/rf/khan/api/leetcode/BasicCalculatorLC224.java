package com.rf.khan.api.leetcode;

import java.util.Stack;

public class BasicCalculatorLC224 {

	public static void main(String[] args) {
		BasicCalculatorLC224 b = new BasicCalculatorLC224();
		System.out.println(b.calculate("(1+(4+5+2)-3)+(6+8)"));
	}

	public int calculate(String s) {
		int len = s.length();
		int sign = +1;
		int currNo = 0;
		int ans = 0;
		Stack<Integer> st = new Stack<>();

		for (int i = 0; i < len; i++) {
			if (Character.isDigit(s.charAt(i))) {
				currNo = s.charAt(i) - '0';
				while (i + 1 < len && Character.isDigit(s.charAt(i + 1))) {
					currNo = currNo * 10 + s.charAt(i) - '0';
					i++;
				}
				currNo = currNo * sign;
				ans += currNo;
				currNo = 0;
			} else if (s.charAt(i) == '+') {
				sign = +1;
			} else if (s.charAt(i) == '-') {
				sign = -1;
			} else if (s.charAt(i) == '(') {
				st.add(ans);
				st.add(sign);
				// reset
				ans = 0;
				sign = +1;
			} else if (s.charAt(i) == ')') {
				int prevSign = st.pop();
				ans = ans * prevSign;

				int prevAns = st.pop();
				ans += prevAns;
			}
		}
		return ans;
	}
}
