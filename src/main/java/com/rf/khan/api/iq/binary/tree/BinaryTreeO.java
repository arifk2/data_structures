package com.rf.khan.api.iq.binary.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node {
	int data;
	Node left;
	Node right;

	Node() {
	}

	public Node(int data) {
		this.data = data;
		left = null;
		right = null;
	}

	public Node buildTree(Node root) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the data : ");
		int data;
		data = scanner.nextInt();

		root = new Node(data);

		if (data == -1) {
			return null;
		}

		System.out.println("Enter data inserting to the left of " + data);
		root.left = buildTree(root.left);

		System.out.println("Enter data inserting to the right of " + data);
		root.right = buildTree(root.right);

		return root;
	}

	public void levelOrderTraversal(Node root) {
		Queue<Node> q = new LinkedList<>();
		q.add(root);

		while (!q.isEmpty()) {
			Node temp = q.peek();
			System.out.print(temp.data + " ");
			q.poll();

			if (temp.left != null) {
				q.add(temp.left);
			}

			if (temp.right != null) {
				q.add(temp.right);
			}
		}
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

	/**
	 * LNR 
	 * left 
	 * Node(print) 
	 * Right
	 * 
	 * @param root
	 */
	public void inOrder(Node root) {
		if (root == null) {
			return;
		}

		inOrder(root.left);
		System.out.print(root.data + ", ");
		inOrder(root.right);
	}

	/**
	 * NLR
	 * Node(print)
	 * Left
	 * Right
	 * @param root
	 */
	public void preOrder(Node root) {
		if (root == null) {
			return;
		}
		System.out.print(root.data + " ");
		preOrder(root.left);
		preOrder(root.right);
	}
	
	/**
	 * LRN
	 * Left
	 * Right
	 * Node(print)
	 * @param root
	 */
	public void postOrder(Node root) {
		if(root == null) {
			return;
		}
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.data+" ");
		
	}

	public int main() {
		Node root = null;
		root = buildTree(root); // 1 3 7 -1 -1 11 -1 -1 5 17 -1 -1 -1
		System.out.println("Printing Level traversal");
		levelOrderTraversal(root);
		System.out.println();
		levelOrderTraversalSeperator(root);
		System.out.println("Print InOrder Traversal");
		inOrder(root);
		System.out.println();
		System.out.println("Print PreOrder Traversal");
		preOrder(root);
		System.out.println();
		System.out.println("Print postOrder Traversal");
		postOrder(root);
		System.out.println();
		return 0;
	}

}

public class BinaryTreeO {
	public static void main(String[] args) {
		Node node = new Node();
		node.main();
	}

}
