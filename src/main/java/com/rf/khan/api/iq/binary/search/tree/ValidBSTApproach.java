package com.rf.khan.api.iq.binary.search.tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class ValidBSTApproach {

	Node root;
	Node predeccessor, successor;
	ArrayList<Integer> result = new ArrayList<>();

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
		inOrder(root);
		System.out.println(result);
		System.out.println("Is valid BST? " + isSorted(result));
		System.out.println("Is valid BST? " + isValidBSTT(root));
	}

	/**
	 * Check for the sorted list
	 * 
	 * @param list
	 * @return true of the list is sorted
	 */
	public boolean isSorted(ArrayList<Integer> list) {
		if (list.isEmpty() || list.size() == 1) {
			return true;
		}
		Iterator<Integer> iterator = list.iterator();
		Integer current, previous = iterator.next();

		while (iterator.hasNext()) {
			current = iterator.next();
			if (previous.compareTo(current) > 0) {
				return false;
			}
			previous = current;
		}

		return true;
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

	public void inOrder(Node root) {
		if (root == null) {
			return;
		}
		inOrder(root.left);
		result.add(root.data);
		inOrder(root.right);
	}

	public boolean isValidBSTT(Node root) {
		return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	/**
	 * Is valid BST from the range concept
	 * 
	 * @param root
	 * @param min
	 * @param max
	 * @return
	 */
	boolean isBST(Node root, int min, int max) {
		if (root == null) {
			return true;
		}

		if (root.data > min && root.data < max) {
			boolean left = isBST(root.left, min, root.data);
			boolean right = isBST(root.right, root.data, max);
			return left && right;
		}
		return false;
	}

	public void driver() {
		int input[] = { 50, 30, 70, 20, 40, 60, 80, -1 };
		takeInput(root, input);
	}

	public static void main(String[] args) {
		ValidBSTApproach b = new ValidBSTApproach();
		b.driver();
	}

}
