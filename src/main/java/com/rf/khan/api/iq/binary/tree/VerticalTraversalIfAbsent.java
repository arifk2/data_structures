package com.rf.khan.api.iq.binary.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.TreeMap;

public class VerticalTraversalIfAbsent {

	Node root;

	class Values {
		int min;
		int max;
	}

	public ArrayList<Integer> verticalOrder(Node root) {
		ArrayList<Integer> result = new ArrayList<>();
		Values value = new Values();
		// create a TreeMap
		TreeMap<Integer, List<Integer>> map = new TreeMap<>();
		findHorizontalDistance(root, value, value, 0, map);

		for (Entry<Integer, List<Integer>> entry : map.entrySet()) {
			List<Integer> vector = entry.getValue();
			for (int v : vector) {
				result.add(v);
			}
		}
		return result;
	}

	private void findHorizontalDistance(Node root, Values min, Values max, int hd,
			TreeMap<Integer, List<Integer>> map) {

		if (root == null) {
			return;
		}

		if (hd < min.min) {
			min.min = hd;
		} else {
			max.max = hd;
		}

		map.computeIfAbsent(hd, i -> new ArrayList<Integer>()).add(root.data);
		findHorizontalDistance(root.left, min, max, hd - 1, map);

		// Function Call with hd equal to hd + 1
		findHorizontalDistance(root.right, min, max, hd + 1, map);

	}

	// Driver Code
	public static void main(String args[]) {
		// creating a binary tree and entering the nodes
		VerticalTraversalIfAbsent tree = new VerticalTraversalIfAbsent();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);

		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);

		tree.root.right.left = new Node(6);
		tree.root.right.right = new Node(7);
		tree.root.right.right.right = new Node(9);

		// Function Call
		System.out.println(tree.verticalOrder(tree.root));
	}

}
