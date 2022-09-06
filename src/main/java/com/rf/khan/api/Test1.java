package com.rf.khan.api;

import java.util.Vector;

public class Test1 {

	public static void main(String[] args) {
		int arr[] = { 6, 2, 4 };

		int n = arr.length;

		// Function call
		System.out.print(MinCostTree(arr, n));
	}

	/**
	 * 
	 * @param arr
	 * @param n
	 * @return
	 */
	private static int MinCostTree(int[] arr, int n) {
		int ans = 0;
		Vector<Integer> st = new Vector<Integer>();
		st.add(Integer.MAX_VALUE);

		for (int i = 0; i < n; i++) {
			while (st.get(st.size() - 1) <= arr[i]) {

				// get the top element
				int top = st.get(st.size() - 1);

				// remove
				st.remove(st.size() - 1);

				ans += top * Math.min(st.get(st.size() - 1), arr[i]);
			}
			st.add(arr[i]);
		}

		// for the remaining stack from the stack

		for (int i = 2; i < st.size(); i++) {
			ans += st.get(i) * st.get(i - 1);
		}

		return ans;
	}
}
