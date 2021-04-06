package com.learning.skillenza;

public class SquarePrintByAshish {
	
		public static void main(String[] args) {
			int[] inputArr = { 1, 2, 3, 4, 5, 1, 2, 6 };
			for (int input : inputArr) {
				/*
				 * array to hold the final output, all the values are null by default
				 * array size is equal to size of outer square
				 */
				int outerSquareSize = getSquareSize(input);
				Character[][] output = new Character[outerSquareSize][outerSquareSize];
				
				printNestedSquares(input, output);
				printOutput(output);
				System.out.println("==========================================================");
			}
		}

		private static void printNestedSquares(int noOfSqaures, Character[][] output) {
			/*
			 * loop for each square/nested square
			 * startingIndex of each inner square increases by 2
			 * size for each nested square will be calculated and passed to prepareOutput method
			 */
			for (int totalSquaresIndex = noOfSqaures, startingIndex = 0; totalSquaresIndex > 0; totalSquaresIndex--, startingIndex += 2) {
				prepareOutput(startingIndex, getSquareSize(totalSquaresIndex), output);
			}
		}

		/**
		 * 
		 * @param startingIndex- required to handle the dynamic starting point for each square
		 * @param squareSize- each square/nested square will be of different size
		 * @param output- only the required values will be updated to *, rest all will be null
		 */
		private static void prepareOutput(int startingIndex, int squareSize, Character[][] output) {
			for (int row = 0; row < squareSize; row++) {
				for (int column = 0; column < squareSize; column++) {
					if (row == 0 || row == squareSize - 1 || column == 0 || column == squareSize - 1) {
						output[startingIndex + row][startingIndex + column] = '*';
					}
				}
			}
		}

		private static int getSquareSize(int input) {
			return 2 + (input - 1) * 4;
		}

		private static void printOutput(Character[][] output) {
			for (Character[] rows : output) {
				for (Character value : rows) {
					if (value == null) {
						System.out.print("  ");
					} else {
						System.out.print(value + " ");
					}
				}
				System.out.println();
			}
		}

	}

