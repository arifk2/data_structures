package com.rf.khan.api.iq.singly.linkedlist;

//{ Driver Code Starts
import java.util.*;

class NodeL {
	int data;
	NodeL next, arb;

	NodeL(int d) {
		data = d;
		next = arb = null;
	}
}

class Cloning1 {

	public static NodeL addToTheLast(NodeL head, NodeL NodeL) {
		if (head == null) {
			head = NodeL;
			return head;
		} else {
			NodeL temp = head;
			while (temp.next != null)
				temp = temp.next;
			temp.next = NodeL;
			return head;
		}
	}

	public static boolean validation(NodeL head, NodeL res) {

		NodeL temp1 = head;
		NodeL temp2 = res;

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

		HashMap<NodeL, NodeL> a = new HashMap<NodeL, NodeL>();

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
			NodeL head = null, head2 = null;
			int n = sc.nextInt();
			int q = sc.nextInt();

			int a1 = sc.nextInt();
			head = addToTheLast(head, new NodeL(a1));
			head2 = addToTheLast(head2, new NodeL(a1));
			for (int i = 1; i < n; i++) {
				int a = sc.nextInt();
				head = addToTheLast(head, new NodeL(a));
				head2 = addToTheLast(head2, new NodeL(a));
			}

			for (int i = 0; i < q; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();

				NodeL tempA = head;
				NodeL temp2A = head2;
				int count = -1;

				while (tempA != null) {
					count++;
					if (count == a - 1)
						break;
					tempA = tempA.next;
					temp2A = temp2A.next;
				}
				NodeL tempB = head;
				NodeL temp2B = head2;
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

			Clone3Approach g = new Clone3Approach();
			NodeL res = g.copyList(head);

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
 * class NodeL { int data; NodeL next, arb;
 * 
 * NodeL(int d) { data = d; next = arb = null;
 * 
 * } }
 */

class Clone3Approach {
	// Function to clone a linked list with next and random pointer.
	NodeL copyList(NodeL head) {

		// Step1: create a copy the LL with next only;

		NodeL cloneHead = null;
		NodeL cloneTail = null;

		NodeL temp = head;

		while (temp != null) {
			NodeL newNodeL = new NodeL(temp.data);
			if (cloneHead == null) {
				cloneHead = newNodeL;
				cloneTail = newNodeL;
			} else {
				cloneTail.next = newNodeL;
				cloneTail = newNodeL;
			}
			temp = temp.next;
		}

		// Step2: add the original LL to copy LL

		NodeL originalNodeL = head;
		NodeL cloneNodeL = cloneHead;

		while (originalNodeL != null && cloneNodeL != null) {
			NodeL next = originalNodeL.next;
			originalNodeL.next = cloneNodeL;
			originalNodeL = next;

			next = cloneNodeL.next;
			cloneNodeL.next = originalNodeL;
			cloneNodeL = next;
		}

		// Step3: copy the random pointer
		temp = head;

		while (temp != null) {
			if (temp.next != null) {
				if (temp.arb != null) {
					temp.next.arb = temp.arb.next;
				} else {
					temp.next.arb = temp.arb;
				}
			}
			temp = temp.next.next;
		}

		// Step4: revert the changes done in the step2
		originalNodeL = head;
		cloneNodeL = cloneHead;

		while (originalNodeL != null && cloneNodeL != null) {
			originalNodeL.next = cloneNodeL.next;
			originalNodeL = originalNodeL.next;

			if (originalNodeL != null) {
				cloneNodeL.next = originalNodeL.next;
			}

			cloneNodeL = cloneNodeL.next;
		}

		// Step5 return the ans
		return cloneHead;

	}
}
