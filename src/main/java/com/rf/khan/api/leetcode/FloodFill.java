package com.rf.khan.api.leetcode;

public class FloodFill {

	/**
	 * This is a main driver method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
//		int[][] image = { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } };
//		int srcX = 1;
//		int srcY = 1;
//		int color = 2;

		int[][] image = { { 0, 0, 0 }, { 0, 0, 0 } };
		int srcX = 1;
		int srcY = 0;
		int color = 2;

		FloodFill f = new FloodFill();
		f.flood(image, srcX, srcY, color);

		for (int i = 0; i < image.length; i++) {
			for (int j = 0; j < image[0].length; j++) {
				System.out.print(image[i][j] + " ");
			}
			System.out.println();
		}
	}

	/**
	 * 
	 * @param image holds the information of the image
	 * @param srcX  holds the information of the source x coordinate
	 * @param srcY  holds the information of the source y coordinate
	 * @param color holds the information of the new color
	 */
	private void flood(int[][] image, int srcX, int srcY, int color) {
		int oldColor = image[srcX][srcY];
		image[srcX][srcY] = color;

		// down
		if (srcX < image.length - 1 && oldColor == image[srcX + 1][srcY]) {
			flood(image, srcX + 1, srcY, color);
		}

		// up
		if (srcX > 0 && oldColor == image[srcX - 1][srcY]) {
			flood(image, srcX - 1, srcY, color);
		}

		// left
		if (srcY > 0 && image[srcX][srcY - 1] == oldColor) {
			flood(image, srcX, srcY - 1, color);
		}

		// right
		if (srcY < image[srcX].length - 1 && image[srcX][srcY + 1] == oldColor) {
			flood(image, srcX, srcY + 1, color);
		}

	}

	/**
	 * 
	 * @param image holds the image of the image
	 * @param srcX  holds the information of the source x coordinate
	 * @param srcY  holds the information of the source y coordinate
	 * @param color holds the information of the color
	 * @return build image matrix
	 */
	public int[][] floodFill(int[][] image, int srcX, int srcY, int color) {

		// invalid cases in which we need to return same image back
		if (srcX > image.length && srcY > image[0].length)
			return image;

		// if already source coordinate have the given color, then we need not to do any
		// thing
		if (image[srcX][srcY] == color)
			return image;

		flood(image, srcX, srcY, color);

		return image;

	}

}
