package com.rf.khan.api.iq.singly.linkedlist;

//{ Driver Code Starts
import java.util.*;

class NodeN {
	int data;
	NodeN next, arb;

	NodeN(int d) {
		data = d;
		next = arb = null;
	}
}

class Cloning {

	public static NodeN addToTheLast(NodeN head, NodeN NodeN) {
		if (head == null) {
			head = NodeN;
			return head;
		} else {
			NodeN temp = head;
			while (temp.next != null)
				temp = temp.next;
			temp.next = NodeN;
			return head;
		}
	}

	public static boolean validation(NodeN head, NodeN res) {

		NodeN temp1 = head;
		NodeN temp2 = res;

		int len1 = 0, len2 = 0;
		while (temp1 != null) {
			len1++;
			temp1 = temp1.next;
		}
		while (temp2 != null) {
			len2++;
			temp2 = temp2.next;
		}

		/* if lengths not equal */

		if (len1 != len2)
			return false;

		HashMap<NodeN, NodeN> a = new HashMap<NodeN, NodeN>();

		temp1 = head;
		temp2 = res;
		while (temp1 != null) {

			if (temp1 == temp2)
				return false;

			if (temp1.data != temp2.data)
				return false;

			if (temp1.arb != null && temp2.arb != null) {
				if (temp1.arb.data != temp2.arb.data)
					return false;
			} else if (temp1.arb != null && temp2.arb == null)
				return false;
			else if (temp1.arb == null && temp2.arb != null)
				return false;
			if (!a.containsKey(temp1)) {
				a.put(temp1, temp2);
			}

			temp1 = temp1.next;
			temp2 = temp2.next;

		}

		if (a.size() != len1)
			return false;

		temp1 = head;
		temp2 = res;
		while (temp1 != null) {

			if (temp1.arb != null && temp2.arb != null) {
				if (a.get(temp1.arb) != temp2.arb)
					return false;
			}
			temp1 = temp1.next;
			temp2 = temp2.next;
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		while (t-- > 0) {
			NodeN head = null, head2 = null;
			int n = sc.nextInt();
			int q = sc.nextInt();

			int a1 = sc.nextInt();
			head = addToTheLast(head, new NodeN(a1));
			head2 = addToTheLast(head2, new NodeN(a1));
			for (int i = 1; i < n; i++) {
				int a = sc.nextInt();
				head = addToTheLast(head, new NodeN(a));
				head2 = addToTheLast(head2, new NodeN(a));
			}

			for (int i = 0; i < q; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();

				NodeN tempA = head;
				NodeN temp2A = head2;
				int count = -1;

				while (tempA != null) {
					count++;
					if (count == a - 1)
						break;
					tempA = tempA.next;
					temp2A = temp2A.next;
				}
				NodeN tempB = head;
				NodeN temp2B = head2;
				count = -1;

				while (tempB != null) {
					count++;
					if (count == b - 1)
						break;
					tempB = tempB.next;
					temp2B = temp2B.next;
				}

				// when both a is greater than N
				if (a <= n) {
					tempA.arb = tempB;
					temp2A.arb = temp2B;
				}
			}

			CloneLLWithRandomPointerMapApproach g = new CloneLLWithRandomPointerMapApproach();
			NodeN res = g.copyList(head);

			if (validation(head, res) == true && validation(head2, res))
				System.out.println("1");
			else
				System.out.println("0");
		}
	}
}
// } Driver Code Ends

/*
 * Please note that it's Function problem i.e. you need to write your solution
 * in the form of Function(s) only. Driver Code to call/invoke your function is
 * mentioned above.
 */

/*
 * class NodeN { int data; NodeN next, arb;
 * 
 * NodeN(int d) { data = d; next = arb = null;
 * 
 * } }
 */

class CloneLLWithRandomPointerMapApproach {

	public void insertAtTail(NodeN head, NodeN tail, int data) {
		// create a new NodeN and attach with it
		NodeN newNodeN = new NodeN(data);
		if (head == null && tail == null) {
			head = newNodeN;
			tail = newNodeN;
			return;
		} else {
			tail.next = newNodeN;
			tail = newNodeN;
		}
	}

	// Function to clone a linked list with next and random pointer.
	NodeN copyList(NodeN head) {
		// your code here

		NodeN cloneHead = null;
		NodeN cloneTail = null;

		NodeN temp = head;

		// Step 1: clone NodeN with next pointer
		while (temp != null) {
			// insertAtTail(cloneHead, cloneTail, temp.data);
			// create a new NodeN and attach with it
			NodeN newNodeN = new NodeN(temp.data);

			if (cloneHead == null && cloneTail == null) {
				cloneHead = newNodeN;
				cloneTail = newNodeN;
			} else {
				cloneTail.next = newNodeN;
				cloneTail = newNodeN;
			}
			temp = temp.next;
		}

		NodeN originalNodeN = head;
		NodeN cloneNodeN = cloneHead;

		// create a map to store the original random NodeN
		HashMap<NodeN, NodeN> oldToNew = new HashMap<NodeN, NodeN>();

		while (originalNodeN != null && cloneNodeN != null) {
			oldToNew.put(originalNodeN, cloneNodeN);

			// increment the pointer
			originalNodeN = originalNodeN.next;
			cloneNodeN = cloneNodeN.next;
		}
		originalNodeN = head;
		cloneNodeN = cloneHead;

		while (originalNodeN != null) {
			cloneNodeN.arb = oldToNew.get(originalNodeN.arb);
			originalNodeN = originalNodeN.next;
			cloneNodeN = cloneNodeN.next;
		}

		return cloneHead;
	}
}
