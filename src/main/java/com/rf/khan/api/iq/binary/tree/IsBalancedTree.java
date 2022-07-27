package com.rf.khan.api.iq.binary.tree;

/**
 * *****************************************************
 * 
 * A tree is height balanced if difference between heights of left and right
 * subtrees is not more than one for all nodes of tree.
 * 
 * Class to check the balanced binary tree
 */

class IsBalancedTree {

	class Heights {
		int h;
	}

	Node root;

	private boolean isBalancedFast(Node root) {
		Heights heights = new Heights();
		return isBalancedF(root, heights);
	}

	/**
	 * This method is created to check isBalanced in optimized way
	 * 
	 * @param root
	 * @param heights
	 * @return
	 */
	private boolean isBalancedF(Node root, Heights heights) {
		Heights lh = new Heights();
		Heights rh = new Heights();

		// base case
		if (root == null) {
			heights.h = 0;
			return true;
		}

		// left check
		boolean left = isBalancedF(root.left, lh);

		// right check
		boolean right = isBalancedF(root.right, rh);

		// getting the height max of left height to right right plus node 1
		heights.h = Math.max(lh.h, rh.h) + 1;
		
		boolean heightDiff = Math.abs(lh.h - rh.h) <= 1;

		if (left && right && heightDiff) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Not optimized solution O(n sq)
	 * 
	 * @param root
	 * @return
	 */
	private boolean isBalanced(Node root) {
		// base case
		if (root == null) {
			return true;
		}

		boolean left = isBalanced(root.left);
		boolean right = isBalanced(root.right);

		boolean diffHeight = Math.abs(height(root.left) - height(root.right)) <= 1;

		if (left && right && diffHeight) {
			return true;
		} else {
			return false;
		}
	}

	private int height(Node root) {
		// base case
		if (root == null) {
			return 0;
		}

		return Math.max(height(root.left), height(root.right)) + 1;
	}

	// Driver Code
	public static void main(String args[]) {
		// creating a binary tree and entering the nodes
		IsBalancedTree tree = new IsBalancedTree();
		tree.root = new Node(10);
		tree.root.left = new Node(20);
		tree.root.right = new Node(30);
		tree.root.left.left = new Node(40);
		tree.root.left.right = new Node(30);

		// Function Call
		System.out.println("Is given Binary Tree is balanced? : " + tree.isBalanced(tree.root));
		System.out.println("Is given Binary Tree is balanced? : " + tree.isBalancedFast(tree.root));
	}

}
