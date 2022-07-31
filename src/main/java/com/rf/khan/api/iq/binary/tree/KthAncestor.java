package com.rf.khan.api.iq.binary.tree;

public class KthAncestor {
	static int k;
	static int node = 3;

	/**
	 * Recursive method
	 * 
	 * @param root
	 * @param k
	 * @param node
	 * @return
	 */
	public Node solve(Node root, int k, int node) {
		if (root == null) {
			return null;
		}

		if (root.data == node) {
			return root;
		}

		Node leftAns = solve(root.left, k, node);
		Node rightAns = solve(root.right, k, node);

		if (leftAns != null && rightAns == null) {
			k = k - 1;
			if (k <= 0) {
				k = Integer.MAX_VALUE;
				return root;
			}
			return leftAns;
		} else if (rightAns != null && leftAns == null) {
			k = k - 1;
			if (k <= 0) {
				k = Integer.MAX_VALUE;
				return root;
			}
			return rightAns;
		}
		return null;
	}

	private int getKthAncestor(Node root, int k, int node) {

		Node ans = solve(root, k, node);
		if (ans == null || ans.data == node) {
			return -1;
		} else {
			return root.data;
		}
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		KthAncestor kthAncestor = new KthAncestor();
		Node root = new Node(1);
		root.left = new Node(4);
		root.left.right = new Node(7);
		root.left.left = new Node(3);
		root.left.right.left = new Node(8);
		root.right = new Node(2);
		root.right.right = new Node(6);
		k = 1;
		// int loc = k;
		System.out.println(kthAncestor.getKthAncestor(root, k, node));
	}

}
