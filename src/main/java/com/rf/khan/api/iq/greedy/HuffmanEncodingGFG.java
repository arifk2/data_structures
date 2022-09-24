package com.rf.khan.api.iq.greedy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class HuffmanEncodingGFG {

	class Node {
		int data;
		Node left;
		Node right;

		public Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

	/**
	 * This method is created to get the huffman code for the given characters
	 * 
	 * @param S holds the information of the string
	 * @param f holds the information of the frequency of the string
	 * @param N total number of characters
	 * @return answer in arrayList
	 */
	public ArrayList<String> huffmanCodes(String S, int f[], int N) {

		PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				return Integer.compare(o1.data, o2.data);
			}
		});

		for (int i = 0; i < N; i++) {
			Node temp = new Node(f[i]);
			pq.add(temp);
		}

		while (pq.size() > 1) {
			Node left = pq.peek();
			pq.poll();

			Node right = pq.peek();
			pq.poll();

			Node newNode = new Node(left.data + right.data);
			newNode.left = left;
			newNode.right = right;

			pq.add(newNode);
		}

		Node rootNode = pq.peek();
		ArrayList<String> ans = new ArrayList<>();
		String temp = "";
		traverse(rootNode, ans, temp);

		return ans;
	}

	/**
	 * This method is created to traverse and get the answer
	 * 
	 * @param rootNode holds the information of the root node
	 * @param ans      holds the information of the answer
	 * @param temp     holds the information of encoding of each character
	 */
	private void traverse(Node rootNode, ArrayList<String> ans, String temp) {
		// base case: found leaf node then add the temp into ans
		if (rootNode.left == null && rootNode.right == null) {
			ans.add(new String(temp));
			return;
		}

		traverse(rootNode.left, ans, temp + 0);
		traverse(rootNode.right, ans, temp + 1);
	}

	/**
	 * This is a driver main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		String S = "abcdef";
		int f[] = { 5, 9, 12, 13, 16, 45 };
		int n = 6;
		HuffmanEncodingGFG h = new HuffmanEncodingGFG();
		System.out.println(h.huffmanCodes(S, f, n));

	}
}
