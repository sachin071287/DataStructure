package com.learning.skillenza;

import java.util.Scanner;

public class SquarePrint {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int numOfTestcase = Integer.parseInt(scanner.nextLine());
		int currentLine = 0;
		while (currentLine++ < numOfTestcase) {
			int printSquareLevel = Integer.parseInt(scanner.nextLine());
			printSquare(printSquareLevel);
		}

		scanner.close();

	}

	private static void printSquare(int printSquareLevel) {

		int total = getTotalBoundForGivenLevel(printSquareLevel);
		System.out.println("Sum is : " + total);
		for (int i = 1; i <= total; i++) {
			if (i<= total ) {
				System.out.print("*");
			}
			for (int j = 1; j <= total; j++) {
				if (i == 1 || i == total || j == 1 || j == total) {
					System.out.print("*");
				} 
				while (J<n-2>){
					else {
				}
					System.out.print(" ");

				}
				j = j + 2;
			}
			i = i + 2;
			System.out.print("\n");
		}

	}

	private static int getTotalBoundForGivenLevel(int printSquareLevel) {
		int sum = 0;
		for (int i = 1; i <= printSquareLevel; i++) {
			if (i == 1) {
				sum = sum + 2;
			} else {
				sum = sum + 4;
			}
		}
		return sum;
	}
}
