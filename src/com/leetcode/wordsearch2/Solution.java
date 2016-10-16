package com.leetcode.wordsearch2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

	public static void main(String[] args) {

		char[][] board = { { 'o', 'a', 'n', 'n' }, { 'e', 't', 'a', 'e' }, { 'i', 'h', 'k', 'r' },
				{ 'i', 'f', 'l', 'v' } };		
		
		String[] words = new String[] {"oath", "pea", "eat", "rain"};
		
		Map<Character, List<Position>> charMap = new HashMap<Character, List<Position>>();
		
		for (int i=0; i<board.length; i++) {
			for (int j=0; j<board[0].length; j++) {
				if (charMap.containsKey(board[i][j])) {
					//Position p = new Position(i,j);
					charMap.get(board[i][j]).add(new Position(i,j));
				} else {
					List<Position> pList = new ArrayList<Position>();
					pList.add(new Position(i, j));
					charMap.put(board[i][j], pList);
				}
			}
		}
		
		for (String word : words) {			
			
			//for (int i=0; i<word.length(); i++) {

				boolean[][] tempBoard = new boolean[board.length][board[0].length];		
				
				for (Position pos : charMap.get(word.charAt(0))) {
					int k=0;
					if (dfs(board, tempBoard, word, pos, k)) {
						System.out.println(word);
					}					
					/*for (Position pos2 : charMap.get(word.charAt(i+1))) {
						diff = 0;
						if (Math.abs(pos1.i - pos2.i) == 1) {
							diff++;
						}
						if (Math.abs(pos1.j - pos2.j) == 1) {
							diff++;
						}
						if (diff != 0 && diff > 1) {
							break;
						}
					}*/
				}				
			//}
		}		
	}
	
	private static boolean dfs(char[][] board, boolean[][] temp, String word, Position pos, int k) {
		
		if (k == word.length() - 1) {
			return true;
		}
		
		return true;
	}
}

class Position {
	int i;
	int j;
	public Position(int i, int j) {
		super();
		this.i = i;
		this.j = j;
	}
}
