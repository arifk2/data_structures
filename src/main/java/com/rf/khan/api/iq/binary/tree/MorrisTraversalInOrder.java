package com.rf.khan.api.iq.binary.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class MorrisTraversalInOrder {
	Node root;

	public void morrisInOrderTraversal(Node root) {
		Node current, pre;

		// Step:1 initialize current as root node.
		current = root;
		// Step2:while current not equal to null.
		while (current != null) {
			// 2 a) if(current -> left is null print and move current to right.
			if (current.left == null) {
				// print
				System.out.print(current.data + ", ");
				// 2 b) move current to right.
				current = current.right;
			} else {
				// a) find the rightmost node in the current left subtree or node whose right
				// child == current
				pre = current.left;
				while (pre.right != null && pre.right != current)
					pre = pre.right;

				if (pre.right == null) {
					pre.right = current;
					current = current.left;
				} else {
					pre.right = null;
					System.out.print(current.data + ", ");
					current = current.right;
				}
			}
		}
	}

	public void morrisPreOrderTraversal(Node root) {
		Node current, pre;

		// Step:1 initialize current as root node.
		current = root;
		// Step2:while current not equal to null.
		while (current != null) {
			// 2 a) if(current -> left is null print and move current to right.
			if (current.left == null) {
				// print
				System.out.print(current.data + ", ");
				// 2 b) move current to right.
				current = current.right;
			} else {
				// a) find the rightmost node in the current left subtree or node whose right
				// child == current
				pre = current.left;
				while (pre.right != null && pre.right != current)
					pre = pre.right;

				if (pre.right == null) {
					System.out.print(current.data + ", ");
					pre.right = current;
					current = current.left;
				} else {
					pre.right = null;
					current = current.right;
				}
			}
		}
	}

	/**
	 * LRN
	 * 
	 * @param root
	 * @return
	 */
	public List<Integer> postorderMorisTraversal(Node root) {
		Deque<Integer> res = new ArrayDeque<>();
		Node current, pre;

		current = root;

		while (current != null) {
			if (current.right == null) {
				res.addFirst(current.data);
				current = current.left;
			} else {
				pre = current.right;
				while (pre.left != null && pre.left != current) {
					pre = pre.left;
				}
				if (pre.left == null) {
					pre.left = current;
					res.addFirst(current.data);
					current = current.right;
				} else {
					pre.left = null;
					current = current.left;
				}
			}
		}
		return new ArrayList<>(res);
	}

	public void inOrder(Node root) {
		if (root == null) {
			return;
		}

		inOrder(root.left);
		System.out.print(root.data + ", ");
		inOrder(root.right);
	}

	public void preOrder(Node root) {
		if (root == null) {
			return;
		}
		System.out.print(root.data + ", ");
		preOrder(root.left);
		preOrder(root.right);
	}

	public void postOrder(Node root) {
		if (root == null) {
			return;
		}
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.data + " ");
	}

	public static void main(String[] args) {
		MorrisTraversalInOrder tree = new MorrisTraversalInOrder();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.right.left = new Node(6);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);

		/*
		 * tree.inOrder(tree.root); System.out.println();
		 * tree.morrisInOrderTraversal(tree.root);
		 * System.out.println("=================="); tree.preOrder(tree.root);
		 * System.out.println(); tree.morrisPreOrderTraversal(tree.root);
		 * System.out.println("==================");
		 */
		tree.postOrder(tree.root);
		System.out.println();
		System.out.println(tree.postorderMorisTraversal(tree.root));
		System.out.println();
	}
}
