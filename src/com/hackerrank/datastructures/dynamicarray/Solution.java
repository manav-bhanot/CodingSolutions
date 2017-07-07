package com.hackerrank.datastructures.dynamicarray;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT.
		 * Your class should be named AdditionWithoutUsingOperator.
		 */

		Scanner read = new Scanner(System.in);

		int N = read.nextInt();

		int seqList[][] = new int[N][];
		for (int i = 0; i < N; i++) {
			seqList[i] = new int[10];
		}

		int lastAns = 0;

		int totalQueries = read.nextInt();
		int query[][] = new int[totalQueries][3];
		for (int index = 0; index < totalQueries; index++) {
			query[index][0] = read.nextInt();
			query[index][1] = read.nextInt();
			query[index][2] = read.nextInt();
		}

		int[] seqSize = new int[N];

		for (int index = 0; index < totalQueries; index++) {
			if (query[index][0] == 1) {
				int seqIndex = (query[index][1] ^ lastAns) % N;
				if (seqSize[seqIndex] == seqList[seqIndex].length) {
					seqList[seqIndex] = Arrays.copyOf(seqList[seqIndex], seqList[seqIndex].length + 10);
				}
				seqList[seqIndex][seqSize[seqIndex]] = query[index][2];
				seqSize[seqIndex]++;
			} else if (query[index][0] == 2) {
				int seqIndex = (query[index][1] ^ lastAns) % N;
				if (seqSize[seqIndex] != 0) {
					lastAns = seqList[seqIndex][query[index][2] % seqSize[seqIndex]];
				} else {
					lastAns = 0;
				}
				System.out.println(lastAns);
			}
		}
	}
}
