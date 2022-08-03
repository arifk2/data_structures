package com.rf.khan.api.iq.binary.search.tree;

public class LCAinBST {

	Node root;

	/**
	 * Recursive way
	 * 
	 * @param root
	 * @param p
	 * @param q
	 * @return
	 */
	public static Node LCAinaBST(Node root, Node p, Node q) {
		if (root == null) {
			return null;
		}
		if (root.data < p.data && root.data < q.data)
			return LCAinaBST(root.right, p, q);
		if (root.data > p.data && root.data > q.data)
			return LCAinaBST(root.left, p, q);

		return root;
	}

	/**
	 * Iterative way
	 * 
	 * @param root
	 * @param p
	 * @param q
	 * @return
	 */
	public Node lowestCommonAncestor(Node root, Node p, Node q) {

		while (root != null) {
			if (root.data > p.data && root.data > p.data) {
				root = root.left;
			} else if (root.data < p.data && root.data < p.data) {
				root = root.right;
			} else {
				return root;
			}
		}
		return null;
	}

}
