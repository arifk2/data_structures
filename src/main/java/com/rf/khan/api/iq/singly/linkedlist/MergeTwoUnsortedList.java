package com.rf.khan.api.iq.singly.linkedlist;

class LinkedListNode<T> {
	T data;
	LinkedListNode<T> next;

	public LinkedListNode(T data) {
		this.data = data;
	}
}

public class MergeTwoUnsortedList {

	public static LinkedListNode<Integer> solve(LinkedListNode<Integer> first, LinkedListNode<Integer> second) {

		// first linked list has one element
		if (first.next == null) {
			first.next = second;
			return first;
		}
		LinkedListNode<Integer> curr1 = first;
		LinkedListNode<Integer> next1 = curr1.next;

		LinkedListNode<Integer> curr2 = second;
		LinkedListNode<Integer> next2 = curr2.next;

		while (next1 != null && curr2 != null) {
			if (curr2.data >= curr1.data && curr2.data <= next1.data) {
				curr1.next = curr2;
				next2 = curr2.next;
				curr2.next = next1;

				// Increase pointers
				curr1 = curr2;
				curr2 = next2;

			} else {
				// Increase curr1 and next1 : go 1 step ahead in the linked list 
				curr1 = next1;
				next1 = next1.next;

				if (next1 == null) {
					curr1.next = curr2;
					return first;
				}
			}
		}
		return first;
	}

	public static LinkedListNode<Integer> sortTwoLists(LinkedListNode<Integer> first, LinkedListNode<Integer> second) {

		// empty case for one of the list
		if (first == null) {
			return second;
		}

		if (second == null) {
			return first;

		}

		// decide which linked list has the smaller element in the head;
		if (first.data <= second.data) {
			// first list is the first list
			return solve(first, second);
		} else {
			return solve(second, first);
		}
	}
}