package com.rf.khan.api.iq.binary.tree;

import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.Vector;

public class VerticalTraversal {

	Node root;

	void getVerticalOrder(Node root, int hd, TreeMap<Integer, Vector<Integer>> m) {
		// base case
		if (root == null) {
			return;
		}

		// get the vector list at Horizontal Distance
		Vector<Integer> get = m.get(hd);

		// store the value of current node in the map
		if (get == null) {
			get = new Vector<>();
			get.add(root.data);
		} else {
			get.add(root.data);
		}

		// add in map
		m.put(hd, get);

		// store node at left subtree
		getVerticalOrder(root.left, hd - 1, m);

		// store node at right subtree
		getVerticalOrder(root.right, hd + 1, m);

	}

	private ArrayList<Integer> verticalTraversal(Node root) {
		ArrayList<Integer> result = new ArrayList<>();
		TreeMap<Integer, Vector<Integer>> map = new TreeMap<>();
		// as we are starting at the zero position of the number line
		int hd = 0;
		getVerticalOrder(root, hd, map);

		// traverse the map and get the value
		for (Entry<Integer, Vector<Integer>> entry : map.entrySet()) {
			Vector<Integer> vector = entry.getValue();
			for (int v : vector) {
				result.add(v);
			}
		}
		return result;
	}

	// Driver Code
	public static void main(String args[]) {
		// creating a binary tree and entering the nodes
		VerticalTraversal tree = new VerticalTraversal();
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
		System.out.println(tree.verticalTraversal(tree.root));
	}

}
