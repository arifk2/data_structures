package com.rf.khan.api.iq.singly.linkedlist;

/****************************************************************
 * 
 * Following is the class structure of the Node class:
 * 
 * class Node { int data; Node next; Node child;
 * 
 * public Node(int data) { this.data = data; this.next = null; this.child =
 * null; } }
 * 
 *****************************************************************/
public class FlattenLinkedList {

	class Node {
		int data;
		Node next;
		Node child;

		public Node(int data) {
			this.data = data;
			this.next = null;
			this.child = null;
		}
	}

	static Node merge(Node first, Node second) {
		// if first linked list is empty then second
		// is the answer
		if (first == null)
			return second;

		// if second linked list is empty then first
		// is the result
		if (second == null)
			return first;

		// compare the data members of the two linked lists
		// and put the larger one in the result
		Node result;

		if (first.data < second.data) {
			result = first;
			result.child = merge(first.child, second);
		}

		else {
			result = second;
			result.child = merge(first, second.child);
		}

		result.next = null;
		return result;
	}

	public static Node flattenLinkedList(Node start) {
		// base case
		if (start == null || start.next == null) {
			return start;
		}

		// rest part
		start.next = flattenLinkedList(start.next);

		// merge
		start = merge(start, start.next);

		return start;
	}
}
