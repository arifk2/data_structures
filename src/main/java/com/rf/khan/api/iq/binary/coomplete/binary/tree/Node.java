package com.rf.khan.api.iq.binary.coomplete.binary.tree;

public class Node<T> {
	T data;
	Node<T> left;
	Node<T> right;

	public Node() {
	}

	public Node(T data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}

}
