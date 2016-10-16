/**
 * 
 */
package com.hackerrank.algorithm.implementation.cutthesticks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();

		List<Integer> listOfSticks = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			listOfSticks.add(in.nextInt());
		}

		int index = 0;
		Collections.sort(listOfSticks);
		/*for (Integer i : listOfSticks) {
			System.out.println(i);
		}*/
		while (listOfSticks.size() != 0) {
			System.out.println(listOfSticks.size());
			while (listOfSticks.size() != 1 && listOfSticks.get(index) == listOfSticks.get(index + 1)) {
				//System.out.println(listOfSticks.get(index));
				listOfSticks.remove(index);
			}
			listOfSticks.remove(index);
		}
	}

}
