package com.rf.khan.api.iq.binary.search.tree;

import java.util.LinkedList;
import java.util.Queue;

public class Merge2BST {

	Node head1;
	Node head2;
	Node root1 = null, root2 = null;

	void merge(Node root1, Node root2) {
		Merge2BST m = new Merge2BST();
		// Step1: covert BST into DLL
		m.convertIntoSortedDLL(root1, head1);

		// if (head1 != null)
		head1.left = null;

		m.convertIntoSortedDLL(root2, head2);
		// if (head2 != null)
		head2.left = null;

		// Step2: Merge two sorted LL
		Node head = m.mergeLinkedList(head1, head2);

		// Step3: create BST from the sorted LL
		head = m.sortedLLToBST(head, m.countNode(head));

		m.levelOrderTraversalSeperator(head);
	}

	Node mergeLinkedList(Node head1, Node head2) {
		Node head = null;
		Node tail = null;

		while (head1 != null && head2 != null) {
			if (head1.data < head2.data) {

				// insert at head
				if (head == null) {
					head = head1;
					tail = head1;
					head1 = head1.right;
				} else {
					// insert at tail
					tail.right = head1;
					head1.left = tail;
					tail = head1;
					head1 = head1.right;
				}

			} else {
				if (head == null) {

					head = head2;
					tail = head2;
					head2 = head2.right;

				} else {
					tail.right = head2;
					head2.left = tail;
					tail = head2;
					head2 = head2.right;
				}
			}
		}

		while (head1 != null) {
			tail.right = head1;
			head1.left = tail;
			tail = head1;
			head1 = head1.right;
		}

		while (head2 != null) {
			tail.right = head2;
			head2.left = tail;
			tail = head2;
			head2 = head2.right;
		}

		return head;
	}

	int countNode(Node head) {
		int cnt = 0;
		Node temp = head;
		while (temp != null) {
			cnt++;
			temp = temp.right;
		}

		return cnt;
	}

	Node sortedLLToBST(Node head, int n) {
		// base case
		if (n <= 0 || head == null)
			return null;

		Node left = sortedLLToBST(head, n / 2);
		Node root = head;

		root.left = left;

		// head ko aage badha diya
		head = head.right;

		root.right = sortedLLToBST(head, n - n / 2 - 1);

		return root;
	}

	/**
	 * Covert sorted BST into DLL
	 * 
	 * @param root
	 * @param head
	 */
	void convertIntoSortedDLL(Node root, Node head) {
		if (root == null)
			return;

		// convert right part of the tree
		convertIntoSortedDLL(root.right, head);
		root.right = head;

		if (head != null)
			head.left = root;

		head = root;

		convertIntoSortedDLL(root.left, head);

	}

	public void levelOrderTraversalSeperator(Node root) {
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		q.add(null);

		while (!q.isEmpty()) {
			Node temp = q.peek();
			q.poll();

			// purana level complete traverse ho chuka hai.
			if (temp == null) {
				System.out.println();
				if (!q.isEmpty()) {
					q.add(null);
				}
			} else {
				System.out.print(temp.data + " ");
				if (temp.left != null) {
					q.add(temp.left);
				}

				if (temp.right != null) {
					q.add(temp.right);
				}
			}
		}
	}

	/* Driver code */
	public static void main(String[] args) {
		Merge2BST tree = new Merge2BST();
		/*
		 * Let us create the following tree as first tree 3 / \ 1 5
		 */
		tree.root1 = new Node(3);
		tree.root1.left = new Node(1);
		tree.root1.right = new Node(5);

		/*
		 * Let us create the following tree as second tree 4 / \ 2 6
		 */
		tree.root2 = new Node(4);
		tree.root2.left = new Node(2);
		tree.root2.right = new Node(6);

		tree.merge(tree.root1, tree.root2);

	}
}
