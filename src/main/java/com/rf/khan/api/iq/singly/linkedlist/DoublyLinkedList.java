package com.rf.khan.api.iq.singly.linkedlist;

public class DoublyLinkedList {

	class Node {

		public int data;
		public Node previousNode;
		public Node nextNode;

		public Node(int data) {
			this.data = data;
			this.previousNode = null;
			this.nextNode = null;
		}

	}

	private Node headNode;
	private Node tailNode;

	private void insertAtPosition(int data, int position, DoublyLinkedList d) {
		if (position == 1) {
			d.insertAtHead(data);
			return;
		}
		Node currentNode = headNode;
		int index = 1;
		while (index < position - 1) {
			currentNode = currentNode.nextNode;
			index++;
		}
		// at last position
		if (currentNode.nextNode == null) {
			d.insertAtTail(data);
			return;
		}

		Node nodeToBeInserted = new Node(data);
		nodeToBeInserted.nextNode = currentNode.nextNode;
		currentNode.nextNode.previousNode = nodeToBeInserted;
		currentNode.nextNode = nodeToBeInserted;
		nodeToBeInserted.previousNode = currentNode;

		currentNode = null;
	}

	private void insertAtHead(int data) {
		// create a new Node
		Node newNode = new Node(data);
		// if the list is empty and to be insert as a 1st node
		if (headNode == null && tailNode == null) {
			headNode = newNode;
			tailNode = newNode;
		} else {
			newNode.nextNode = headNode;
			headNode.previousNode = newNode;
			headNode = newNode;
		}
	}

	private void deleteNode(int position) {
		Node currentNode = headNode;
		if (position == 1) {
			currentNode.nextNode.previousNode = null;
			headNode = currentNode.nextNode;
			currentNode.nextNode = null;
			// for GC
			currentNode = null;
			return;
		}

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

		currentNode.previousNode = null;
		previousNode.nextNode = currentNode.nextNode;
		currentNode.nextNode = null;

	}

	private void insertAtTail(int data) {
		// create a new Node
		Node newNode = new Node(data);
		// if the list is empty and to be insert as a 1st node
		if (headNode == null && tailNode == null) {
			headNode = newNode;
			tailNode = newNode;
		} else {
			newNode.previousNode = tailNode;
			tailNode.previousNode = newNode;
			tailNode.nextNode = newNode;
			tailNode = newNode;
		}
	}

	/**
	 * This method is created to print the doubly linked list
	 */
	public void print() {
		Node currentNode = headNode;
		if (currentNode == null) {
			System.out.println("List is empty");
		}

		while (currentNode != null) {
			System.out.print(currentNode.data + " ");
			currentNode = currentNode.nextNode;
		}
		System.out.println();
		currentNode = null;
	}

	/**
	 * This method is created to get the length of the list
	 * 
	 * @return
	 */
	public int getLength() {
		int length = 1;
		if (headNode == null) {
			return 0;
		}
		if (headNode != null) {
			Node currentNode = headNode;
			while (currentNode.nextNode != null) {
				length++;
				currentNode = currentNode.nextNode;
			}
			// taken by GC
			currentNode = null;
		}
		return length;
	}

	public static void main(String[] args) {
		DoublyLinkedList d = new DoublyLinkedList();
		d.insertAtHead(20);
		d.insertAtHead(22);
		d.print();
		d.insertAtHead(13);
		d.print();
		d.insertAtHead(12);
		d.print();
		d.insertAtTail(100);
		d.print();
		d.insertAtTail(200);
		d.print();

		d.insertAtPosition(144, 1, d);
		d.print();
		d.insertAtPosition(25, 3, d);
		d.print();
		d.insertAtPosition(600, 7, d);
		d.print();
		d.insertAtPosition(140, 1, d);
		d.print();

		d.deleteNode(1);
		d.print();
		d.deleteNode(3);
		d.print();
		d.deleteNode(8);
		d.print();
		d.deleteNode(6);
		d.print();

		System.out.println();
		System.out.println("Length is: " + d.getLength());
		System.out.println("Head data : " + d.headNode.data);
		System.out.println("Tail data : " + d.tailNode.data);
		System.out.println("Tail nextNode : " + d.tailNode.nextNode);

	}

}
