package com.rf.khan.api.iq.binary.search.tree;

class Info {
	private int maxi;
	private int mini;
	private boolean isBST;
	private int size;

	public Info() {

	}

	public Info(int maxi, int mini, boolean isBST, int size) {
		this.maxi = maxi;
		this.mini = mini;
		this.isBST = isBST;
		this.size = size;
	}

	public int getMaxi() {
		return maxi;
	}

	public void setMaxi(int maxi) {
		this.maxi = maxi;
	}

	public int getMini() {
		return mini;
	}

	public void setMini(int mini) {
		this.mini = mini;
	}

	public boolean isBST() {
		return isBST;
	}

	public void setBST(boolean isBST) {
		this.isBST = isBST;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

}

public class LargestBSTSubTree {
	Node root;

	public static void main(String[] args) {
		LargestBSTSubTree tree = new LargestBSTSubTree();
		tree.root = new Node(5);
		tree.root.left = new Node(2);
		tree.root.right = new Node(4);
		tree.root.left.left = new Node(1);
		tree.root.left.right = new Node(3);

		System.out.println(tree.largestBST(tree.root));
	}

	private int largestBST(Node root) {
		Info temp = solve(root);
		return temp.getSize();
	}

	private Info solve(Node root) {
		if (root == null) {
			return new Info(Integer.MIN_VALUE, Integer.MAX_VALUE, true, 0);
		}

		Info left = solve(root.left);
		Info right = solve(root.right);

		Info currentNode = new Info();

		currentNode.setMini(Math.min(root.data, left.getMini()));
		currentNode.setMaxi(Math.max(root.data, right.getMaxi()));
		currentNode
				.setBST(left.isBST() && right.isBST() && (root.data > left.getMaxi() && root.data < right.getMini()));

		if (currentNode.isBST()) {
			currentNode.setSize(left.getSize() + right.getSize() + 1);
		} else {
			currentNode.setSize(Math.max(left.getSize(), right.getSize()));
		}
		return currentNode;
	}
}
