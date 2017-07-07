/**
 * 
 */
package com.leetcode;

/**
 * @author Manav
 * 
 *         Given a grid (m X n) having some food placed at some of its cells.
 *         Food item dented by "#" Given a person located at any random cell.
 *         Person denoted by "*". Rest of the cells are marked with either "O"
 *         or "X". "O" => we can move through those cells "X" => we cannot move
 *         through cells
 * 
 *         Find the shortest path which enables a person to travel through the
 *         grid and consume all the food items
 *
 */
public class ShortestPathInAMazeCoveringMultipleDestinations {

	int shortestPath = Integer.MAX_VALUE;
	int foodItems;

	public static void main(String[] args) {
		
		ShortestPathInAMazeCoveringMultipleDestinations obj = new ShortestPathInAMazeCoveringMultipleDestinations();

		String[][] grid = new String[][] { { "X", "X", "X", "X", "X" }, { "X", "*", "O", "O", "X" },
				{ "X", "O", "O", "X", "X" }, { "X", "#", "O", "O", "X" }, { "#", "O", "O", "O", "X" },
				{ "X", "#", "O", "X", "X" } };
				
		System.out.println(obj.findShortestPath(grid));

	}

	private int findShortestPath(String[][] grid) {

		int totalFoodItems = 0;

		// Count the total number of food items
		for (int row = 0; row < grid.length; row++) {
			for (int col = 0; col < grid[0].length; col++) {

				if (grid[row][col].equals("#")) {
					totalFoodItems++;
				}
			}
		}

		foodItems = totalFoodItems;

		// Get the initial location of the person
		int person_x = 0, person_y = 0;
		boolean isPersonFound = false;

		for (int row = 0; row < grid.length; row++) {
			for (int col = 0; col < grid[0].length; col++) {

				if (grid[row][col].equals("*")) {
					person_x = row;
					person_y = col;
					isPersonFound = true;
					break;
				}
			}
			if (isPersonFound)
				break;
		}

		boolean[][] isVisited = new boolean[grid.length][grid[0].length];

		// Direction sequence => TOP, RIGHT, BOTTOM, LEFT
		int[][] directions = new int[][] { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

		findShortestPathInGrid(grid, isVisited, directions, totalFoodItems, person_x, person_y, 0);
		
		return shortestPath;
	}

	private void findShortestPathInGrid(String[][] grid, boolean[][] isVisited, int[][] directions,
			int totalFoodItems, int i, int j, int path) {
		
		System.out.println("Now I am at position : " + i + ", " + j);

		if (grid[i][j].equals("#")) {
			totalFoodItems--;

			if (totalFoodItems == 0) {

				// Check the length of path
				// If its the shortest path then update it.
				if (path < shortestPath) {
					shortestPath = path;
				}
				return;
			}
		}

		for (int[] dir : directions) {

			// While standing at the location (i,j),
			// get the coordinates of the next direction where I will be moving
			int x = dir[0];
			int y = dir[1];

			// Check if I can move to that particular direction
			// If yes, then just move there
			// If no, then go back and go to next coordinate
			
			System.out.print("Checking if I can move to the location : " + (i + x) + ", " + (j + y));
			
			if (isValid(grid, i + x, j + y) && !blocked(grid, i + x, j + y) && !isVisited[i + x][j + y]) {
				
				System.out.println(" ==> Yes");

				i = i + x;
				j = j + y;
				
				// Mark the current location to be visited so that I can keep track of where I am coming from.
				isVisited[i][j] = true;
				
				// Increment the path by 1
				path++;
				
				System.out.println("Length of path traversed : " + path);
				
				findShortestPathInGrid(grid, isVisited, directions, totalFoodItems, i, j, path);
				System.out.println("I am back at the location : " + i + ", " + j);
				System.out.println("Length of path traversed : " + path);
			} else {
				System.out.println(" ==> No");
			}			
		}
		
		System.out.println("Going back to the location : " + i + ", " + j);
		
		isVisited[i][j] = false;
		
		if (grid[i][j].equals("#")) {
			totalFoodItems++;
		}
	}

	private boolean blocked(String[][] m, int i, int j) {
		return (i >= 0 && i < m.length && j >= 0 && j < m[0].length && m[i][j] == "X");
	}

	private boolean isValid(String[][] m, int i, int j) {
		return (i >= 0 && i < m.length && j >= 0 && j < m[0].length);
	}

}
