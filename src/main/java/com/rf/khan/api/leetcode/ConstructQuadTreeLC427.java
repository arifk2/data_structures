package com.rf.khan.api.leetcode;

public class ConstructQuadTreeLC427 {

	private class Node {
		public boolean val;
		public boolean isLeaf;
		public Node topLeft;
		public Node topRight;
		public Node bottomLeft;
		public Node bottomRight;

		public Node() {
			this.val = false;
			this.isLeaf = false;
			this.topLeft = null;
			this.topRight = null;
			this.bottomLeft = null;
			this.bottomRight = null;
		}

		public Node(boolean val, boolean isLeaf) {
			this.val = val;
			this.isLeaf = isLeaf;
			this.topLeft = null;
			this.topRight = null;
			this.bottomLeft = null;
			this.bottomRight = null;
		}

		public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
			this.val = val;
			this.isLeaf = isLeaf;
			this.topLeft = topLeft;
			this.topRight = topRight;
			this.bottomLeft = bottomLeft;
			this.bottomRight = bottomRight;
		}
	}

	public Node construct(int[][] grid) {
		int n = grid.length;
		return contructQuadTree(grid, 0, n - 1, 0, n - 1);
	}

	public Node contructQuadTree(int[][] grid, int rowStart, int rowEnd, int colStart, int colEnd) {
		if (rowStart > rowEnd || colStart > colEnd)
			return null;
		boolean isLeaf = true;
		int val = grid[rowStart][colStart];

		for (int i = rowStart; i <= rowEnd; i++) {
			for (int j = colStart; j <= colEnd; j++) {
				if (grid[i][j] != val) {
					isLeaf = false;
					break;
				}
			}

			if (!isLeaf) {
				break;
			}
		}

		if (isLeaf) {
			if (val == 0)
				return new Node(false, true);
			else
				return new Node(true, true);
		}

		int rowMid = (rowStart + rowEnd) / 2;
		int colMid = (colStart + colEnd) / 2;

		Node topLeft = contructQuadTree(grid, rowStart, rowMid, colStart, colMid);
		Node topRight = contructQuadTree(grid, rowStart, rowMid, colMid + 1, colEnd);
		Node bottomLeft = contructQuadTree(grid, rowMid + 1, rowEnd, colStart, colMid);
		Node bottomRight = contructQuadTree(grid, rowMid + 1, rowEnd, colMid + 1, colEnd);

		return new Node(false, false, topLeft, topRight, bottomLeft, bottomRight);
	}

}
