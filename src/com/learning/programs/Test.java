package com.learning.programs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * Find count of complete given word which can be created from a given sentence
 * by using its characters. Similar to collage creation by using newspaper
 * headlines. Example: Given sentence: "Everyday is a wonderful day" Given
 * word:Day : Output: 3
 */
public class Test {

	public static void main(String[] args) {

		String inputSentance = "Everyday is a wonderful day";
		String word = "Day";

		Map<String, Integer> wordMap = new HashMap<String, Integer>();
		for (String s2 : inputSentance.split("")) {
			if (wordMap.containsKey(s2)) {
				wordMap.put(s2, wordMap.get(s2) + 1);
			} else {
				wordMap.put(s2, 1);
			}

		}
		Set<Integer>set = new HashSet();
		for (String s1 : word.split("")) {
			if (wordMap.containsKey(s1)) {
				set.add(wordMap.get(s1));
			} 

		}

	}

}
