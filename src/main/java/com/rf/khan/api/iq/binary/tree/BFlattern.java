package com.rf.khan.api.iq.binary.tree;

public class BFlattern {
	Node root;

	public Node flatten(Node root) {
		Node res = new Node();
		Node current, pre;
		current = root;

		while (current != null) {
			if (current.left == null) {
				res.right = new Node();
				res.right = current;

				current = current.right;
			} else {
				pre = current.left;
				while (pre.right != null && pre.right != current) {
					pre = pre.right;
				}
				if (pre.right == null) {
					pre.right = current;
					current = current.left;
				} else {
					pre.right = null;

					res.right = current;

					current = current.right;
				}
			}
		}

		return res;
	}

	public void inOrder(Node root) {
		if (root == null) {
			return;
		}
		inOrder(root.left);
		System.out.print(root.data + ", ");
		inOrder(root.right);
	}

	public static void main(String[] args) {
		BFlattern tree = new BFlattern();
		tree.root = new Node(10);
		tree.root.left = new Node(6);
		tree.root.left.right = new Node(8);
		tree.root.left.left = new Node(2);
		tree.root.right = new Node(12);
		tree.root.right.left = new Node(11);
		tree.root.right.right = new Node(15);

		tree.inOrder(tree.root);
		Node res = tree.flatten(tree.root);
		System.out.println();
		tree.inOrder(res);
	}
}
