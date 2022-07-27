package com.rf.khan.api.iq.binary.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ZigZagTraversal {

	Node root;

	public ArrayList<Integer> zigZagTraversal(Node root) {
		boolean isLeftToRight = true;
		ArrayList<Integer> result = new ArrayList<>();
		Queue<Node> q = new LinkedList<>();

		if (root == null) {
			return result;
		}
		q.add(root);

		while (!q.isEmpty()) {
			int size = q.size();
			int[] ans = new int[size];
			for (int i = 0; i < size; i++) {
				Node frontNode = q.peek();
				q.poll();

				// normal insert or reverse insert
				int index = isLeftToRight ? i : size - i - 1;
				ans[index] = frontNode.data;

				if (frontNode.left != null) {
					q.add(frontNode.left);
				}
				if (frontNode.right != null) {
					q.add(frontNode.right);
				}
			}
			isLeftToRight = !isLeftToRight;
			for (int i : ans) {
				result.add(i);
			}
		}

		return result;
	}

	// Driver Code
	public static void main(String args[]) {
		// creating a binary tree and entering the nodes
		ZigZagTraversal tree = new ZigZagTraversal();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);

		// Function Call
		System.out.println(tree.zigZagTraversal(tree.root));
	}

}
