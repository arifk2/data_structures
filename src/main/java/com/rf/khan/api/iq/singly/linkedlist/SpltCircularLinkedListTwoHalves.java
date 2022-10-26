package com.rf.khan.api.iq.singly.linkedlist;

public class SpltCircularLinkedListTwoHalves {

	static Node head, head1, head2;

	static class Node {
		int data;
		Node prev, next;

		public Node(int data) {
			this.data = data;
			this.prev = null;
			this.next = null;
		}
	}

	void printList(Node node) {
		Node temp = node;
		if (node != null) {
			do {
				System.out.print(temp.data + " ");
				temp = temp.next;
			} while (temp != node);
		}
	}

	void splitList() {
		Node slow = head;
		Node fast = head;

		if (head == null) {
			return;

		}

		/*
		 * If there are odd nodes in the circular list then fast_ptr->next becomes head
		 * and for even nodes fast_ptr->next->next becomes head
		 */
		while (fast.next != head && fast.next.next != head) {
			fast = fast.next.next;
			slow = slow.next;
		}

		/* If there are even elements in list then move fast_ptr */
		if (fast.next.next == head) {
			fast = fast.next;
		}

		/* Set the head pointer of first half */
		head1 = head;

		/* Set the head pointer of second half */
		if (head.next != head) {
			head2 = slow.next;
		}
		/* Make second half circular */
		fast.next = slow.next;

		/* Make first half circular */
		slow.next = head;

	}

	public static void main(String[] args) {
		SpltCircularLinkedListTwoHalves list = new SpltCircularLinkedListTwoHalves();

		// Created linked list will be 12->56->2->11
		list.head = new Node(12);
		list.head.next = new Node(56);
		list.head.next.next = new Node(2);
		//list.head.next.next.next = new Node(34);
//		list.head.next.next.next.next = new Node(11);
//		list.head.next.next.next.next.next = list.head;
		list.head.next.next.next = new Node(11);
		list.head.next.next.next.next = list.head;

		System.out.println("Original Circular Linked list ");
		list.printList(head);

		// Split the list
		list.splitList();
		System.out.println("");
		System.out.println("First Circular List ");
		list.printList(head1);
		System.out.println("");
		System.out.println("Second Circular List ");
		list.printList(head2);
	}
}
