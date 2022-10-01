package com.rf.khan.api.iq.recursion;

/**
 * https://leetcode.com/problems/find-the-winner-of-the-circular-game/
 * 
 * @author mkhan339
 *
 */

class Node {
	final int num;
	Node next;
	Node prev;

	public Node(int num) {
		this.num = num;
	}

	public void kill() {
		prev.next = next;
		next.prev = prev;
	}

}

public class WinnerCircularGameLC2Nodes {

	/**
	 * This method is created to find the winner
	 * 
	 * @param n total number of friends
	 * @param k count including current friend
	 * @return
	 */
	public int findTheWinner(int n, int k) {
		Node firstNode = new Node(1);
		Node prevNode = firstNode;

		for (int i = 2; i <= n; i++) {
			Node currentNode = new Node(i);
			currentNode.prev = prevNode;
			prevNode.next = currentNode;
			prevNode = currentNode;
		}

		firstNode.prev = prevNode;
		prevNode.next = firstNode;

		Node currentNode = prevNode;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < k; j++) {
				currentNode = currentNode.next;
			}
			currentNode.kill();
		}

		return currentNode.next.num;
	}

	/**
	 * This is a driver main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int n = 5;
		int k = 2;

		WinnerCircularGameLC2Nodes w = new WinnerCircularGameLC2Nodes();
		System.out.println(w.findTheWinner(n, k));
	}
}
