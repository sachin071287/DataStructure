package com.learning.programs;

/* Read input from STDIN. Print your output to STDOUT*/

import java.io.*;
import java.util.*;

/**
 * Virus Outbreak (100 Marks) In the Martian land faraway, a new virus has
 * evolved and is attacking the individuals at a fast pace. The scientists have
 * figured out the virus composition, V. The big task is to identify the people
 * who are infected. The sample of N people is taken to check if they are
 * POSITIVE or NEGATIVE. A report is generated which provides the current blood
 * composition B of the person. POSITIVE or NEGATIVE ?
 * 
 * If the blood composition of the person is a subsequence of the virus
 * composition V, then the person is identified as POSITIVE otherwise NEGATIVE.
 * 
 * Example: Virus Composition, V = coronavirus Blood Composition of the person ,
 * B = ravus * The person in question is POSITIVE as B is the subsequence of the
 * V.
 * 
 * The scientists are busy with their research for medicine and request you to
 * build a program which can quickly figure out if the person is POSITIVE or
 * NEGATIVE. They will provide you with the virus composition V and all the
 * people’s current blood composition. Can you help them?
 * 
 * 
 * Note: The virus and blood compositions are lowercase alphabet strings. Input
 * Format The first line of the input consists of the virus composition, V The
 * second line of he input consists of the number of people, N Next N lines each
 * consist of the blood composition of the ith person, Bi
 * 
 * Constraints 1<= N <=10 1<= |B|<= |V|<= 10^5 Output Format For each person,
 * print POSITIVE or NEGATIVE in a separate line
 *
 * Sample TestCase 1 Input coronavirus 3 abcde crnas onarous
 * 
 * Output NEGATIVE POSITIVE NEGATIVE
 */
public class MaximumDifferencePrimeTest {

	//closest prime number for 10^6
	public final static int MAX_RANGE = 1000003;

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String args[]) throws Exception {
		// array to hold prime number such that
		// withLaregstPrimeNumberWithIndex[i] = largest prime number smaller/equal to i
		int withLaregstPrimeNumberWithIndex[] = new int[MAX_RANGE];
		// array to hold prime number such that
		// withSmallestPrimeNumberWithIndex[i] = smallest prime number greater/equal to i
		int withSmallestPrimeNumberWithIndex[] = new int[MAX_RANGE];
		preCompute(withLaregstPrimeNumberWithIndex, withSmallestPrimeNumberWithIndex);
		Scanner scanner = new Scanner(System.in);
		int noOfTestCase = Integer.parseInt(scanner.nextLine());
		int currentCount = 0;
		while (currentCount++ < noOfTestCase) {
			String range = scanner.nextLine();
			String[] rangeArray = range.split(" ");
			printMaximumDifferenceOfPrime(withLaregstPrimeNumberWithIndex, withSmallestPrimeNumberWithIndex,
					Integer.parseInt(rangeArray[0]), Integer.parseInt(rangeArray[1]));
		}
		scanner.close();

	}

	private static void printMaximumDifferenceOfPrime(int withLaregstPrimeNumberWithIndex[], int withSmallestPrimeNumberWithIndex[], int L, int R) {
		// no prime number in range
		if (withLaregstPrimeNumberWithIndex[R] < L && withSmallestPrimeNumberWithIndex[L] > R) {
			System.out.println(-1);
			return;
		}
		// atleast one is there
		if (withLaregstPrimeNumberWithIndex[R] < L || withSmallestPrimeNumberWithIndex[L] > R) {
			System.out.println(0);
		} // atlest 2 prime number are present
		else {
			System.out.println(withLaregstPrimeNumberWithIndex[R] - withSmallestPrimeNumberWithIndex[L]);
		}

	}

	private static void preCompute(int withLaregstPrimeNumberWithIndex[], int withSmallestPrimeNumberWithIndex[]) {
		// create Sieve of erathostheness
		boolean[] sievePrime = new boolean[MAX_RANGE];
		for (int i = 0; i < sievePrime.length; i++) {
			sievePrime[i] = true;
		}
		for (int i = 2; i * i < MAX_RANGE; i++) {
			if (sievePrime[i]) {
				for (int j = i * i; j < MAX_RANGE; j += i) {
					sievePrime[j] = false;
				}
			}
		}

		withLaregstPrimeNumberWithIndex[1] = 1;
		
		withSmallestPrimeNumberWithIndex[MAX_RANGE - 1] = (int) 1e9 + 7;

		
		for (int i = 2; i < MAX_RANGE; i++) {
			if (sievePrime[i]) {
				withLaregstPrimeNumberWithIndex[i] = i;
			} else {
				withLaregstPrimeNumberWithIndex[i] = withLaregstPrimeNumberWithIndex[i - 1];
			}
		}

		
		for (int i = MAX_RANGE - 2; i > 1; i--) {
			if (sievePrime[i]) {
				withSmallestPrimeNumberWithIndex[i] = i;
			} else {
				withSmallestPrimeNumberWithIndex[i] = withSmallestPrimeNumberWithIndex[i + 1];
			}
		}

	}

}
