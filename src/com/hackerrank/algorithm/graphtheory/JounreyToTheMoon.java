/**
 * 
 */
package com.hackerrank.algorithm.graphtheory;

import java.util.Scanner;

/**
 * @author Manav
 *
 */
public class JounreyToTheMoon {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int N = scan.nextInt();
		int I = scan.nextInt();

		int[] astronauts = new int[N];
		int[] pairs = new int[2];

		for (int i = 0; i < N; i++) {
			astronauts[i] = scan.nextInt();
		}

		int count = 0;

		for (int i = 0; i < N; i++) {
			if (i % 2 == 0) {
				for (int j = i + 2; j < N; j++) {
					System.out.println(astronauts[i] + "," + astronauts[j]);
					count++;
				}
			} else {
				for (int j = i + 1; j < N; j++) {
					System.out.println(astronauts[i] + "," + astronauts[j]);
					count++;
				}
			}
		}

		System.out.println(count);
		// createPairsToSendToMoon(0, pairs, astronauts);
	}

	private static void createPairsToSendToMoon(int start, int[] pairs, int[] astronauts) {

		if (start >= astronauts.length || pairs.length == 2) {
			System.out.println(pairs[0] + "," + pairs[1]);
		}

		createPairsToSendToMoon(start + 1, pairs, astronauts);

		pairs[start] = astronauts[start];

		createPairsToSendToMoon(start + 1, pairs, astronauts);

	}

}
