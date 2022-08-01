package com.rf.khan.api.iq.binary.search.tree;

public class SearchInBST {

	public static Boolean searchInBST(Node root, int x) {
		if (root == null) {
			return false;
		}
		if (root.data == x) {
			return true;
		}
		if (root.data > x) {
			return searchInBST(root.left, x);
		} else {
			return searchInBST(root.right, x);
		}
	}

	public static Boolean searchInBSTIterative(Node root, int x) {
		Node temp = root;
		while (temp != null) {
			if (temp.data == x) {
				return true;
			}
			if (temp.data > x) {
				temp = temp.left;
			} else {
				temp = temp.right;
			}
		}
		return false;
	}
}