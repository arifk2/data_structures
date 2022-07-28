package com.rf.khan.api.iq.binary.tree;

public class SumOfLargestLeafNodeBloodline {

	Node root;
	int maxSum;
	int maxLen;

	private void solve(Node root, int currLen, int currSum) {
		// base case
		if (root == null) {
			if (currLen > maxLen) {
				maxLen = currLen;
				maxSum = currSum;
			} else if (currLen == maxLen) {
				maxSum = Math.max(currSum, maxSum);
			}
			return;
		}

		currSum = currSum + root.data;
		// left call
		solve(root.left, currLen + 1, currSum);
		// right call
		solve(root.right, currLen + 1, currSum);
	}

	public int sumOfLongRootToLeafPath(Node root) {
		if (root == null) {
			return 0;
		}

		int currLen = 0;
		int currSum = 0;

		maxSum = Integer.MIN_VALUE;
		maxLen = 0;

		solve(root, currLen, currSum);

		return maxSum;
	}

	public static void main(String[] args) {

		// creating a binary tree and entering the nodes
		SumOfLargestLeafNodeBloodline tree = new SumOfLargestLeafNodeBloodline();
		tree.root = new Node(4); /* 4 */
		tree.root.left = new Node(2); /* / \ */
		tree.root.right = new Node(5); /* 2 5 */
		tree.root.left.left = new Node(7); /* / \ / \ */
		tree.root.left.right = new Node(1); /* 7 1 2 3 */
		tree.root.right.left = new Node(2); /* / */
		tree.root.right.right = new Node(3); /* 6 */
		tree.root.left.right.left = new Node(6);

		// Function Call
		System.out.println("Sum is: " + tree.sumOfLongRootToLeafPath(tree.root));
	}

}
