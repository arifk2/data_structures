package com.rf.khan.api.iq.binary.tree;

import java.util.ArrayList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;
import java.util.concurrent.LinkedBlockingDeque;

public class Test {

	Node root;

	private ArrayList<Integer> getTopview(Node root) {
		ArrayList<Integer> result = new ArrayList<>();
		if (root == null) {
			return result;
		}

		class QueueObj {
			Node node;
			int hd;

			public QueueObj(Node node, int hd) {
				this.node = node;
				this.hd = hd;
			}
		}
		Queue<QueueObj> q = new LinkedBlockingDeque<>();
		q.add(new QueueObj(root, 0));

		Map<Integer, Node> topViewMap = new TreeMap<>();

		while (!q.isEmpty()) {
			QueueObj frontNode = q.peek();
			q.poll();

			if (!topViewMap.containsKey(frontNode.hd)) {
				topViewMap.put(frontNode.hd, frontNode.node);
			}

			if (frontNode.node.left != null) {
				q.add(new QueueObj(frontNode.node.left, frontNode.hd - 1));
			}

			if (frontNode.node.right != null) {
				q.add(new QueueObj(frontNode.node.right, frontNode.hd + 1));
			}
		}

		for (Map.Entry<Integer, Node> map : topViewMap.entrySet()) {
			result.add(map.getValue().data);
		}
		
		return result;
	}

	public static void main(String[] args) {
		// creating a binary tree and entering the nodes
		Test tree = new Test();
		tree.root = new Node(1);							// 1
		tree.root.left = new Node(2);				
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(6);
		tree.root.right.right = new Node(7);
		tree.root.right.left.right = new Node(8);
		tree.root.right.right.right = new Node(9);

		// Function Call
		System.out.println(tree.getTopview(tree.root));
	}

}
