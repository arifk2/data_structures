package com.rf.khan.api.iq.binary.tree;

import java.util.ArrayList;

public class KthAncestor2 {
	static ArrayList<Integer> path = new ArrayList<>();

	private int getKthAncestor(Node root, int k, int node) {
		if (root == null) {
			return -1;
		}

		nodeToRoot(root, node);
		if (path.size() > k) {
			return path.get(k);
		}

		return -1;
	}

	private boolean nodeToRoot(Node root, int node) {
		// base case
		if (root == null) {
			return false;
		}

		if (root.data == node) {
			path.add(root.data);
			return true;
		}

		boolean left = nodeToRoot(root.left, node);
		boolean right = nodeToRoot(root.right, node);

		if (left) {
			path.add(root.data);
			return true;
		}

		if (right) {
			path.add(root.data);
			return true;
		}
		return false;
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		KthAncestor2 kthAncestor = new KthAncestor2();
		Node root = new Node(1);
		root.left = new Node(4);
		root.left.right = new Node(7);
		root.left.left = new Node(3);
		root.left.right.left = new Node(8);
		root.right = new Node(2);
		root.right.right = new Node(6);

		int node = 8;
		int k = 3;
		System.out.println(kthAncestor.getKthAncestor(root, k, node));
	}

}
