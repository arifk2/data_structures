package com.rf.khan.api.iq.dp;

import java.util.Vector;

public class MinCostTreeFromLeafGFG {

	static int MinCostTree(int arr[], int n) {
		int ans = 0;

		// Stack
		Vector<Integer> st = new Vector<Integer>();
		st.add(Integer.MAX_VALUE);

		// Loop to traverse the array elements
		for (int i = 0; i < n; i++) {

			// Keep array elements
			// in decreasing order by popping out
			// the elements from stack till the top
			// element is less than current element
			while (st.get(st.size() - 1) <= arr[i]) {

				// Get top element
				int top = st.get(st.size() - 1);

				// Remove it
				st.remove(st.size() - 1);

				// Get the minimum cost to remove top
				ans += top * Math.min(st.get(st.size() - 1), arr[i]);
			}

			// Push current element
			st.add(arr[i]);
		}

		// Find cost for all remaining elements
		for (int i = 2; i < st.size(); i++)
			ans += st.get(i) * st.get(i - 1);

		return ans;
	}

	// Driver Code
	public static void main(String[] args) {
		int arr[] = { 6, 2, 4 };

		int n = arr.length;

		// Function call
		System.out.print(MinCostTree(arr, n));
	}
}
