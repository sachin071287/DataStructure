package com.dp;

public class Arraypermutation {

	public static void main(String[] args) {

		Integer[] inputArray = {1,2,3};
		//output :
		// 1, 2, 3
		// 1,2,3
		
		printPermutaion(inputArray);
		
	}

	private static void printPermutaion( int start , int end , Integer[] inputArray) {

		if (inputArray == null) {
			return;
		}
		if(start == end) {
			System.out.println();
		}
		int k = 0;
		for (int i = 0; i < inputArray.length; i++) {
           swap(inputArray[i+1], inputArray[i+2]);
			
		}

	}
}
