package com.rf.khan.api.iq.binary.tree;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import java.util.Vector;

public class DiagonalTraverse {

	/**
	 * This is a recursive methos
	 * 
	 * @param root
	 * @param hd
	 * @param map
	 */
	private void getDiagonalTraversal(Node root, int hd, Map<Integer, Vector<Integer>> map) {
		// base case
		if (root == null) {
			return;
		}

		Vector<Integer> vector = map.get(hd);
		if (vector == null) {
			vector = new Vector<>();
			vector.add(root.data);
		} else {
			vector.add(root.data);
		}

		// put in the map
		map.put(hd, vector);

		// Increase the vertical distance, if left child
		getDiagonalTraversal(root.left, hd + 1, map);

		// Vertical distance remains, same for right child
		getDiagonalTraversal(root.right, hd, map);
	}

	/**
	 * This method is created to get the diagonal traversal
	 * 
	 * @param root hold the information of the root element
	 * @return
	 */
	private ArrayList<Integer> diagonalTraverse(Node root) {
		ArrayList<Integer> result = new ArrayList<>();
		if (root == null) {
			return result;
		}
		Map<Integer, Vector<Integer>> map = new TreeMap<>();
		int hd = 0;
		getDiagonalTraversal(root, hd, map);

		for (Map.Entry<Integer, Vector<Integer>> m : map.entrySet()) {
			m.getValue().stream().forEach(i -> {
				result.add(i);
			});
		}

		return result;
	}

	public static void main(String[] args) {
		DiagonalTraverse d = new DiagonalTraverse();
		Node root = new Node(8);
		root.left = new Node(3);
		root.right = new Node(10);
		root.left.left = new Node(1);
		root.left.right = new Node(6);
		root.right.right = new Node(14);
		root.right.right.left = new Node(13);
		root.left.right.left = new Node(4);
		root.left.right.right = new Node(7);

		System.out.println(d.diagonalTraverse(root));
	}
}
