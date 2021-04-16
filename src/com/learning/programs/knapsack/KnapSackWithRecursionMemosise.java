package com.learning.programs.knapsack;

/**
 * Same recursion program with memoization
 * 
 * in this we optimize with a mattrix which will store repeated recursive call.
 * @author kumars
 *
 */
public class KnapSackWithRecursionMemosise {

	public static void main(String[] args) {
		int[] weights = { 2, 4, 5, 6 };
		int[] value = { 5, 6, 7, 8 };
		int capacity = 10;
		int DEFAULT_MEMOISE_VAL = -1;
		int length = weights.length;
		int[][] memoisedMatrix = new int[length+2][capacity+2];
		intializeMemoisation(memoisedMatrix, DEFAULT_MEMOISE_VAL);
		int maximumWeight = getKnapsackMaximumWeight(weights, value, capacity, length, memoisedMatrix);

		System.out.println("The result is : " + maximumWeight);

	}

	/**
	 * Fill this memoisedMatrix with default value
	 * 
	 * @param memoisedMatrix
	 * @param dEFAULT_MEMOISE_VAL
	 */
	private static void intializeMemoisation(int[][] memoisedMatrix, int dEFAULT_MEMOISE_VAL) {
		for (int i = 0; i < memoisedMatrix.length; i++) {
			for (int j = 0; j < memoisedMatrix[i].length; j++) {
				memoisedMatrix[i][j] = dEFAULT_MEMOISE_VAL;
			}
		}
		printMatrix(memoisedMatrix);
	}

	private static void printMatrix(int[][] memoisedMatrix) {
		for (int i = 0; i <memoisedMatrix.length; i++) {
			for (int j = 0; j < memoisedMatrix[i].length; j++) {
				System.out.print(memoisedMatrix[i][j]);
			}
			System.out.println();
		}
	}

	private static int getKnapsackMaximumWeight(int[] weights, int[] value, int capacity, int length,
			int[][] memoisedMatrix) {

		if (capacity == 0 || length == 0) {
			printMatrix(memoisedMatrix);
			return 0;
		}

		if (memoisedMatrix[length][capacity] != -1) {
			return memoisedMatrix[length][capacity];
		}
		if (weights[length - 1] <= capacity) {
			return memoisedMatrix[length][capacity] = Math.max(
					(value[length - 1] + getKnapsackMaximumWeight(weights, value, capacity - weights[length - 1],
							length - 1, memoisedMatrix)),
					getKnapsackMaximumWeight(weights, value, capacity, length - 1, memoisedMatrix));
		} else {
			return memoisedMatrix[length][capacity] = getKnapsackMaximumWeight(weights, value, capacity, length - 1,
					memoisedMatrix);
		}

	}

}
