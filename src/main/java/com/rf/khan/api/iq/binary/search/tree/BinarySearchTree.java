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

	void takeInput(Node root, int[] input) {
		int count = 0;

		while (input[count] != -1) {
			root = insertInToBST(root, input[count]);
			count++;
		}

		// binary search tree created
		levelOrderTraversalSeperator(root);
	}

	/**
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

	public void driver() {
		int input[] = { 10, 8, 21, 7, 27, 5, 4, 3, -1 };
		takeInput(root, input);
	}

	public static void main(String[] args) {
		BinarySearchTree b = new BinarySearchTree();
		b.driver();
	}
}
