package com.rf.khan.api.iq.binary.tree;

/**
 * Least Common Ancestor
 * 
 * @author mkhan339
 *
 */
public class LCA {
	Node root;

	/**
	 * This method is created to fin the LCA
	 * 
	 * @param root holds the information of the root
	 * @param n1   input
	 * @param n2   input
	 * @return
	 */
	private Node findLCA(Node root, int n1, int n2) {
		if (root == null) {
			return null;
		}

		if (root.data == n1 || root.data == n2) {
			return root;
		}

		Node leftAns = findLCA(root.left, n1, n2);
		Node rightAns = findLCA(root.right, n1, n2);

		if (leftAns != null && rightAns == null) {
			return leftAns;
		} else if (leftAns == null && rightAns != null) {
			return rightAns;
		} else if (leftAns != null && rightAns != null) {
			return root;
		} else {
			return null;
		}
	}

	/**
	 * Driver method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		LCA tree = new LCA();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(6);
		tree.root.right.right = new Node(7);

		System.out.println("LCA(4, 5): " + tree.findLCA(tree.root, 4, 5).data);
		System.out.println("LCA(4, 6): " + tree.findLCA(tree.root, 4, 6).data);
		System.out.println("LCA(3, 4): " + tree.findLCA(tree.root, 3, 4).data);
		System.out.println("LCA(2, 4): " + tree.findLCA(tree.root, 2, 4).data);
	}

}
