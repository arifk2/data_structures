package com.rf.khan.api.iq.singly.linkedlist;

/**
 * This is a class where we will merge two sorted linked list
 * 
 * @author mkhan339
 *
 */
public class MergeTwoSortedLL {

	static class Node<T> {
		T data;
		Node<T> next;

		public Node(T data) {
			this.data = data;
			this.next = null;
		}

	}

	Node<Integer> head1;
	Node<Integer> head2;

	/**
	 * This method is created to merge two sorted linked list
	 * 
	 * @param first  holds the information of the first LL head
	 * @param second holds the information of the second LL head
	 * @return resultant LL head
	 */
	public static Node<Integer> sortTwoLists(Node<Integer> first, Node<Integer> second) {
		// Step 1: To handle if the first or second LL is null
		if (first == null)
			return second;
		if (second == null)
			return first;

		// now to determine which linked list is smaller, as the LL is in sorted, so we
		// compare first node data to get the smaller and higher lined list

		// as we want to consider smaller LL as the first and other is second
		if (first.data > second.data) {
			return merge(second, first);
		} else {
			return merge(first, second);
		}

	}

	/**
	 * This method is created to the actual logic of the merge two LL
	 * 
	 * @param first  holds the information of the first node
	 * @param second holds the information of the second node
	 * @return resultant node head;
	 */
	private static Node<Integer> merge(Node<Integer> first, Node<Integer> second) {

		if (first.next == null) {
			first.next = second;
			return first;
		}

		Node<Integer> current1 = first;
		Node<Integer> next1 = first.next;

		Node<Integer> current2 = second;
		Node<Integer> next2 = second.next;

		while (next1 != null && current2 != null) {
			if (current2.data >= current1.data && current2.data <= next1.data) {
				// node addition
				current1.next = current2;
				next2 = current2.next;
				current2.next = next1;

				// update pointers
				current1 = current2;
				current2 = next2;
			} else {

				// move pointers
				current1 = next1;
				next1 = next1.next;
				if (next1 == null) {
					current1.next = current2;
					return first;
				}
			}
		}
		return first;
	}

	/**
	 * This method is created to print the linked list
	 * 
	 * @param head holds the information of the head node
	 */
	public static void printLL(Node<Integer> head) {
		Node<Integer> temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}

	/**
	 * This is a driver main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		MergeTwoSortedLL s = new MergeTwoSortedLL();
		s.head1 = new Node<Integer>(1);
		// s.head1.next = null;
		s.head1.next = new Node<Integer>(2);
		s.head1.next.next = new Node<Integer>(4);
		s.head1.next.next.next = new Node<Integer>(5);
		s.head1.next.next.next.next = null;

		s.head2 = new Node<Integer>(3);
		s.head2.next = new Node<Integer>(5);
		s.head2.next.next = new Node<Integer>(6);
		s.head2.next.next.next = null;

		printLL(s.head1);
		printLL(s.head2);

		printLL(sortTwoLists(s.head1, s.head2));
	}
}
