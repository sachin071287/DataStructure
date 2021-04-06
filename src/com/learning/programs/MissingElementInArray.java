package com.dp;

public class MissingElementInArray {

	public static void main(String[] args) {

		//Integer[] inputArray = {0,1,2,3,4,5,6,7,9,10};
		//Integer[] inputArray = {1,2,3,4,5,6,7,9,10};
		Integer[] inputArray = {5,7,8,9,10};
		
		
		System.out.println("Missing NUmber is  : " + getMissingElement1(inputArray) );
	}

	private static int getMissingElement(Integer[] inputArray) {

		int mid = (inputArray.length) / 2;
		int startIndex = 0;
		int endIndex = inputArray.length;

		while (mid > 0 && endIndex > startIndex) {
			if (mid == inputArray[mid]) {
				startIndex = mid + 1;
			} else {
				endIndex = mid;
			}
			mid = (startIndex + endIndex) / 2;
		}

		return mid;

	}
	
	private static int getMissingElement1(Integer[] inputArray) {
		// find normalized number
		int startingValue = inputArray[0];

		int mid = (inputArray.length) / 2;
		int startIndex = 0;
		int endIndex = inputArray.length;

		while (mid > 0 && endIndex > startIndex && mid> startingValue) {
			if (mid == inputArray[mid - startingValue]) {
				startIndex = mid + 1;
			} else {
				endIndex = mid;
			}
			mid = (startIndex + endIndex) / 2;
		}

		return mid;

	}

}
