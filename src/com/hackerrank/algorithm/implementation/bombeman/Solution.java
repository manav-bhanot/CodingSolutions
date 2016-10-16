package com.hackerrank.algorithm.implementation.bombeman;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Manav
 *
 */
public class Solution {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);

		int R = read.nextInt();
		int C = read.nextInt();
		int N = read.nextInt();
		
		String[][][] states = new String[3][R][C];
		

		String[][] state = new String[R][C];

		String[][] previousState = null;
		String[][] currentState = null;

		Map<Integer, String[][]> stateMap = new HashMap<Integer, String[][]>();
		
		String row;
		for (int i = 0; i < R; i++) {
			row = read.next();
			for (int j = 0; j < C; j++) {
				state[i][j] = row.charAt(j)+"";
			}
		}
		//stateMap.put(0, state);

		/*
		 * System.out.println("State at t = 0 is : "); for (int i=0; i<R; i++) {
		 * for (int j=0; j<C; j++) { System.out.print(state[i][j]); }
		 * System.out.println(); }
		 */

		for (int t = 1; t <= N; t++) {			
			if (t == 1) {
				// Since state at t=0 and t=1 are same. So do nothing
				// => states[0] holds the state at t=0 and t=1
				states[t] = states[t-1];
			} else if (t % 2 == 0) {
				
				currentState = new String[R][C];
				for (int i = 0; i < R; i++) {
					for (int j = 0; j < C; j++) {
						currentState[i][j] = "O";
					}
				}
				stateMap.put(t, currentState);
			} else {
				// explodes the bomb placed exactly 3 sec before
				previousState = stateMap.get(t - 3);

				/*
				 * System.out.println("Previous State is : "); for (int i=0;
				 * i<R; i++) { for (int j=0; j<C; j++) {
				 * System.out.print(previousState[i][j]); }
				 * System.out.println(); }
				 */

				currentState = stateMap.get(t - 1);
				String[][] nextState = new String[R][C];
				for (int i = 0; i < R; i++) {
					nextState[i] = Arrays.copyOf(currentState[i], C);
				}
				for (int i = 0; i < R; i++) {
					for (int j = 0; j < C; j++) {
						if (previousState[i][j].equals("O")) {
							nextState[i][j] = ".";
							currentState[i][j] = ".";
							if (j + 1 <= C - 1) {
								nextState[i][j + 1] = ".";
							}
							if (i + 1 <= R - 1) {
								nextState[i + 1][j] = ".";
							}
							if (i - 1 >= 0) {
								nextState[i - 1][j] = ".";
							}
							if (j - 1 >= 0) {
								nextState[i][j - 1] = ".";
							}
						}
					}
				}
				stateMap.put(t, nextState);
			}

			/*
			 * System.out.println("State at t = "+t+" is : "); for (int i=0;
			 * i<R; i++) { for (int j=0; j<C; j++) {
			 * System.out.print(stateMap.get(t)[i][j]); } System.out.println();
			 * }
			 */
		}

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(stateMap.get(N)[i][j]);
			}
			System.out.println();
		}
	}

}
