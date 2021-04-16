package com.learning.programs;

import java.util.HashSet;
import java.util.Set;

public class Test2 {
	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 3, 3, 3, 4, 5, 5, 5, 5, 1, 2, 2 };
		Set<Integer> uniqueItems = new HashSet<Integer>();
		for (int i = 0; i < array.length; i++) {
			uniqueItems.add(array[i]);
		}
		System.out.println("result is :" + uniqueItems.size());
	}

}
