package com.rf.khan.api.iq.binary.tree;

public class MaximumSumNonAdjacentNodes {
	Node root;

	class Pair {
		int maxSumIncluding;
		int maxSumExcluding;

		public Pair() {
		}

		public Pair(int maxSumIncluding, int maxSumExcluding) {
			this.maxSumIncluding = maxSumIncluding;
			this.maxSumExcluding = maxSumExcluding;
		}
	}

	private Pair solve(Node root) {
		if (root == null) {
			Pair sum = new Pair();
			return sum;
		}

		Pair leftPair = solve(root.left);
		Pair rightPair = solve(root.right);

		Pair sum = new Pair();
		sum.maxSumIncluding = root.data + leftPair.maxSumExcluding + rightPair.maxSumExcluding;

		sum.maxSumExcluding = Math.max(leftPair.maxSumExcluding, leftPair.maxSumIncluding)
				+ Math.max(rightPair.maxSumExcluding, rightPair.maxSumIncluding);

		return sum;
	}

	int getMaxSum(Node root) {
		Pair ans = solve(root);
		return Math.max(ans.maxSumExcluding, ans.maxSumIncluding);
	}

	public static void main(String[] args) {
		MaximumSumNonAdjacentNodes tree = new MaximumSumNonAdjacentNodes();
		tree.root = new Node(10);
		tree.root.left = new Node(1);
		tree.root.left.left = new Node(2);
		tree.root.left.left.left = new Node(1);
		tree.root.left.right = new Node(3);
		tree.root.left.right.left = new Node(4);
		tree.root.left.right.right = new Node(5);
		System.out.print(tree.getMaxSum(tree.root));
	}
}
