package com.rf.khan.api.iq.binary.tree;

import java.util.LinkedList;
import java.util.Queue;

public class FlatternBTtoLLMorris {
	Node root;

	/**
	 * 
	 * @param root
	 */
	public static void flatten(Node root) {
		Node current, pre;
		current = root;

		while (current != null) {
			if (current.left != null) {
				pre = current.left;

				while (pre.right != null && pre.right != current)
					pre = pre.right;

				pre.right = current.right;
				current.right = current.left;
				current.left = null;
			}
			current = current.right;
		}
	}

	public void inOrder(Node root) {
		if (root == null) {
			return;
		}
		inOrder(root.left);
		System.out.print(root.data + ", ");
		inOrder(root.right);
	}

	public void levelOrder(Node root) {
		Queue<Node> q = new LinkedList<>();
		q.add(root);

		while (!q.isEmpty()) {
			Node frontNode = q.peek();
			System.out.print(frontNode.data + ", ");
			q.poll();
			if (frontNode.left != null) {
				q.add(frontNode.left);
			}
			if (frontNode.right != null) {
				q.add(frontNode.right);
			}
		}
	}

	public static void main(String[] args) {
		FlatternBTtoLLMorris tree = new FlatternBTtoLLMorris();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.left.left = new Node(3);
		tree.root.left.right = new Node(4);
		tree.root.right = new Node(5);
		tree.root.right.right = new Node(6);

		flatten(tree.root);
		tree.inOrder(tree.root);
		System.out.println();
		tree.levelOrder(tree.root);
	}
}
