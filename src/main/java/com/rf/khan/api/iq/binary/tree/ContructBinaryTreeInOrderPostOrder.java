package com.rf.khan.api.iq.binary.tree;

import java.util.LinkedHashMap;
import java.util.Map;

public class ContructBinaryTreeInOrderPostOrder {

	Node root;
	Map<Integer, Integer> mapping;
	int postOrderIndex;

	Node solve(int[] in, int[] post, int n, int inOrderStartIndex, int inOrderEndIndex) {
		if (postOrderIndex < 0 || inOrderStartIndex > inOrderEndIndex) {
			return null;
		}

		int element = post[postOrderIndex--];

		Node tNode = new Node(element);

		int position = mapping.get(element);

		tNode.right = solve(in, post, n, position + 1, inOrderEndIndex);
		tNode.left = solve(in, post, n, inOrderStartIndex, position - 1);

		return tNode;

	}

	// Function to return a tree created from postorder and inoreder traversals.
	Node buildTree(int in[], int post[], int n) {
		mapping = new LinkedHashMap<Integer, Integer>();

		int inOrderStartIndex = 0;
		int inOrderEndIndex = n - 1;

		for (int i = 0; i < n; i++) {
			mapping.put(in[i], i);
		}

		postOrderIndex = n - 1;
		root = solve(in, post, n, inOrderStartIndex, inOrderEndIndex);
		return root;
	}

	public static void main(String[] args) {
		ContructBinaryTreeInOrderPostOrder c = new ContructBinaryTreeInOrderPostOrder();
		int[] in = { 4, 8, 2, 5, 1, 6, 3, 7 };
		int[] post = { 8, 4, 5, 2, 6, 7, 3, 1 };
		int n = 8;
		Node root = c.buildTree(in, post, n);
		c.printInorder(root);
	}

	void printInorder(Node node) {
		if (node == null)
			return;

		/* first recur on left child */
		printInorder(node.left);

		/* then print the data of node */
		System.out.print(node.data + " ");

		/* now recur on right child */
		printInorder(node.right);
	}
}
