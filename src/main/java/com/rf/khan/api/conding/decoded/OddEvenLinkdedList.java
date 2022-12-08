package com.rf.khan.api.conding.decoded;

import java.util.List;

public class OddEvenLinkdedList {

	static class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
			this.next = null;
		}
	}

	ListNode head;

	public ListNode oddEvenList(ListNode head) {

		if (head == null || head.next == null || head.next.next == null)
			return head;

		ListNode oddIt = head;
		ListNode evenIt = head.next;
		ListNode evenHead = evenIt;

		while (oddIt.next != null && evenIt.next != null) {
			oddIt.next = evenIt.next;
			oddIt = oddIt.next;

			if (oddIt != null) {
				evenIt.next = oddIt.next;
				evenIt = evenIt.next;
			}
		}

		oddIt.next = evenHead;

		return head;
	}

	public static void main(String[] args) {
		OddEvenLinkdedList o = new OddEvenLinkdedList();
		o.head = new ListNode(1);
		o.head.next = new ListNode(2);
		o.head.next.next = new ListNode(3);
		o.head.next.next.next = new ListNode(4);
		o.head.next.next.next.next = new ListNode(5);

		o.oddEvenList(o.head);
		o.print(o.head);

	}

	void print(ListNode head) {
		ListNode temp = head;

		while (temp != null) {
			System.out.print(temp.val + " ");
			temp = temp.next;
		}
	}

}
