package com.learning.programs.knapsack;

/**
 * 
 * Types of Knapsack :
 * -- Factorial Knapsack
 * -- 0-1 KnapSack
 * -- Unbounded knapsack
 * 
 * 0/1 knapsack problem is an DP problem where it can be solved using recursion
 * 
 * Pro :
 * - easy to write
 * 
 * con:
 * - due to recursive call, the function stack can be full and can give
 * stackoverflow error.
 * 
 * 
 * For recursion : 
 * 
 * - take care of input to recursive method , check constant and variable inputs
 * - focus on base condition : smallest valid input for the method.
 * 
 * @author kumars
 *
 *
 *in this problem statement , we need to calculate the max weight a knapsack can hold given the capacity of 
 *knapsack.
 */
public class KnapSackWithRecursion {

	public static void main(String[] args) {
		int[] weights = { 2, 4, 5, 6 };
		int[] value = { 5, 6, 7, 8 };
		int capacity = 10;
		
		int length = weights.length;
		int maximumWeight = getKnapsackMaximumWeight(weights, value, capacity , length);
		
		System.out.println("The result is : "+ maximumWeight);
		

	}

	/**
	 * In this recursion method.
	 * @param weights
	 * @param value
	 * @param capacity
	 * @param length
	 * @return
	 */
	private static int getKnapsackMaximumWeight(int[] weights, int[] value, int capacity, int length) {
		// base condition
		if (capacity == 0 || length == 0) {
			return 0;
		}
		// choice diagram :actual code
		if (weights[length - 1] <= capacity) {

			return Math.max(
					value[length - 1]
							+ getKnapsackMaximumWeight(weights, value, capacity - weights[length - 1], length - 1),
					getKnapsackMaximumWeight(weights, value, capacity, length - 1));
		} else {
			return getKnapsackMaximumWeight(weights, value, capacity, length - 1);
		}
	}

}
