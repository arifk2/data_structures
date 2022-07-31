package com.rf.khan.api.iq.binary.tree;

import java.util.ArrayList;
import java.util.Vector;

public class KSumPaths {

	ArrayList<Integer> listOfNode = new ArrayList<>();
	// int count;
	class Count {
		int count;

		Count(int count) {
			this.count = count;
		}
	}

	private void solve(Node root, int k, Vector<Integer> paths, Count count) {
		if (root == null) {
			return;
		}

		// put root data in path vector
		paths.add(root.data);

		// left call
		solve(root.left, k, paths, count);

		// right call
		solve(root.right, k, paths, count);

		// check for the sum
		int size = paths.size();
		int sum = 0;
		for (int i = size - 1; i >= 0; i--) {
			sum += paths.get(i);
			if (sum == k) {
				count.count = count.count + 1;
				for (int j = i; j < size; j++) {
					//System.out.print(paths.get(j) + ", ");
				}
				//System.out.println();
			}
		}
		// going back remove current node data from path
		paths.remove(size - 1);
	}

	private int printKPath(Node root, int k) {
		Count count = new Count(0);
		Vector<Integer> paths = new Vector<Integer>();
		solve(root, k, paths, count);
		return count.count;
	}

	public static void main(String[] args) {
		KSumPaths kSumPaths = new KSumPaths();
		Node root = new Node(1);
		root.left = new Node(3);
		root.left.left = new Node(2);
		root.left.right = new Node(1);
		root.left.right.left = new Node(1);
		root.right = new Node(-1);
		root.right.left = new Node(4);
		root.right.left.left = new Node(1);
		root.right.left.right = new Node(2);
		root.right.right = new Node(5);
		root.right.right.right = new Node(2);

		int k = 5;
		System.out.println(kSumPaths.printKPath(root, k));
	}
}
