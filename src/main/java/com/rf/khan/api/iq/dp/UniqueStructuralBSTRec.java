package com.rf.khan.api.iq.dp;

/**
 * This class is created to get the max total number of the unique binary search
 * tree
 * 
 * @author mkhan339
 *
 */
public class UniqueStructuralBSTRec {

	/**
	 * This method is created to get the total number of the unique BST
	 * 
	 * @param n holds the number of node from 1 to n
	 * @return
	 */
	public int numTrees(int n) {
		// base case
		if (n <= 1)
			return 1;

		int ans = 0;
		for (int i = 1; i <= n; i++) {
			ans += numTrees(i - 1) * numTrees(n - i);
		}
		return ans;
	}

	/**
	 * This is driver main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		UniqueStructuralBSTRec u = new UniqueStructuralBSTRec();
		System.out.println("Total number of the unique structural BST is: " + u.numTrees(3));
	}
}
