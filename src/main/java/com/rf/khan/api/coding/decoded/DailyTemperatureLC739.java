package com.rf.khan.api.coding.decoded;

import java.util.Stack;

public class DailyTemperatureLC739 {
	public static void main(String[] args) {
		int[] temperatures = { 73, 74, 75, 71, 69, 72, 76, 73 };
		DailyTemperatureLC739 d = new DailyTemperatureLC739();
		int[] ans = d.dailyTemperatures(temperatures);

		for (int i = 0; i < ans.length; i++) {
			System.out.print(ans[i] + ", ");
		}
		System.out.println();
		int[] optAns = d.dailyTemperaturesOPt(temperatures);
		for (int i = 0; i < optAns.length; i++) {
			System.out.print(optAns[i] + " ");
		}

	}

	public int[] dailyTemperatures(int[] temperatures) {
		int[] ans = new int[temperatures.length];

		for (int i = 0; i < temperatures.length; i++) {
			int indexDiff = 0;
			for (int j = i + 1; j < temperatures.length; j++) {
				if (temperatures[i] < temperatures[j]) {
					indexDiff = j - i;
					break;
				}
			}
			ans[i] = indexDiff;
		}

		return ans;
	}

	public int[] dailyTemperaturesOPt(int[] temperatures) {
		int[] ans = new int[temperatures.length];
		Stack<Integer> st = new Stack<>();

		for (int i = 0; i < temperatures.length; i++) {
			while (!st.isEmpty() && temperatures[st.peek()] < temperatures[i]) {
				ans[st.peek()] = i - st.peek();
				st.pop();
			}
			st.add(i);
		}

		return ans;
	}
}
