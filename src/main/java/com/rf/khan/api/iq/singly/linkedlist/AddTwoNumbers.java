package com.rf.khan.api.iq.singly.linkedlist;
//{ Driver Code Starts

// driver

import java.util.*;

class AddTwoNumbers {

	static void printList(Node1 n) {
		while (n != null) {
			System.out.print(n.data + " ");
			n = n.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		while (T-- > 0) {

			int n = sc.nextInt();
			int val = sc.nextInt();

			Node1 first = new Node1(val);
			Node1 tail = first;
			for (int i = 0; i < n - 1; i++) {
				val = sc.nextInt();
				tail.next = new Node1(val);
				tail = tail.next;
			}

			int m = sc.nextInt();
			val = sc.nextInt();

			Node1 second = new Node1(val);
			tail = second;
			for (int i = 0; i < m - 1; i++) {
				val = sc.nextInt();
				tail.next = new Node1(val);
				tail = tail.next;
			}

			Solution1 g = new Solution1();
			Node1 res = g.addTwoLists(first, second);
			printList(res);
		}
	}
}

// } Driver Code Ends

/*
 * Node1 for linked list
 * 
 * class Node1 { int data; Node1 next;
 * 
 * Node1(int d) { data = d; next = null; } }
 * 
 */

class Node1 {
	int data;
	Node1 next;

	Node1(int d) {
		data = d;
		next = null;
	}
}

class Solution1 {

	public static void insertAtTail(Node1 head, Node1 tail, int data) {

		Node1 temp = new Node1(data);

		// empty list
		if (head == null) {
			head = temp;
			tail = temp;
			return;
		} else {
			tail.next = temp;
			tail = temp;
		}
	}

	/**
	 * Optimized while loop all condition handled
	 * 
	 * @param first
	 * @param second
	 * @return
	 */
	public static Node1 addOptimized(Node1 first, Node1 second) {

		int carry = 0;
		Node1 ansHead = null;
		Node1 ansTail = null;

		while (first != null || second != null || carry != 0) {

			int val1 = 0;
			if (first != null) {
				val1 = first.data;
			}

			int val2 = 0;
			if (second != null) {
				val2 = second.data;
			}

			int sum = carry + val1 + val2;

			int digit = sum % 10;

			// create node and add in ans LL
			// insertAtTail(ansHead, ansTail, digit);

			Node1 newNode = new Node1(digit);
			// check if the list is empty
			if (ansHead == null && ansTail == null) {
				ansHead = newNode;
				ansTail = newNode;
			} else {
				ansTail.next = newNode;
				ansTail = newNode;
			}

			carry = sum / 10;

			// increase the pointer
			if (first != null)
				first = first.next;
			if (second != null)
				second = second.next;

		}

		return ansHead;

	}

	public static Node1 add(Node1 first, Node1 second) {

		int carry = 0;
		Node1 ansHead = null;
		Node1 ansTail = null;

		while (first != null && second != null) {
			int sum = carry + first.data + second.data;

			int digit = sum % 10;
			Node1 temp = new Node1(digit);
			// create Node1 and add in ans LL
			if (ansHead == null) {
				ansHead = temp;
				ansTail = temp;
				// return;
			} else {
				ansTail.next = temp;
				ansTail = temp;
			}

			carry = sum / 10;

			// increase the pointer
			first = first.next;
			second = second.next;
		}

		while (first != null) {
			int sum = carry + first.data;

			int digit = sum % 10;

			// create Node1 and add in ans LL
			Node1 temp = new Node1(digit);
			// create Node1 and add in ans LL
			if (ansHead == null) {
				ansHead = temp;
				ansTail = temp;
				// return;
			} else {
				ansTail.next = temp;
				ansTail = temp;
			}

			carry = sum / 10;

			// increase the pointer
			first = first.next;
		}

		while (second != null) {
			int sum = carry + second.data;

			int digit = sum % 10;

			// create Node1 and add in ans LL
			Node1 temp = new Node1(digit);
			// create Node1 and add in ans LL
			if (ansHead == null) {
				ansHead = temp;
				ansTail = temp;
				// return;
			} else {
				ansTail.next = temp;
				ansTail = temp;
			}

			carry = sum / 10;

			// increase the pointer
			second = second.next;
		}

		// carry left

		while (carry != 0) {
			int sum = carry;
			int digit = sum % 10;

			// create Node1 and add in ans LL
			Node1 temp = new Node1(digit);
			// create Node1 and add in ans LL
			if (ansHead == null) {
				ansHead = temp;
				ansTail = temp;
				// return;
			} else {
				ansTail.next = temp;
				ansTail = temp;
			}

			// carry = sum /10;
		}

		return ansHead;

	}

	public static Node1 reverseList(Node1 head) {

		Node1 curr = head;
		Node1 prev = null;
		Node1 next = null;

		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}

	// Function to add two numbers represented by linked list.
	static Node1 addTwoLists(Node1 first, Node1 second) {

		// Step 1: Reverse both the linked list
		first = reverseList(first);
		second = reverseList(second);

		// step2: add two LL
		Node1 ans = add(first, second);
		// System.out.println(ans);

		// step3: reverse LL
		ans = reverseList(ans);

		return ans;

	}
}
