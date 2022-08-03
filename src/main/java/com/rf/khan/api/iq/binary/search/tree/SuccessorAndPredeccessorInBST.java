package com.rf.khan.api.iq.binary.search.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class SuccessorAndPredeccessorInBST {

	Node root;
	Node predeccessor, successor;

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
		int key = 65;
		findPreSuc(root, key);
		System.out.println("Predessor is: " + predeccessor.data);
		System.out.println("Successor is: " + successor.data);
		System.out.println("--------------------------------------");
		ArrayList<Integer> ans = findPreSucTrav(root, key);
		System.out.println("Predessor is: " + ans.get(0));
		System.out.println("Successor is: " + ans.get(1));
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
	 * This method is created to get the predecessor and successor
	 * 
	 * @param root holds the information of the root element
	 * @param key  value
	 */
	void findPreSuc(Node root, int key) {
		// base case
		if (root == null) {
			return;
		}

		// if key is found
		if (root.data == key) {
			// Maximum value in the left subtree is predecessor
			if (root.left != null) {
				Node temp = root.left;
				while (temp.right != null)
					temp = temp.right;
				predeccessor = temp;
			}
			// Minimum value in the right sub tree is successor
			if (root.right != null) {
				Node temp = root.right;
				while (temp.left != null)
					temp = temp.left;
				successor = temp;
			}
		}

		// recursive call for the key is greater than or smaller than
		if (root.data > key) {
			successor = root;
			findPreSuc(root.left, key);
		} else {
			predeccessor = root;
			findPreSuc(root.right, key);
		}
	}

	public static ArrayList<Integer> findPreSucTrav(Node root, int key) {
		ArrayList<Integer> ans = new ArrayList<Integer>();
		Node temp = root;
		int pred = -1;
		int succ = -1;

		while (temp != null && temp.data != key) {
			if (temp.data > key) {
				succ = temp.data;
				temp = temp.left;
			} else {
				pred = temp.data;
				temp = temp.right;
			}
		}
		// pred
		if (temp != null) {
			Node left = temp.left;
			while (left != null) {
				pred = left.data;
				left = left.right;
			}
		}
		// succ
		if (temp != null) {
			Node right = temp.right;
			while (right != null) {
				succ = right.data;
				right = right.left;
			}
		}
		ans.add(pred);
		ans.add(succ);
		return ans;
	}

	public void driver() {
		int input[] = { 50, 30, 70, 20, 40, 60, 80, -1 };
		takeInput(root, input);
	}

	public static void main(String[] args) {
		SuccessorAndPredeccessorInBST b = new SuccessorAndPredeccessorInBST();
		b.driver();
	}

}
