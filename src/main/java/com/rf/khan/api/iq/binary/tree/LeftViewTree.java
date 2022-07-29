package com.rf.khan.api.iq.binary.tree;

import java.util.ArrayList;

public class LeftViewTree {
	Node root;
	int level;
	ArrayList<Integer> result ;

	void solve(Node root, ArrayList<Integer> result, int level) {

		// base case
		if (root == null) {
			return;
		}

		// new level
		if (level == result.size()) {
			result.add(root.data);
		}

		solve(root.left, result, level + 1);
		solve(root.right, result, level + 1);
	}

	// Function to return list containing elements of left view of binary tree.
	ArrayList<Integer> leftView(Node root) {
		if (root == null) {
			return result;
		}
		
		level = 0;
		result = new ArrayList<>();
		
		solve(root, result, level);
		return result;
	}

	public static void main(String[] args) {
		// creating a binary tree and entering the nodes
		LeftViewTree tree = new LeftViewTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(6);
		tree.root.right.right = new Node(7);
		tree.root.right.left.right = new Node(8);
		tree.root.right.right.right = new Node(9);

		// Function Call
		System.out.println(tree.leftView(tree.root));
	}
}