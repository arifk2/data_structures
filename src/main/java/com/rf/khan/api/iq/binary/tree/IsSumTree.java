package com.rf.khan.api.iq.binary.tree;

public class IsSumTree {

	class Height {
		int sum;
	}

	Node root;

	boolean isSumTreeFast(Node root, Height height) {

		Height lh = new Height();
		Height rh = new Height();

		// base case
		if (root == null) {
			height.sum = 0;
			return true;
		}

		// for leave node
		if (root.left == null && root.right == null) {
			height.sum = root.data;
			return true;
		}

		boolean left = isSumTreeFast(root.left, lh);
		boolean right = isSumTreeFast(root.right, rh);

		height.sum = lh.sum + rh.sum + root.data;

		boolean conditionCheck = lh.sum + rh.sum == root.data;

		if (left && right && conditionCheck) {

			return true;
		}

		return false;
	}

	boolean isSumTree(Node root) {
		Height h = new Height();
		return isSumTreeFast(root, h);
	}
}
