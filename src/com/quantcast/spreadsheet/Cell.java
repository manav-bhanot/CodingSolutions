/**
 * 
 */
package com.quantcast.spreadsheet;

import java.util.Stack;

/**
 * @author Manav
 * 
 *         Class that represents each cell of the spreadsheet
 */

public class Cell {

	boolean isExpressionUnderEvaluation, isNumericValue;

	Integer rowIdx, colIdx;

	Float numericValue;
	String cellName, textValue, expr;

	/*
	 * Default Constructor
	 */
	public Cell() {
	}

	/**
	 * 
	 * @param textValue
	 * @param rowIdx
	 * @param colIdx
	 */
	public Cell(String textValue, int rowIdx, int colIdx) {
		this.textValue = textValue;
		this.rowIdx = rowIdx;
		this.colIdx = colIdx;

		this.cellName = "" + ((char) ('A' + rowIdx)) + (colIdx + 1);
		this.expr = textValue;

		this.isNumericValue = this.hasANumericValue();
	}

	/**
	 * Evaluates the RPN formula in this cell
	 * If the textValue has already been calculated for this cell, then return the
	 * calculated textValue
	 * 
	 * @param cell
	 * @throws CyclicDependencyException
	 */
	public Float evaluate(Cell[][] sheet) throws CyclicDependencyException {

		// BASE CASE
		// Return if this cell already has a numeric value (either calculated or taken as initial input)
		if (this.isNumericValue) {
			return this.numericValue;
		}

		// If this cell's expression is already under evaluation
		// and it has been referred by another cell whose textValue is dependent on this
		// cell
		// then we have detected a cyclic dependency and hence we need to throw the
		// exception
		if (this.isExpressionUnderEvaluation) {
			throw new CyclicDependencyException("ALERT! Cyclic dependency found while evaluating the expression { "
					+ this.expr + " } inside the cell : " + this.cellName
					+ "\nCheck the below cell evaluation flow to resolve it");
		}

		// Checks if this cell has already been evaluated and contains the textValue
		// If not, only then go inside and evaluate
		// Else return back to the caller and use this cell's textValue

		// Go ahead and evaluate the expression
		this.isExpressionUnderEvaluation = true;

		// Now we are evaluating the RPN expression using a Stack
		Stack<Float> operands = new Stack<Float>();
		Float num1 = null, num2 = null;
		
		for (String t : this.expr.split(" +")) {
			
			switch (t.trim()) {

			case "+":
				num2 = operands.pop();
				num1 = operands.pop();
				operands.push(num1 + num2);
				break;

			case "-":
				num2 = operands.pop();
				num1 = operands.pop();
				operands.push(num1 - num2);
				break;

			case "*":
				num2 = operands.pop();
				num1 = operands.pop();
				operands.push(num1 * num2);
				break;

			case "/":
				num2 = operands.pop();
				num1 = operands.pop();
				operands.push(num1 / num2);
				break;

			default:
				// Since the program execution has reached the default block
				// This means that this particular token in the expression is a number
				// Or a reference to another cell

				// If it is a number, then push this number on the top of the stack
				// Else if its a reference to another cell, call this method recursively
				// till we find the numericValue of this cell's expression which is required by
				// the operator following this token

				Float val = null;
				try {

					// If this is actually a numeric value then go ahead and assign it to val
					val = Float.parseFloat(t);
				} catch (NumberFormatException ex) {

					// The current token is a reference to some other cell in the spreadsheet
					// Find that cell and get the numeric value of that cell
					int[] cellLoc = this.calculateLocation(t);
					Cell referredCell = sheet[cellLoc[0]][cellLoc[1]];

					// Recursively call referred cell and evaluate it
					try {
						val = referredCell.evaluate(sheet);
					} catch (CyclicDependencyException cyclicDepEx) {

						// Add the current cell to the arraylist of this cyclic dependency exception.
						cyclicDepEx.cyclicDependency.add(this.cellName);

						// Throw the exception further to its caller
						throw cyclicDepEx;
					}
				}
				operands.push(val);
			}
		}
		// Set the calculated cell's numericValue so as to avoid future calculations
		// Set the flag so that further cells could know that this cell now has a
		// numeric value now
		this.numericValue = operands.pop();
		this.isNumericValue = true;
		this.isExpressionUnderEvaluation = false;
		
		return this.numericValue;
	}

	public int[] calculateLocation(String token) {

		// Assuming that the spreadsheet rows are between 'A' to 'Z'
		// we need to take only the first character to calculate the row
		this.rowIdx = token.charAt(0) - 'A';

		// To calculate the column we need to take the entire substring excluding the
		// first character
		// and parse it into an integer.
		this.colIdx = Integer.parseInt(token.substring(1));

		return new int[] { this.rowIdx, this.colIdx - 1 };
	}

	/**
	 * 
	 * @return
	 */
	public String getFormattedValue() {
		return String.format("%.5f", this.getNumericValue());
	}

	/**
	 * 
	 * @return
	 */
	public Float getNumericValue() {
		return this.numericValue;
	}

	/**
	 * 
	 * @return
	 */
	private boolean hasANumericValue() {

		// Checks the expr value using a regex
		if (this.expr.matches("^-?[0-9]\\d*(\\.\\d+)?$")) {

			// This expression is actually a number and hence we have got the numeric value
			// of this cell
			this.numericValue = Float.parseFloat(this.expr);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String toString() {
		return this.cellName + ", " + this.textValue;
	}
}
