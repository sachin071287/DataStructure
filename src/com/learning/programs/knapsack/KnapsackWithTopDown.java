package com.learning.programs.knapsack;

import com.sun.glass.ui.View.Capability;

/**
 * In this problem, after the memoisation in top down we try to use only this matrix for storing the result 
 * and also we try to remove the recursive call and convert those into iterative call.
 * 
 * @author kumars
 *
 */
public class KnapsackWithTopDown {

	public static void main(String[] args) {

		int[] weights = { 2, 4, 5, 6 };
		int[] value = { 5, 6, 7, 8 };
		int capacity = 10;
		
		int length = weights.length;
		int[][] matrix = new int [length+1][capacity+1];
		//initialize the matrix withc is equivalent to base condition of recursion.
		initializeMatrix(matrix);
		System.out.println("Maximum weight is : " + getMaxWeightByTopDown(weights,capacity,value, matrix));
	}

	private static int getMaxWeightByTopDown(int[] weights, int capacity, int[] value, int[][] matrix) {
		for (int i = 1; i < weights.length +1; i++) {
			for (int j = 1; j < capacity +1; j++) {
				if (weights[i-1] <= j) {
					matrix[i][j] = Math.max(value[i-1] + matrix[i - 1][j - weights[i-1]], matrix[i - 1][j]);
				} else {
					matrix[i][j] = matrix[i - 1][j];
				}
			}

		}
		int[] lastrow = matrix[matrix.length - 1];
		int lastElement = lastrow[lastrow.length - 1];
		printMatrix(matrix);
		return lastElement;
	}

	/**
	 * @param matrix
	 */
	private static void initializeMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (i == 0 || j == 0) {
					matrix[i][j] = 0;
				}
			}
		}

		printMatrix(matrix);
	}
	
	private static void printMatrix(int[][] memoisedMatrix) {
		for (int i = 0; i <memoisedMatrix.length; i++) {
			for (int j = 0; j < memoisedMatrix[i].length; j++) {
				System.out.print(memoisedMatrix[i][j]);
			}
			System.out.println();
		}
	}

}
