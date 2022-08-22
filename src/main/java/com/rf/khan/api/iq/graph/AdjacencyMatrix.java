package com.rf.khan.api.iq.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is to create a Adjacency Matrix
 * 
 * @author mkhan339
 *
 */
public class AdjacencyMatrix {

	class Pair {
		int first;
		int second;

		public Pair(int first, int second) {
			this.first = first;
			this.second = second;
		}

		public Pair() {
		}
	}

	/**
	 * This method is created to create a Adjacency Matrix
	 */
	public void createAdjacencyMatrix() {
		int node = 3;
		int totalEdge = 3;

		Pair edge1 = new Pair(0, 1);
		Pair edge2 = new Pair(1, 2);
		Pair edge3 = new Pair(2, 0);

		List<Pair> edgeList = new ArrayList<>(totalEdge);
		edgeList.add(edge1);
		edgeList.add(edge2);
		edgeList.add(edge3);

		int[][] aMatrix = new int[node][node];
		for (int i = 0; i < node; i++) {
			for (int j = 0; j < node; j++) {
				aMatrix[edgeList.get(i).first][edgeList.get(i).second] = 1;
			}
		}

		printArray(aMatrix);
	}

	/**
	 * This method is created to print the array
	 * 
	 * @param aMatrix
	 */
	private void printArray(int[][] aMatrix) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(aMatrix[i][j] + " ");
			}
			System.out.println();
		}

	}

	/**
	 * This is a driver method or called as main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		AdjacencyMatrix a = new AdjacencyMatrix();
		a.createAdjacencyMatrix();
	}
}
