package com.rf.khan.api.iq.binary.coomplete.binary.tree;

import java.util.PriorityQueue;

/*
 ********************************************************
 * 
 * This class tells whether a given binary is heap or not
 * @author mkhan339
 *
 ********************************************************
 */
public class IsBinaryTreeHeap {
	Node<Integer> root;

	/**
	 * Is heap function
	 * 
	 * @param root
	 * @return
	 */
	private boolean isHeap(Node<Integer> root) {
		int index = 0;
		int totalCount = countNodes(root);
		if (isBST(root, index, totalCount) && isMaxOrder(root)) {
			return true;
		}
		return false;
	}

	/**
	 * This method is to count the number of nodes in heap
	 * 
	 * @param root
	 * @return
	 */
	private int countNodes(Node<Integer> root) {
		// base case
		if (root == null)
			return 0;

		int ans = 1 + countNodes(root.left) + countNodes(root.right);
		return ans;
	}

	/**
	 * This method tell a current node is BST or not;
	 * 
	 * @param root
	 * @param index
	 * @param totalCount
	 * @return
	 */
	private boolean isBST(Node<Integer> root, int index, int totalCount) {
		if (root == null) {
			return true;
		}
		if (index >= totalCount)
			return false;
		else {
			boolean left = isBST(root.left, 2 * index + 1, totalCount);
			boolean right = isBST(root.right, 2 * index + 2, totalCount);
			return left && right;
		}
	}

	/**
	 * This method check whether the tree is in max order
	 * 
	 * @param root
	 * @return
	 */
	private boolean isMaxOrder(Node<Integer> root) {
		// leaf node
		if (root.left == null && root.right == null)
			return true;

		// if left node present
		if (root.right == null) {
			return root.data > root.left.data;
		} else {
			boolean left = isMaxOrder(root.left);
			boolean right = isMaxOrder(root.right);
			return left && right && (root.data > root.left.data && root.data > root.right.data);
		}
	}

	/**
	 * This is a driver method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		IsBinaryTreeHeap tree = new IsBinaryTreeHeap();
		tree.root = new Node<Integer>(10);
		tree.root.left = new Node<Integer>(20);
		tree.root.right = new Node<Integer>(30);
		tree.root.left.left = new Node<Integer>(40);
		tree.root.left.right = new Node<Integer>(60);

		System.out.println("Is Binary Tree is heap ? " + tree.isHeap(tree.root));
	}
}
