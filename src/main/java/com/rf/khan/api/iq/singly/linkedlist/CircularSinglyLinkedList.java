package com.rf.khan.api.iq.singly.linkedlist;

import java.util.HashMap;
import java.util.TreeMap;

public class CircularSinglyLinkedList {

	class Node {

		int data;
		Node nextNode;

		public Node(int data) {
			this.data = data;
			nextNode = null;
		}
	}

	private Node tailNode;

	public void insertNode(int data, int element) {

		// if the list is empty
		if (tailNode == null) {
			Node newNode = new Node(data);
			newNode.nextNode = newNode;
			tailNode = newNode;
		} else {
			// non empty
			// assuming the element is present in the list

			Node currentNode = tailNode;

			while (currentNode.data != element) {
				currentNode = currentNode.nextNode;
			}

			// element found and pointing to the current node
			Node newNode = new Node(data);

			newNode.nextNode = currentNode.nextNode;
			currentNode.nextNode = newNode;

			// update tail
			newNode = tailNode;
			// tailNode = newNode;
		}
	}

	public void print() {
		Node currentNode = tailNode;
		if (currentNode == null) {
			System.out.println("List is empty");
			return;
		}
		do {
			System.out.print(currentNode.data + " ");
			currentNode = currentNode.nextNode;

		} while (tailNode != currentNode);
		System.out.println();
	}

	/**
	 * Check whether list is circular or not
	 * 
	 * @return
	 */
	public boolean isCircular() {

		// empty list
		if (tailNode == null) {
			return true;
		}
		Node temp = tailNode.nextNode;

		while (temp != null && temp != tailNode) {
			temp = temp.nextNode;
		}

		if (temp == tailNode) {
			return true;
		}

		return false;
	}

	public void deleteByValue(int value) {
		// empty list
		if (tailNode == null) {
			System.out.println("List is empty");
			return;
		} else {
			// non-empty
			// assuming value is present in the list
			Node previousNode = tailNode;
			Node currentNode = previousNode.nextNode;

			// checking for the data
			while (currentNode.data != value) {
				previousNode = currentNode;
				currentNode = currentNode.nextNode;
			}
			previousNode.nextNode = currentNode.nextNode;
			currentNode.nextNode = null;

			// 1 node linked list
			if (currentNode == previousNode) {
				tailNode = null;
			}

			// update tail
			if (tailNode == currentNode) {
				tailNode = previousNode.nextNode;
			}
			// gc
			currentNode = null;
		}
	}

	public boolean detectLoop() {
		if (tailNode == null) {
			return false;
		}

		HashMap<Node, Boolean> visited = new HashMap<>();

		Node temp = tailNode;
		while (temp != null) {

			if (visited.get(temp) != null && visited.get(temp)) {
				return true;
			}
			visited.put(temp, true);
			temp = temp.nextNode;
		}
		return false;
	}

	/**
	 * This method is created to get the intersection and check whether the loop is
	 * circular or not
	 * 
	 * @return return the point of intersection
	 */
	public Node detectByFlyod() {
		if (tailNode == null) {
			return null;
		}

		// increment fast by two and slow by slow by 1
		Node fast = tailNode;
		Node slow = tailNode;

		while (fast != null && slow != null) {
			fast = fast.nextNode;
			if (fast.nextNode != null) {
				fast = fast.nextNode;
			}

			slow = slow.nextNode;
		}

		if (slow == fast) {
			return slow;
		}

		return null;
	}

	/**
	 * This method is created to get the start node of the loop
	 * 
	 * @param c hold the class object
	 * @return the start nod eof the loop
	 */
	public Node startLoopNode() {
		CircularSinglyLinkedList c = new CircularSinglyLinkedList();
		Node pointOfInterSection = c.detectByFlyod();
		Node slowPointer = tailNode;

		while (slowPointer != pointOfInterSection) {
			// increment next by one to both
			slowPointer = slowPointer.nextNode;
			pointOfInterSection = pointOfInterSection.nextNode;
		}

		// place when slow pointer and intersection pointer are point to the start node
		// of the loop
		return slowPointer;

	}

	/**
	 * This method is created to remove the loop node and point to null
	 */
	public void removeLoop() {
		if (tailNode == null)
			return;

		/*
		 * // if tail itself is pointing to himself if (tailNode.nextNode == tailNode) {
		 * tailNode.nextNode = null; }
		 */

		// get the starting node;
		Node startingNode = startLoopNode();
		Node temp = startingNode;

		// checking in circular
		while (temp.nextNode != startingNode) {
			temp = temp.nextNode;
		}

		temp.nextNode = null;
	}

	public static void main(String[] args) {
		CircularSinglyLinkedList c = new CircularSinglyLinkedList();

		c.insertNode(3, 5);
		c.print();

		c.insertNode(4, 3);
		c.print();

		c.insertNode(5, 3);
		c.print();
		c.insertNode(10, 4);
		c.print();
		c.insertNode(8, 3);
		c.print();
		/*
		 * c.deleteByValue(3); c.print(); c.deleteByValue(4); c.print();
		 */
		/*
		 * c.deleteByValue(4); c.print();
		 */
		System.out.println(c.tailNode.data);
		System.out.println(c.isCircular());
		System.out.println(c.detectLoop());

		/*
		 * Node startNode = c.startLoopNode(); System.out.println("Start Node is: " +
		 * startNode.data);
		 */
	}
}
