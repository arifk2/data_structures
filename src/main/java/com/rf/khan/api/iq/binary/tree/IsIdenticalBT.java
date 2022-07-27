package com.rf.khan.api.iq.binary.tree;

public class IsIdenticalBT {

	boolean isIdentical(Node root1, Node root2) {
		// base case
		if (root1 == null && root2 == null) {
			return true;
		}

		if (root1 == null && root2 != null) {
			return false;
		}

		if (root1 != null && root2 == null) {
			return false;
		}

		// left check
		boolean left = isIdentical(root1.left, root2.left);

		// right check
		boolean right = isIdentical(root1.right, root2.right);

		// data check
		boolean value = root1.data == root2.data;

		if (left && right && value) {
			return true;
		} else {
			return false;
		}
	}

}
