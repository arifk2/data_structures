package com.rf.khan.api.iq.binary.search.tree;

class CostructBSTfromPreOrder {
	int i = 0;

	/**************************************
	 * *********************************
	 * Range concept 
	 * 
	 * (min, root.data) at left
	 * (root.data, max) at right 
	 * 
	 * @param preOrder
	 * @param mini
	 * @param maxi
	 * @return
	 */
	private Node cBST(int[] preOrder, int mini, int maxi) {
		if (i >= preOrder.length)
			return null;

		if (preOrder[i] < mini || preOrder[i] > maxi)
			return null;

		Node root = new Node(preOrder[i++]);

		root.left = cBST(preOrder, mini, root.data);
		root.right = cBST(preOrder, root.data, maxi);

		return root;
	}

	public Node bstFromPreorder(int[] preorder) {
		int mini = Integer.MIN_VALUE;
		int maxi = Integer.MAX_VALUE;

		return cBST(preorder, mini, maxi);
	}
}