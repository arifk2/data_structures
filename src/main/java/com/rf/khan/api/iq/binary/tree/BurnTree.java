package com.rf.khan.api.iq.binary.tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/*
 * *****************Algorithm*****************
 * Step 1: Create nodeToParent mapping
 * Step 2: find target node
 * Step 3: burn the tree in minimum time 
 * @author mkhan339
 *
 *nodeToParent mapping by level traversal
 *
 *visited map maintain
 *
 *increase the time by 1 sec if the queue has new element by using boolean flag
 *
 */
public class BurnTree {
	Node root;
	static Map<Node, Node> nodeToParent;

	/**
	 * This method will check of the left and right exit and it is not visited then
	 * insert in the q and mark as visted
	 * 
	 * @param root
	 * @param nodeToParent
	 * @return
	 */
	private static int burnTree(Node root, Map<Node, Node> nodeToParent) {
		Map<Node, Boolean> visited = new HashMap<>();
		Queue<Node> q = new LinkedList<>();

		q.add(root);
		visited.put(root, true);
		int ans = 0;

		while (!q.isEmpty()) {
			boolean flag = false;
			int size = q.size();

			for (int i = 0; i < size; i++) {
				// process neighboring node
				Node frontNode = q.peek();
				q.poll();

				// left check
				if (frontNode.left != null && !visited.containsKey(frontNode.left)) {
					q.add(frontNode.left);
					visited.put(frontNode.left, true);
					flag = true;
				}

				// right check
				if (frontNode.right != null && !visited.containsKey(frontNode.right)) {
					q.add(frontNode.right);
					visited.put(frontNode.right, true);
					flag = true;
				}

				// parent check
				if (nodeToParent.get(frontNode) != null && !visited.containsKey(nodeToParent.get(frontNode))) {
					q.add(nodeToParent.get(frontNode));
					visited.put(nodeToParent.get(frontNode), true);
					flag = true;
				}
			}
			if (flag) {
				ans++;
			}
		}

		return ans;
	}

	/**
	 * This method is created to create parent and its child relationship : left -
	 * right nodes
	 * 
	 * @param root
	 * @param target
	 * @param nodeToParent
	 * @return
	 */
	private static Node createParentMapping(Node root, int target, Map<Node, Node> nodeToParent) {
		Node res = null;
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		nodeToParent.put(root, null);

		while (!q.isEmpty()) {
			Node frontNode = q.peek();
			q.poll();

			if (frontNode.data == target) {
				res = frontNode;
			}
			if (frontNode.left != null) {
				nodeToParent.put(frontNode.left, frontNode);
				q.add(frontNode.left);
			}
			if (frontNode.right != null) {
				nodeToParent.put(frontNode.right, frontNode);
				q.add(frontNode.right);
			}
		}

		return res;
	}

	/**
	 * Driver method
	 * 
	 * @param root
	 * @param target
	 * @return
	 */
	public static int minTime(Node root, int target) {
		/*
		 * *****************Algorithm***************** 
		 * Step 1: Create nodeToParent mapping 
		 * Step 2: find target node Step 
		 * 3: burn the tree in minimum time
		 *
		 */
		nodeToParent = new HashMap<>();
		Node targetNode = createParentMapping(root, target, nodeToParent);
		int ans = burnTree(targetNode, nodeToParent);
		return ans;
	}

	public static void main(String[] args) {
		BurnTree tree = new BurnTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.right.right = new Node(6);
		tree.root.right.right.right = new Node(9);
		tree.root.right.right.right.right = new Node(10);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.left.right.left = new Node(7);
		tree.root.left.right.right = new Node(8);

		System.out.println(minTime(tree.root, 8));
	}
}
