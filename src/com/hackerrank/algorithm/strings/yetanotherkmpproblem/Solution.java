/**
 * 
 */
package com.hackerrank.algorithm.strings.yetanotherkmpproblem;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * @author Manav
 *
 */
public class Solution {

	// public static ArrayList<String> performPermutations(String s){
	// ArrayList<String> arrayList = new ArrayList<String>();
	// if (s == null) {
	// return null;
	// }
	//
	// else if (s.length() == 0) {
	// arrayList.add("");
	// return arrayList;
	// }
	//
	// else {
	// for (int i = 0; i < s.length(); i++) {
	// ArrayList<String> remaining = performPermutations(s.substring(0, i) +
	// s.substring(i + 1));
	// for (int j = 0; j < remaining.size(); j++) {
	// arrayList.add(s.charAt(i) + remaining.get(j));
	// }
	// }
	// return arrayList;
	// }
	// }

	public static Set<String> getPermutations(String str) {
		char[] cArray = str.toCharArray();
		Set<String> realRes = new HashSet<String>();
		Set<String> results = new HashSet<String>();
		for (char c : cArray) {
			Set<String> currResults = new HashSet<String>(results);
			String charToAdd = String.valueOf(c);
			results.add(charToAdd);
			// System.out.println(currResults.size());
			for (String s : currResults) {
				for (int i = 0; i < s.length() + 1; i++) {
					String newWord = s.substring(0, i) + charToAdd + s.substring(i);
					if (newWord.length() == str.length()) {
						realRes.add(newWord);
					} else {
						results.add(newWord);
					}
				}
			}
		}
		return realRes;
	}
	
	private static String findLexiographicalSmallestString(String str1, String str2) {
		if (str1.compareTo(str2) < 0) {
			return str1;
		}
		return str2;
	}

	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT.
		 * Your class should be named Solution.
		 */
		Scanner sc = new Scanner(System.in);
		int[] sequence = new int[26];
		for (int i = 0; i < 26; i++) {
			sequence[i] = sc.nextInt();
		}
		StringBuilder str = new StringBuilder();
		for (int i = 0; i < 26; i++) {
			while (sequence[i] != 0) {
				str.append((char) (i + 97));
				sequence[i]--;
			}
		}
		// System.out.println(str);

		Set<String> arr = getPermutations(str + "");
		
		int min = Integer.MAX_VALUE;
		List<String> minimumKMPSumStrings = new ArrayList<String>();
		
		for (String perm : arr) {
			//System.out.println(i);
			
			//Constructing the KMP matrix
			int len = perm.length();			
			int kmp[] = new int[len];
			char[] S = perm.toCharArray();
			int sum = 0;
			
			kmp[0] = 0;
			int j=0;
			
			for (int i = 1; i < len; i++) {
				
				if (S[i] == S[j]) {
					j++;
					kmp[i] = j;
				} else {
					while (j > 0 && S[i] != S[j]) {
						j = kmp[j-1];
						kmp[i] = j;
					}
					if (S[i] == S[j]) {
						kmp[i] = j+1;
					}					
				}
				
				sum = sum + kmp[i];
			}
			
			System.out.println("String : "+perm+" :: Sum : "+sum);
			
			if (sum < min) {
				minimumKMPSumStrings.clear();
				minimumKMPSumStrings.add(perm);
				min = sum;
			} else if (sum == min) {
				minimumKMPSumStrings.add(perm);
			}
		}
		
		String smallestString = minimumKMPSumStrings.get(0);
		for (int k=1; k<minimumKMPSumStrings.size() - 1; k++) {
			smallestString = findLexiographicalSmallestString(smallestString, minimumKMPSumStrings.get(k));
		}
		
		System.out.println(smallestString);
	}
}
