/**
 * 
 */
package com.hackerrank.algorithm.implementation.lisaworkbook;

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
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT.
		 * Your class should be named AdditionWithoutUsingOperator.
		 */
		Scanner read = new Scanner(System.in);
		int n = read.nextInt();
		int k = read.nextInt();

		Map<Integer, Integer> problemsPerChapter = new HashMap<Integer, Integer>();

		for (int c_i = 1; c_i <= n; c_i++) {
			problemsPerChapter.put(c_i, read.nextInt());
		}

		int specialProblems = 0;
		int pageNumber = 1;

		for (Integer chapt : problemsPerChapter.keySet()) {
			int t = 1;
			int totalPagesReq = problemsPerChapter.get(chapt) % k == 0 ? problemsPerChapter.get(chapt) / k
					: problemsPerChapter.get(chapt) / k + 1;

			for (int i = 1; i <= totalPagesReq; i++) {
				if (i == totalPagesReq && problemsPerChapter.get(chapt) % k != 0) {
					if (pageNumber >= t && pageNumber <= t + problemsPerChapter.get(chapt) % k - 1) {
						specialProblems++;
					}
				} else if (pageNumber >= t && pageNumber <= t + k - 1) {
					specialProblems++;
				}
				System.out.println("Chapter : "+chapt+", Page : "+pageNumber+",  Problems ("+t+"-"+(t+k-1)+"), SpecialProblem : "+specialProblems);
				pageNumber++; 
				t = t + k;
			}
		}
		System.out.println(specialProblems);
	}

}
