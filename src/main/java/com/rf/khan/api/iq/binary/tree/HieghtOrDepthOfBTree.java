package com.rf.khan.api.iq.binary.tree;

/*

*********************************************************
Following is the structure for data type 'TreeNode' :
*********************************************************

class TreeNode {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
 */

public class HieghtOrDepthOfBTree {

	static int maxDepth(Node root) {
		if (root == null) {
			return -1;
		}
		int left = maxDepth(root.left);
		int right = maxDepth(root.right);

		int ans = Math.max(left, right) + 1;
		return ans;
	}
}