package com.rf.khan.api.iq.singly.linkedlist;

public class SinglyLinkedList {

	class Node {
		int data;
		Node nextNode;

		Node(int data) {
			this.data = data;
			nextNode = null;
		}

	}

	private Node headNode;
	private Node tailNode;

	public void addNewNode(int data) {
		// create a new Node
		Node newNode = new Node(data);
		newNode.nextNode = headNode;
		headNode = newNode;
	}

	public void add(int data) {
		// create a new node
		Node newNode = new Node(data);

		// check if the list is empty
		if (headNode == null && tailNode == null) {
			headNode = newNode;
			tailNode = newNode;
		} else {
			tailNode.nextNode = newNode;
			tailNode = newNode;

			// newNode.nextNode = headNode;
			// headNode = newNode;
		}
	}

	public void reverseLL() {

		Node curr = headNode;
		Node prev = null;
		Node next = null;

		while (curr != null) {
			next = curr.nextNode;
			curr.nextNode = prev;
			prev = curr;
			curr = next;
		}

	}

	/**
	 * This method is created to insert the node at a position
	 * 
	 * @param data     holds the information of the data
	 * @param position holds the information of the position
	 * @param s1
	 */
	public void insertAtPosition(int data, int position, SinglyLinkedList s1) {
		// insert at start
		if (position == 1) {
			s1.addNewNode(data);
			return;
		}

		Node temp = headNode;
		int cnt = 1;
		// get the node after which we need to insert new node
		while (cnt < position - 1) {
			temp = temp.nextNode;
			cnt++;
		}

		// at last position : na likhun tab bhi chalega, but to update tail
		if (temp.nextNode == null) {
			add(data);
			return;
		}

		// creating a node for data
		Node nodeToBeInserted = new Node(data);
		// node is pointed to the next node pointing to the temp
		nodeToBeInserted.nextNode = temp.nextNode;

		// pointing the temp node to new node
		temp.nextNode = nodeToBeInserted;

	}

	public void deleteNodeAtPosition(int position) {
		// delete 1st node
		if (position == 1) {
			headNode = headNode.nextNode;
		} else {
			Node currentNode = headNode;
			Node previousNode = null;

			int cnt = 1;
			while (cnt < position) {
				previousNode = currentNode;
				currentNode = currentNode.nextNode;
				cnt++;
			}
			previousNode.nextNode = currentNode.nextNode;
			// currentNode = null;

			// to update tail
			if (currentNode.nextNode == null) {
				tailNode = previousNode;
			}

		}
	}

	/**
	 * This method is created to traverse the linked list
	 */
	public void print() {
		// Current node
		Node currentNode = headNode;
		if (currentNode == null) {
			System.out.println("List is empty..");
			return;
		}

		while (currentNode != null) {
			System.out.print(currentNode.data + " ");
			currentNode = currentNode.nextNode;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		SinglyLinkedList s1 = new SinglyLinkedList();
		s1.add(1);
		s1.add(2);
		s1.add(3);
		s1.add(4);
		// first node
		// s1.addNewNode(6);
		s1.print();
		s1.insertAtPosition(100, 1, s1);
		s1.print();
		s1.insertAtPosition(70, 6, s1);
		s1.print();
		s1.insertAtPosition(90, 7, s1);
		s1.print();

		s1.deleteNodeAtPosition(3);
		s1.print();
		s1.deleteNodeAtPosition(6);
		s1.print();
		s1.deleteNodeAtPosition(5);
		s1.print();
		s1.reverseLL();
		s1.print();

		System.out.println("------------------------------------------");
		System.out.println("Head data : " + s1.headNode.data);
		System.out.println("Tail data : " + s1.tailNode.data);
		System.out.println("Tail node : " + s1.tailNode.nextNode);
	}

}
