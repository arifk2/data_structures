package com.rf.khan.api.iq.dp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * This class is created to get next smaller element in the array
 * 
 * @author mkhan339
 *
 */
public class NextSmallerElement {
	public static void main(String[] args) {
		int[] arr = { 2, 1, 4, 3 };
		NextSmallerElement n = new NextSmallerElement();
		System.out.println(n.getNextSmallerElement(arr));
		System.out.println(n.getNextSmallerElementUsingStack(arr));
	}

	/**
	 * Brute force to get the next smaller number
	 * 
	 * @param arr holds the information of the array
	 * @return return list of the element
	 */
	public List<Integer> getNextSmallerElement(int[] arr) {
		List<Integer> ans = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			int mini = Integer.MAX_VALUE;
			for (int j = i + 1; j < arr.length; j++) {
				mini = Math.min(mini, arr[j]);
			}
			if (arr[i] > mini)
				ans.add(mini);
			else
				ans.add(-1);
		}
		return ans;
	}

	/**
	 * Optimized way to get the next smaller element in the array
	 * 
	 * 
	 * 
	 * Approach:
	 * 
	 * Start the loop from the last, as the next smaller element for the last
	 * element will always be -1,
	 * 
	 * Create a stack with one insert as -1;
	 * 
	 * start loop from last to 0 and get the current element, and pop all the
	 * element from the stack which is greater than the current
	 * 
	 * after the while condition we are having the peek as smallest element.
	 * 
	 * Now add the peek element in the answer and add the current element in the
	 * stack
	 * 
	 * @param arr holds the information of the array
	 * @return list of the element
	 */
	public List<Integer> getNextSmallerElementUsingStack(int[] arr) {
		List<Integer> ans = new ArrayList<>();
		Stack<Integer> stack = new Stack<>();
		stack.add(-1);

		for (int i = arr.length - 1; i >= 0; i--) {
			int curr = arr[i];
			while (stack.peek() >= curr) {
				stack.pop();
			}
			ans.add(stack.peek());
			stack.add(curr);
		}
		Collections.reverse(ans);
		return ans;
	}
}
