package com.rf.khan.api.iq.binary.search.tree;

import java.util.LinkedList;
import java.util.Queue;

class Node {
	int data;
	Node left;
	Node right;

	public Node(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}

	public Node() {
		// TODO Auto-generated constructor stub
	}

}

public class BinarySearchTree {

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
		System.out.println("---In Order---");
		inOrder(root);
		System.out.println();
		System.out.println("---Pre Order---");
		preOrder(root);
		System.out.println();
		System.out.println("---Post Order---");
		postOrder(root);
		System.out.println();
		System.out.println("Minimum data in BST is: " + miniInBST(root));
		System.out.println("Maximum data in BST is: " + maxInBST(root));
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

	/**
	 * LNR
	 * 
	 * @param root
	 */
	void inOrder(Node root) {
		if (root == null) {
			return;
		}
		inOrder(root.left);
		System.out.print(root.data + " ");
		inOrder(root.right);
	}

	/**
	 * NLR
	 * 
	 * @param root
	 */
	public void preOrder(Node root) {
		if (root == null) {
			return;
		}
		System.out.print(root.data + " ");
		preOrder(root.left);
		preOrder(root.right);
	}

	/**
	 * LRN Left Right Node(print)
	 * 
	 * @param root
	 */
	public void postOrder(Node root) {
		if (root == null) {
			return;
		}
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.data + " ");

	}

	/**
	 * Minimum data or node in BST
	 * 
	 * @param root
	 * @return
	 */
	public int miniInBST(Node root) {
		if (root == null) {
			return -1;
		}
		Node temp = root;
		while (temp.left != null) {
			temp = temp.left;
		}
		return temp.data;
	}

	public int maxInBST(Node root) {
		if (root == null) {
			return -1;
		}
		Node temp = root;
		while (temp.right != null) {
			temp = temp.right;
		}
		return temp.data;
	}

	public void driver() {
		int input[] = { 10, 8, 21, 7, 27, 5, 4, 3, -1 };
		takeInput(root, input);
	}

	public static void main(String[] args) {
		BinarySearchTree b = new BinarySearchTree();
		b.driver();
	}
}
