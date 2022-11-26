package com.rf.khan.api.conding.decoded;

import java.util.Arrays;
import java.util.Stack;

public class SumOfSubArrayMinimumsLC907 {
	public static void main(String[] args) {
		SumOfSubArrayMinimumsLC907 s = new SumOfSubArrayMinimumsLC907();
		System.out.println(s.sumSubarrayMins(new int[] { 3, 1, 2, 4 }));
	}

	public int sumSubarrayMins(int[] arr) {
		int mod = 1000000007;
		int len = arr.length;

		int[] leftMin = new int[len];
		Arrays.fill(leftMin, -1);

		int[] rightMin = new int[len];
		Arrays.fill(rightMin, len);

		Stack<Integer> st = new Stack<Integer>();

		// monotonic stack;
		for (int i = 0; i < len; i++) {
			while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
				int index = st.pop();
				rightMin[index] = i;
			}
			st.push(i);
		}

		st.clear();

		for (int i = len - 1; i >= 0; i--) {
			while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
				int index = st.pop();
				leftMin[index] = i;
			}
			st.push(i);
		}

		long result = 0;
		for (int i = 0; i < len; i++) {
			int leftLen = i - leftMin[i];
			int rightLen = rightMin[i] - i;

			result = (result + ((long) arr[i] * leftLen * rightLen) % mod) % mod;
		}
		return (int) result;
	}
}
