/**
 * 
 */
package com.geeksforgeeks.backtracking;

/**
 * @author Manav
 *
 */
public class KnightTour {

	private int[][] next = new int[][] { { 2, 1 }, { 1, 2 }, { -1, 2 }, { -2, 1 }, { -2, -1 }, { -1, -2 }, { 1, -2 },
		{ 2, -1 } };
			
	private int[][] board = new int[8][8];
			
	private int move = 1;
	
	private boolean findKnightTour(int i, int j, int move) {
		
		//System.out.println(i+","+j);
		
		// Check if there is still a move left
		if (move > 64) return true;
		
		for (int[] dir : next) {
			
			int x = i + dir[0];				
			int y = j + dir[1];
			
			// Check if the direction is a valid direction			
			if (isValid(x, y) && !isAssigned(x, y)) {
				
				//System.out.println(i+","+j);				
				board[x][y] = move;				
				if (findKnightTour(x, y, move + 1)) {
					return true;
				}				
				board[x][y] = 0;
			}
		}
		
		return false;
	}
	
	private boolean isAssigned(int i, int j) {
		if (board[i][j] != 0) {
			return true;
		}
		return false;
	}

	private boolean isValid(int i, int j) {
		
		if (i < 8 && j < 8 && i >= 0 && j >= 0) {
			return true;
		}
		
		return false;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		KnightTour knightTour = new KnightTour();
		
		knightTour.board[0][0] = knightTour.move;
		
		System.out.println(knightTour.findKnightTour(0, 0, knightTour.move + 1));
		
		for (int i = 0; i < 8; i++) {
			for (int j=0; j < 8; j++) {
				System.out.print("\t" + knightTour.board[i][j]);
			}			
			System.out.println();
		}
	}

}
