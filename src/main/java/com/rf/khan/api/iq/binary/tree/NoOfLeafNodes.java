package com.rf.khan.api.iq.binary.tree;

public class NoOfLeafNodes {

	class Node<T> {
		T data;
		Node<T> left;
		Node<T> right;

		public Node(T d) {
			this.data = d;
			left = null;
			right = null;
		}
	}

	/**
	 * This method is created to get the number of leaf node
	 * 
	 * @param root
	 * @return
	 */
	public static int noOfLeafNodes(Node<Integer> root) {
		int count = 0;
		if (root == null) {
			return 0;
		}
		// sub - left
		if (root.left != null) {
			count += noOfLeafNodes(root.left);
		}

		// if it first root node: node 1
		if (root.left == null && root.right == null) {
			count++;
		}
		// sub - right
		if (root.right != null) {
			count += noOfLeafNodes(root.right);
		}

		return count;
	}
}