package com.rf.khan.api.iq.binary.complete.binary.tree;

import java.util.ArrayList;

/*
 * **************************
 * Covert BST to min heap.
 * Given BSt is a CBT
 * should satisfy min property and left element should also smaller than the right element
 * @author mkhan339
 *
 */
public class BSTtoMinHeap {

	/**
	 * Getting the in-order of the BST
	 * 
	 * @param root
	 * @param inOrderRes
	 */
	private static void inOrder(Node<Integer> root, ArrayList<Integer> inOrderRes) {
		if (root == null)
			return;

		inOrder(root.left, inOrderRes);
		inOrderRes.add(root.data);
		inOrder(root.right, inOrderRes);
	}

	/**
	 * To handle the array input
	 */
	static int index;

	/**
	 * By the help of the pre-order, replacing the values in the tree
	 * 
	 * @param root       holds the information of the root element
	 * @param inOrderRes
	 */
	private static void arrToMinHeap(Node<Integer> root, ArrayList<Integer> inOrderRes) {
		if (root == null)
			return;

		root.data = inOrderRes.get(index++);
		arrToMinHeap(root.left, inOrderRes);
		arrToMinHeap(root.right, inOrderRes);

	}

	/**
	 * Driver method to convert in min heap
	 * 
	 * @param root
	 */
	static void convertToMinHeap(Node<Integer> root) {
		index = 0;
		ArrayList<Integer> inOrderRes = new ArrayList<>();
		inOrder(root, inOrderRes);
		arrToMinHeap(root, inOrderRes);
	}

	/**
	 * This method is created for the verification, as we know that the preorder of
	 * this will be sorted
	 * 
	 * @param root
	 */
	static void preOrderForVerification(Node<Integer> root) {
		if (root == null)
			return;
		System.out.print(root.data + " ");
		preOrderForVerification(root.left);
		preOrderForVerification(root.right);
	}

	/**
	 * Main method for the input and method call
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Node<Integer> root = new Node<Integer>(4);
		root.left = new Node<Integer>(2);
		root.right = new Node<Integer>(6);
		root.left.left = new Node<Integer>(1);
		root.left.right = new Node<Integer>(3);
		root.right.left = new Node<Integer>(5);
		root.right.right = new Node<Integer>(7);

		System.out.println("PreOrder Before coversion " + "\n");
		preOrderForVerification(root);
		convertToMinHeap(root);
		System.out.println("\n" + "PreOrder Before coversion " + "\n");
		preOrderForVerification(root);
	}
}
