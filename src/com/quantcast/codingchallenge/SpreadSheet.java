/**
 * 
 */
package com.quantcast.codingchallenge;

import java.util.Scanner;

/**
 * @author Manav
 *
 */
public class SpreadSheet {

	Cell[][] spreadsheet;
	int rows, cols;

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		SpreadSheet obj = new SpreadSheet();

		// Take Data from stdin
		Scanner scan = new Scanner(System.in);

		// Take the dimensions of the spreadsheet
		obj.cols = scan.nextInt();
		obj.rows = scan.nextInt();
		scan.nextLine();

		// Initiate the size of the spreadsheet		
		obj.spreadsheet = new Cell[obj.rows][obj.cols];

		// Fill the spreadsheet with the corresponding inputs
		// Inputs could be a textValue (an integer textValue) or an expression
		for (int r = 0; r < obj.rows; r++) {
			for (int c = 0; c < obj.cols; c++) {
				obj.spreadsheet[r][c] = new Cell(scan.nextLine(), r, c);
			}
		}

		try {
			// Evaluate the RPN formula in each cell of the spreadsheet
			obj.evaluateSpreadSheet();

			// Print the output on the console
			obj.printEvaluatedSpreadsheet();

		} catch (CyclicDependencyException excep) {

			// Report the cyclic dependency exception in a sensible manner
			System.out.println(excep.msg);

			for (int idx = excep.cyclicDependency.size() - 1; idx >= 0; idx--) {
				System.out.print(excep.cyclicDependency.get(idx) + " -> ");
			}
			System.out.print(excep.cyclicDependency.get(excep.cyclicDependency.size() - 1));

			// Exit the program with a non-zero exit code
			System.exit(-1);
		}
	}

	public void evaluateSpreadSheet() throws CyclicDependencyException {

		// Start evaluating the spreadsheet
		for (int rowIdx = 0; rowIdx < this.rows; rowIdx++) {
			for (int colIdx = 0; colIdx < this.cols; colIdx++) {

				Cell cell = this.spreadsheet[rowIdx][colIdx];

				// Check if the cells content is a number or an expression
				if (!cell.isNumericValue) {
					
					// Since cell's contents is a RPN expression, so lets evaluate it
					cell.evaluate(this.spreadsheet);
				}
			}
		}
	}

	/**
	 * Prints the whole spread sheet after every cell's textValue is found
	 */
	public void printEvaluatedSpreadsheet() {

		for (int r = 0; r < this.rows; r++) {
			for (int c = 0; c < this.cols; c++) {
				System.out.println(this.spreadsheet[r][c].getFormattedValue());
			}
		}
	}
}