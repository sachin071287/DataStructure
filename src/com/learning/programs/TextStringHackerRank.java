package com.learning.programs;

import java.util.ArrayList;
import java.util.List;

public class TextStringHackerRank {

	public static void main(String[] args) {
		List<String> sentences= new ArrayList<String>();
		sentences.add("jim likes mary");
		sentences.add("kate likes tom");
		sentences.add("tom does not like jim");
		List<String> queries= new ArrayList<String>();
		queries.add("jim tom");
		queries.add("likes");
		textQueries(sentences, queries);
		
		//correct dmout in this case
		// 0 2
		// 0 1

	}
	
	public static void textQueries(List<String> sentences, List<String> queries) {
		// Write your code here
		for (String query : queries) {
			String[] queriesArray = query.split(" ");
			StringBuilder outPut = new StringBuilder();
			for (int i = 0; i < queriesArray.length; i++) {
				int k = 0;
				for (String sentence : sentences) {
					String[] sentenceArray = sentence.split(" ");
					for (int j = 0; j < sentenceArray.length; j++) {
						if (queriesArray[i].equals(sentenceArray[j])) {
							outPut.append(k + " ");
						}
					}
					k++;
				}
			}
			if (outPut.length() > 0) {
				System.out.println(outPut.toString().trim());
			} else {
				System.out.println("-1");
			}
		}
	}

}
