/**
 * 
 */
package com.geeksforgeeks.backtracking;

/**
 * A Maze is given as N*N binary matrix of blocks where source block is the
 * upper left most block i.e., maze[0][0] and destination block is lower
 * rightmost block i.e., maze[N-1][N-1]. A rat starts from source and has to
 * reach destination. The rat can move only in two directions: forward and down.
 * In the maze matrix, 0 means the block is dead end and 1 means the block can
 * be used in the path from source to destination.
 * 
 * @author Manav
 *
 */
public class RatInAMaze {

	/**
	 * @param args
	 */
	int n = 4;
	int maze[][] = { { 1, 1, 1, 1 }, { 1, 1, 0, 1 }, { 0, 1, 1, 0 }, { 1, 1, 1, 1 } };

	private boolean isValid(int x, int y) {
		if (x > n - 1 || y > n - 1) return false;
		else return true;
	}

	private boolean isBlocked(int x, int y) {
		if (maze[x][y] == 0) return true;
		else return false;
	}

	private boolean findPath(int i, int j) {
		
		System.out.println(i+ "-" + j);

		// Check if we have reached the destination cell which is [n-1][n-1]
		if (i == n - 1 && j == n - 1) {
			return true;
		}

		// Check if forward movement is allowed and not blocked
		if (isValid(i, j + 1) && !isBlocked(i, j + 1)) {

			// Move the rat in the forward cell and recurse			
			if (findPath(i, j + 1)) {
				return true;
			}
		}

		// Check if downward movement is allowed and not blocked
		if (isValid(i + 1, j) && !isBlocked(i + 1, j)) {

			// Move the rat in the downward cell and recurse
			if (findPath(i + 1, j)) {
				return true;
			}
		}
		
		return false;
	}

	public static void main(String[] args) {
		
		RatInAMaze ratInAMaze = new RatInAMaze();
		System.out.println(ratInAMaze.findPath(0, 0));
	}

}
