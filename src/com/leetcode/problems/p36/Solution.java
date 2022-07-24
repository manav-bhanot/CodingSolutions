package com.leetcode.problems.p36;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 36. Valid Sudoku
 * https://leetcode.com/problems/valid-sudoku/
 *
 * Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
 *
 * Each row must contain the digits 1-9 without repetition.
 * Each column must contain the digits 1-9 without repetition.
 * Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 * Note:
 *
 * A Sudoku board (partially filled) could be valid but is not necessarily solvable.
 * Only the filled cells need to be validated according to the mentioned rules.
 *
 *
 * Example 1:
 *
 *
 * Input: board =
 * [["5","3",".",".","7",".",".",".","."]
 * ,["6",".",".","1","9","5",".",".","."]
 * ,[".","9","8",".",".",".",".","6","."]
 * ,["8",".",".",".","6",".",".",".","3"]
 * ,["4",".",".","8",".","3",".",".","1"]
 * ,["7",".",".",".","2",".",".",".","6"]
 * ,[".","6",".",".",".",".","2","8","."]
 * ,[".",".",".","4","1","9",".",".","5"]
 * ,[".",".",".",".","8",".",".","7","9"]]
 * Output: true
 * Example 2:
 *
 * Input: board =
 * [["8","3",".",".","7",".",".",".","."]
 * ,["6",".",".","1","9","5",".",".","."]
 * ,[".","9","8",".",".",".",".","6","."]
 * ,["8",".",".",".","6",".",".",".","3"]
 * ,["4",".",".","8",".","3",".",".","1"]
 * ,["7",".",".",".","2",".",".",".","6"]
 * ,[".","6",".",".",".",".","2","8","."]
 * ,[".",".",".","4","1","9",".",".","5"]
 * ,[".",".",".",".","8",".",".","7","9"]]
 * Output: false
 * Explanation: Same as Example 1, except with the 5 in the top left corner being modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.
 *
 *
 * Constraints:
 *
 * board.length == 9
 * board[i].length == 9
 * board[i][j] is a digit 1-9 or '.'.
 */
public class Solution {

    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> rowIndicesToElementsMap = new HashMap<>();
        Map<Integer, Set<Character>> columnIndicesToElementsMap = new HashMap();
        Map<Integer, Set<Character>> subSquareElementsMap = new HashMap();

        for (int row = 0; row < board.length; row++) {
            if (row % 3 == 0) {
                subSquareElementsMap.clear();
            }
            for (int col = 0; col < board[row].length; col++) {

                Set<Character> rowElements = rowIndicesToElementsMap.getOrDefault(row, new HashSet<>());
                Set<Character> colElements = columnIndicesToElementsMap.getOrDefault(col, new HashSet());

                Set<Character> subSquareElements = subSquareElementsMap.getOrDefault(col / 3, new HashSet());

                if (board[row][col] != '.') {
                    if (rowElements.contains(board[row][col]) || colElements.contains(board[row][col]) || subSquareElements.contains(board[row][col])) {
                        System.out.println(row + "," + col + " : " + board[row][col]);
                        return false;
                    }

                    rowElements.add(board[row][col]);
                    rowIndicesToElementsMap.put(row, rowElements);

                    colElements.add(board[row][col]);
                    columnIndicesToElementsMap.put(col, colElements);

                    subSquareElements.add(board[row][col]);
                    subSquareElementsMap.put(col / 3, subSquareElements);
                }
            }
        }
        return true;
    }
}
