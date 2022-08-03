package com.rf.khan.api.iq.binary.search.tree;

import java.util.Vector;

/*
 * *********Two Sum ******************
 * 
 * As we know that inorder or the BST is
 * sorted Approach:
 * 
 * store the inorder result of the BST in vector . 
 * use two pointer approach ans
 * check for the sum and increase or decrease the pointers.
 * 
 * @author mkhan339
 *
 */
public class TwoSumBST {

	private void inOrder(Node root, Vector<Integer> in) {
		if (root == null) {
			return;
		}
		inOrder(root.left, in);
		in.add(root.data);
		inOrder(root.right, in);
	}

	public boolean findTarget(Node root, int k) {
		Vector<Integer> in = new Vector<Integer>();
		inOrder(root, in);

		int start = 0;
		int end = in.size() - 1;

		while (start < end) {
			int sum = in.get(start) + in.get(end);
			if (sum == k)
				return true;
			else if (sum > k)
				end--;
			else
				start++;
		}
		return false;
	}
}
