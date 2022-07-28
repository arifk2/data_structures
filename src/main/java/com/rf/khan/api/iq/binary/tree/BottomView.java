package com.rf.khan.api.iq.binary.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class BottomView {

	Node root;

	public ArrayList<Integer> getBottomView(Node root) {
		class QueueObj {
			Node node;
			int hd;

			public QueueObj(Node node, int hd) {
				this.node = node;
				this.hd = hd;
			}
		}
		ArrayList<Integer> result = new ArrayList<>();
		if (root == null) {
			return result;
		}

		Queue<QueueObj> q = new LinkedList<>();
		Map<Integer, Node> topViewMap = new TreeMap<>();

		q.add(new QueueObj(root, 0));

		while (!q.isEmpty()) {
			QueueObj frontNode = q.peek();
			q.poll();

			// removed condition from the top view
			topViewMap.put(frontNode.hd, frontNode.node);

			// for the left
			if (frontNode.node.left != null) {
				q.add(new QueueObj(frontNode.node.left, frontNode.hd - 1));
			}

			// for right
			if (frontNode.node.right != null) {
				q.add(new QueueObj(frontNode.node.right, frontNode.hd + 1));
			}
		}

		for (Map.Entry<Integer, Node> entry : topViewMap.entrySet()) {
			result.add(entry.getValue().data);
		}

		return result;
	}

	// Driver Code
	public static void main(String args[]) {
		// creating a binary tree and entering the nodes
		BottomView tree = new BottomView();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(6);
		tree.root.right.right = new Node(7);
		tree.root.right.left.right = new Node(8);
		tree.root.right.right.right = new Node(9);

		// Function Call
		System.out.println(tree.getBottomView(tree.root));
	}

}
