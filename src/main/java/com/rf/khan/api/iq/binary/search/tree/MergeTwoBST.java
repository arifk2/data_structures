package com.rf.khan.api.iq.binary.search.tree;

import java.util.Vector;

/**
 * Merge Two BST
 * 
 * @author mkhan339
 *
 */
public class MergeTwoBST {

	/**
	 * This method is a driver method to merge two BST
	 * 
	 * @param root1 first BST root
	 * @param root2 second BST root
	 * @return root of the merged BSt
	 */
	static Node mergeBST(Node root1, Node root2) {
		Vector<Node> vector1 = new Vector<Node>();
		Vector<Node> vector2 = new Vector<Node>();

		// Step1: get the in-order of booth the BST
		inOrder(root1, vector1);
		inOrder(root2, vector2);

		// Step2: merge it into a vector
		Vector<Node> mergeInOrder = mergeInOrder(vector1, vector2);
		int size = mergeInOrder.size();
		int start = 0;
		int end = size - 1;

		// Step3: create a BST from the merged vector
		return createBalancedBST(start, end, mergeInOrder);
	}

	/**
	 * Create a BST from the in-order BST vector
	 * 
	 * @param start holds the information of the start point
	 * @param end   holds the information of the end point
	 * @param in    input in-order vector
	 * @return return BST
	 */
	static Node createBalancedBST(int start, int end, Vector<Node> in) {
		if (start > end)
			return null;
		int mid = (start + end) / 2;
		Node rootNode = in.get(mid);
		rootNode.left = createBalancedBST(start, mid - 1, in);
		rootNode.right = createBalancedBST(mid + 1, end, in);

		return rootNode;
	}

	/**
	 * This method is created to get the mergeInorder output
	 * 
	 * @param vector1 holds in-order output
	 * @param vector2 holds in-order output
	 * @return vector as a merged output
	 */
	static Vector<Node> mergeInOrder(Vector<Node> vector1, Vector<Node> vector2) {
		Vector<Node> ans = new Vector<Node>();
		int i = 0;
		int j = 0;

		while (i < vector1.size() && j < vector2.size()) {
			if (vector1.get(i).data < vector2.get(j).data) {
				ans.add(vector1.get(i));
				i++;
			} else {
				ans.add(vector2.get(j));
				j++;
			}
		}

		while (i < vector1.size()) {
			ans.add(vector1.get(i));
			i++;
		}
		while (j < vector2.size()) {
			ans.add(vector2.get(j));
			j++;
		}
		return ans;
	}

	/**
	 * This method is created to get the in-order of the BST
	 * 
	 * @param root hold the information of the root element
	 * @param in   sorted vector as output
	 */
	static void inOrder(Node root, Vector<Node> in) {
		if (root == null)
			return;

		inOrder(root.left, in);
		in.add(root);
		inOrder(root.right, in);
	}

}