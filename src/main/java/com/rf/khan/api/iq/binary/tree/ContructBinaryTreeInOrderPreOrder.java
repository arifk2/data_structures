package com.rf.khan.api.iq.binary.tree;

import java.util.LinkedHashMap;
import java.util.Map;

public class ContructBinaryTreeInOrderPreOrder {
	Node root;
	int preOrderIndex = 0;

	Map<Integer, Integer> mapping;

	private int elementPosition(int[] inorder, int element, int n) {
		for (int i = 0; i < n; i++) {
			if (inorder[i] == element) {
				return i;
			}
		}
		return -1;
	}

	private Node buildBT(int[] inorder, int[] preorder, int n, int inOrderStartIndex, int inOrderEndIndex) {
		// base case
		if (preOrderIndex >= n || inOrderStartIndex > inOrderEndIndex) {
			return null;
		}

		int element = preorder[preOrderIndex];
		preOrderIndex = preOrderIndex + 1;

		// creating root node for elements
		Node tNode = new Node(element);

		// find position of the element in the inorder array
		// int position = elementPosition(inorder, element, n); // can optimized using
		// map to get O(1)
		int position = mapping.get(element);

		// recursive call
		tNode.left = buildBT(inorder, preorder, n, inOrderStartIndex, position - 1);
		tNode.right = buildBT(inorder, preorder, n, position + 1, inOrderEndIndex);

		return tNode;
	}

	public Node buildTree(int inorder[], int preorder[], int n) {
		mapping = new LinkedHashMap<>();

		for (int i = 0; i < n; i++) {
			mapping.put(inorder[i], i);
		}

		int inOrderStartIndex = 0;
		int inOrderEndIndex = n - 1;

		root = buildBT(inorder, preorder, n, inOrderStartIndex, inOrderEndIndex);

		// postOrder(root);
		printInorder(root);
		return root;
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

	public void postOrder(Node root) {
		if (root == null) {
			return;
		}
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.data + " ");

	}

	public static void main(String[] args) {
		ContructBinaryTreeInOrderPreOrder contructBinaryTreeInOrderPreOrder = new ContructBinaryTreeInOrderPreOrder();
		/*
		 * int inorder[] = { 3, 1, 4, 0, 5, 2 }; int preorder[] = { 0, 1, 3, 4, 2, 5 };
		 * int n = 6;
		 */

		int inorder[] = { 10, 1, 30, 40, 20 };
		int preorder[] = { 1, 10, 20, 30, 40 };
		int n = 5;
		contructBinaryTreeInOrderPreOrder.buildTree(inorder, preorder, n);
	}
}
