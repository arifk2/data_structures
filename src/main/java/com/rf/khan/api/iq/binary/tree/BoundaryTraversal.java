package com.rf.khan.api.iq.binary.tree;

import java.util.ArrayList;

public class BoundaryTraversal {

	Node root;
	ArrayList<Integer> result = new ArrayList<>();

	private void traversalLeft(Node root, ArrayList<Integer> result) {
		if (root == null || (root.left == null && root.right == null)) {
			return;
		}
		result.add(root.data);
		if (root.left != null) {
			traversalLeft(root.left, result);
		} else {
			traversalLeft(root.right, result);
		}
	}

	private void traversalLeaf(Node root, ArrayList<Integer> result) {
		// base case
		if (root == null) {
			return;
		}

		if (root.left == null && root.right == null) {
			result.add(root.data);
			return;
		}
		traversalLeaf(root.left, result);
		traversalLeaf(root.right, result);

	}

	private void traverseRight(Node root, ArrayList<Integer> result) {
		// base case
		if (root == null || (root.left == null && root.right == null)) {
			return;
		}

		if (root.right != null) {
			traverseRight(root.right, result);
		} else {
			traverseRight(root.left, result);
		}

		// going back;
		result.add(root.data);

	}

	private ArrayList<Integer> boundary(Node root) {

		if (root == null) {
			return result;
		}
		// Step1: insert root data;
		result.add(root.data);

		// Step2: traverse left
		traversalLeft(root.left, result);

		// Step3: traverse Leave node

		// ------------------------------
		// left subtree
		traversalLeaf(root.left, result);

		// right subtree
		traversalLeaf(root.right, result);
		// ------------------------------

		// traverseRightPart
		traverseRight(root.right, result);

		return result;
	}

	// Driver Code
	public static void main(String args[]) {
		// creating a binary tree and entering the nodes
		BoundaryTraversal tree = new BoundaryTraversal();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);

		// Function Call
		System.out.println(tree.boundary(tree.root));
	}

}
