package com.learning.programs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int n = 0; n < t; n++) {
			int b = sc.nextInt();
			List<Integer> bSkills = new ArrayList<Integer>();
			int x = 1;
			while (x <= b) {
				if (sc.hasNextInt()) {
					bSkills.add(sc.nextInt());
					x++;
				}
			}
			int g = sc.nextInt();
			List<Integer> gSkills = new ArrayList<Integer>();
			int y = 1;
			while (y <= g) {
				if (sc.hasNextInt()) {
					gSkills.add(sc.nextInt());
					y++;
				}
			}

			System.out.println(getNoOfPairs(b, bSkills, g, gSkills));
		}
	}

	private static int getNoOfPairs(int b, List<Integer> bSkills, int g, List<Integer> gSkills) {
		int pair = 0;
		for (int i = 0; i < b; i++) {
			for (int j = 0; j < g && j < gSkills.size(); j++) {
				int skDiff = (gSkills.get(j) > bSkills.get(i)) ? (gSkills.get(j) - bSkills.get(i))
						: (bSkills.get(i) - gSkills.get(j));
				if (skDiff == 1) {
					pair = pair + 1;
					gSkills.remove(j);
				}
			}
		}
		return pair;
	}

}
