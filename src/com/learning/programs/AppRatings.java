package com.learning.programs;

import java.util.*;

/**
 * input :Gmail 2,Facebook 3,Gmail 4,Facebook 5,Gmail 7
 * Output: 
 * Facebook 4.00 2
*  Gmail 4.33 3
 *
 */
public class AppRatings {
	
	
    public static class RatingStatisticsCollectorImpl implements RatingStatisticsCollector {
    	private static Map<String, List<Integer>> inputMap = new HashMap<String, List<Integer>>();
    	
        @Override
		public void putNewRating(String app, int rating) {
			if (inputMap.containsKey(app)) {
				inputMap.get(app).add(rating);
			} else {
				List<Integer> ratings = new ArrayList<Integer>();
				ratings.add(rating);
				inputMap.put(app, ratings);
			}

		}

        @Override
		public double getAverageRating(String app) {
			double sum = 0;
			List<Integer> ratings = inputMap.get(app);
			if (ratings == null) {
				return sum;
			} else {
				sum = ratings.stream().mapToDouble(r -> r).sum();
				return sum / ratings.size();
			}
		}

        @Override
		public int getRatingsCount(String app) {
			List<Integer> ratings = inputMap.get(app);
			if (ratings == null) {
				return 0;
			} else {
				return ratings.size();
			}
		}
    }

    ////////////////// DO NOT MODIFY BELOW THIS LINE ///////////////////

    public interface RatingStatisticsCollector {
        // Ratings feed will call this method when new app rating information is received. This is input to your class. ratings is a non negative integer between 0 to 10.
        public void putNewRating(String app, int rating);

        // Report the average rating of the app. 
        public double getAverageRating(String app);

        // Report the total number of rating for an app.
        public int getRatingsCount(String app);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numLines = Integer.parseInt(scanner.nextLine());
        int currentLine = 0;
        while (currentLine++ < numLines) {
            final RatingStatisticsCollector stats = new RatingStatisticsCollectorImpl();
            final Set<String> apps = new TreeSet<>();

            String line = scanner.nextLine();
            String[] inputs = line.split(",");
            for (int i = 0; i < inputs.length; ++i) {
                String[] tokens = inputs[i].split(" ");
                final String app = tokens[0];
                apps.add(app);
                final int runs = Integer.parseInt(tokens[1]);

                stats.putNewRating(app, runs);

            }

            for (String app : apps) {
                System.out.println(
                        String.format("%s %.2f %d", app, stats.getAverageRating(app), stats.getRatingsCount(app)));
            }

        }
        scanner.close();

    }
}
