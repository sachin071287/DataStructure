package com.learning.programs;

import java.io.*;
import java.util.*;

public class TestClass {
	
	public static class StartEnd implements Comparator<StartEnd>{
		int startTime;
		int endTime;
		
		public int getStartTime() {
			return startTime;
		}

		public void setStartTime(int startTime) {
			this.startTime = startTime;
		}

		public int getEndTime() {
			return endTime;
		}
		public void setEndTime(int endTime) {
			this.endTime = endTime;
		}

		public StartEnd(int startTime, int endTime) {
			this.startTime = startTime;
			this.endTime = endTime;
		}

		public StartEnd() {

		}

		@Override
		public int compare(StartEnd o1, StartEnd o2) {
			return o1.getStartTime()-o2.getStartTime();
		}
	}
	
	static int minParkingSpaces(int[][] parkingStartEndTimes) {

		List<StartEnd>startTimes  = new ArrayList<StartEnd>();
		for (int i = 0; i < parkingStartEndTimes.length; i++) {
			startTimes.add(new StartEnd(parkingStartEndTimes[i][0] , parkingStartEndTimes[i][1]));
		}
		Collections.sort(startTimes, new StartEnd());
		int result = 0;
		for (StartEnd startEnd : startTimes) {
			if(true) {
				result = result  + 1;
			}
			else {
				
			}
		}
		return result ;
		
		
	}

	// DO NOT MODIFY ANYTHING BELOW THIS LINE!!

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter wr = new PrintWriter(System.out);
		int n = Integer.parseInt(br.readLine().trim());
		int[][] parkingStartEndTimeList = new int[n][2];
		String[] parkingStartEndTimes = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			String[] parkingStartEndTime = parkingStartEndTimes[i].split(",");
			for (int j = 0; j < parkingStartEndTime.length; j++) {
				parkingStartEndTimeList[i][j] = Integer.parseInt(parkingStartEndTime[j]);
			}
		}

		int out = minParkingSpaces(parkingStartEndTimeList);
		System.out.println(out);

		wr.close();
		br.close();
	}
}
