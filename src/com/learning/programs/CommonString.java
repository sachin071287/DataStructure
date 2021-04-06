package com.learning.hackerrank;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class CommonString {

	/*
	 * Complete the 'commonSubstring' function below.
	 *
	 * The function accepts following parameters: 1. STRING_ARRAY a 2. STRING_ARRAY
	 * b
	 */
	public static void main(String[] args) {
		printResult("hello", "world");
	}

	public static void commonSubstring(List<String> a, List<String> b) {

		/*
		 * for (int i= 0;i< a.size(); i++) { printResult(a.get(i) ,b.get(i)); }
		 */
		printResult("hello", "world");
	}

	public static void printResult(String first, String second) {
		List<String> firstOne = (List) Arrays.asList(first.split(""));
		for (String string : firstOne) {
			System.out.println(string);
		}
		List<String> secondOne = (List) Arrays.asList(second.split(""));
		for (String c : secondOne) {
			if (firstOne.contains(c)) {
				System.out.println("YES");
				return;
			}
		}

		System.out.println("NO");
	}

}
