package com.rf.khan.api.iq.binary.tree;

// Class to print the Diameter
class DiameterOfBT2 {

	class Heights {
		int h;
	}

	Node root;

	private int diameter() {
		Heights h = new Heights();
		return diameter(root, h);
	}

	public int diameter(Node root, Heights heights) {
		int ans = 0;
		Heights lh = new Heights();
		Heights rh = new Heights();

		// base case
		if (root == null) {
			heights.h = 0;
			return 0;
		}

		int lDiameter = diameter(root.left, lh);
		int rDiameter = diameter(root.right, rh);

		// height of the current node is max of height of left and right
		heights.h = Math.max(lh.h, rh.h) + 1;

		ans = Math.max(lh.h + rh.h + 1, Math.max(lDiameter, rDiameter));

		return ans;
	}

	// Driver Code
	public static void main(String args[]) {
		// creating a binary tree and entering the nodes
		DiameterOfBT2 tree = new DiameterOfBT2();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);

		// Function Call
		System.out.println("The diameter of given binary tree is : " + tree.diameter());
	}

}
