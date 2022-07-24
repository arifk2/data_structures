package com.rf.khan.api.iq.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class NextSmallest {

	public static void main(String[] args) {
		// 2 1 4 3
		List<Integer> input1 = Arrays.asList(3, 3, 1, 1);
		System.out.println(nextSmallerElement(input1, 4));

		int[] ans = new int[4];
		ans = nextSmallerElementArray(input1, 4);
		for (int i = 0; i < input1.size(); i++) {
			System.out.print(ans[i] + ", ");
		}

	}

	static ArrayList<Integer> nextSmallerElement(List<Integer> arr, int n) {
		ArrayList<Integer> ans = new ArrayList<>();
		Stack<Integer> stack = new Stack<>();
		stack.push(-1);

		for (int i = n - 1; i >= 0; i--) {
			Integer curr = arr.get(i);
			while (stack.peek() >= curr) {
				stack.pop();
			}
			ans.add(stack.peek()); // ya to -1 milega ya to smaller than curr
			stack.push(curr);
		}
		Collections.reverse(ans);
		return ans;
	}

	
	static int[] nextSmallerElementArray(List<Integer> arr, int n) {
		int[] ans = new int[n];
		Stack<Integer> stack = new Stack<>();
		stack.push(-1);

		for (int i = n - 1; i >= 0; i--) {
			int curr = arr.get(i);
			while (stack.peek() >= curr) {
				stack.pop();
			}

			// ya to -1 milega ya to smaller than curr
			ans[i] = stack.peek();
			stack.push(curr);
		}
		// Collections.reverse(ans);
		return ans;
	}

}
