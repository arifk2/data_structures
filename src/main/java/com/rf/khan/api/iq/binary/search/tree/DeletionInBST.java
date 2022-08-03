package com.rf.khan.api.iq.binary.search.tree;

import java.util.LinkedList;
import java.util.Queue;

public class DeletionInBST {

	Node root;

	/**
	 * This method is created to take the input and pass
	 * 
	 * @param root
	 * @param input
	 */
	void takeInput(Node root, int[] input) {
		int count = 0;

		while (input[count] != -1) {
			root = insertInToBST(root, input[count]);
			count++;
		}

		// binary search tree created
		levelOrderTraversalSeperator(root);
		System.out.println();
		System.out.println("In Order");
		inOrder(root);
		System.out.println();
		System.out.println("-----------------------");
		deleteNode(root, 50);
		levelOrderTraversalSeperator(root);
		System.out.println();
		System.out.println("In Order");
		inOrder(root);
	}

	private void inOrder(Node root) {
		// base case
		if (root == null) {
			return;
		}

		inOrder(root.left);
		System.out.print(root.data + " ");
		inOrder(root.right);
	}

	/**
	 * This method is to insert the node in the BST
	 * 
	 * @param root
	 * @param data
	 * @return
	 */
	private Node insertInToBST(Node root, int data) {
		// base case
		if (root == null) {
			root = new Node(data);
			return root;
		}

		// recursive call
		if (data > root.data) {
			// right part insert
			root.right = insertInToBST(root.right, data);
		} else {
			// left part insert
			root.left = insertInToBST(root.left, data);
		}
		return root;
	}

	/**
	 * Levler order traversal of the tree
	 * 
	 * @param root
	 */
	public void levelOrderTraversalSeperator(Node root) {
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		q.add(null);

		while (!q.isEmpty()) {
			Node temp = q.peek();
			q.poll();

			// purana level complete traverse ho chuka hai.
			if (temp == null) {
				System.out.println();
				if (!q.isEmpty()) {
					q.add(null);
				}
			} else {
				System.out.print(temp.data + " ");
				if (temp.left != null) {
					q.add(temp.left);
				}

				if (temp.right != null) {
					q.add(temp.right);
				}
			}
		}
	}

	public Node deleteNode(Node root, int data) {
		if (root == null) {
			return null;
		}
		if (root.data == data) {

			// 0 Child
			if (root.left == null && root.right == null) {
				root = null;
				return null;
			}

			// 1 Child
			// left child
			if (root.left != null && root.right == null) {
				Node temp = root.left;
				root = null;
				return temp;
			}
			// right child
			if (root.right != null && root.left == null) {
				Node temp = root.right;
				root = null;
				return temp;
			}

			// 2 child
			if (root.left != null && root.right != null) {
				int mini = minValue(root.right);
				root.data = mini;
				root.right = deleteNode(root.right, mini);
				return root;
			}

		} else if (root.data > data) {
			root.left = deleteNode(root.left, data);
			return root;
		} else {
			root.right = deleteNode(root.right, data);
			return root;
		}
		return root;
	}

	private int minValue(Node right) {
		if (right == null) {
			return -1;
		}
		Node temp = right;
		while (temp.left != null) {
			temp = temp.left;
		}
		return temp.data;
	}

	public void driver() {
		int input[] = { 50, 20, 70, 10, 30, 90, 110, -1 };
		takeInput(root, input);
	}

	public static void main(String[] args) {
		DeletionInBST b = new DeletionInBST();
		b.driver();
	}

}
