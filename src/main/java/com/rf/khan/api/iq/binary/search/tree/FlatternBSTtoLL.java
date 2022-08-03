package com.rf.khan.api.iq.binary.search.tree;

import java.util.Vector;

public class FlatternBSTtoLL {
	public static void inOrder(Node root, Vector<Node> in) {
		if (root == null) {
			return;
		}
		inOrder(root.left, in);
		in.add(root);
		inOrder(root.right, in);
	}

	public static Node flatten(Node root) {
		Vector<Node> in = new Vector<Node>();
		inOrder(root, in);
		int size = in.size();
		int first = 0;
		int second = 1;
		while (second < size) {
			in.get(first).left = null;
			in.get(first).right = in.get(second);
			first++;
			second++;
		}
		in.get(size - 1).left = null;
		in.get(size - 1).right = null;

		return in.get(0);
	}

}
