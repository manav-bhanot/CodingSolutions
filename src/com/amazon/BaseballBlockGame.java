/**
 * 
 */
package com.amazon;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Manav
 * 
 *         John plays a game in which he throws a baseball at various blocks
 *         marked with a symbol so as to knock these out. The score is computed
 *         for each throw. The last score is the score of previous throw. The
 *         total score is the sum of all the last throws The symbol on a block
 *         can be an integer, a sign or a letter. Each method depicts a special
 *         rule as given below
 * 
 *         1. If a throw hits a block marked with an INTEGER, the textValue of the
 *         INTEGER is added to the total score 2. If a throw hits a block marked
 *         with an 'X', the last score is doubled and added to the total score.
 *         3. If a throw hits a block marked with a +, the last two scores are
 *         added and then added to the total scores. 4. If a throw hits a block
 *         marked with a 'Z', the last score is removed from the total score.
 * 
 *         Write an algorithm to compute the total score for a given list of
 *         ordered hits by John. The input to the function consists of two
 *         arguments - blocks, representing a list of symbols and n,
 *         representing the number of strings in the list. Input: blocks = <
 *         5,-2,4,Z,X,9,+,+ > n = 4 Output: 27
 * 
 */
public class BaseballBlockGame {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String[] input = new String[] { "5", "-2", "4", "Z", "X", "9", "+", "+" };
		findScore(input);
	}

	private static void findScore(String[] input) {

		List<Integer> scores = new ArrayList<Integer>();
		int totalScore = 0;

		for (int i = 0; i < input.length; i++) {

			int score = 0;
			
			try {
				score = Integer.parseInt(input[i]);
				scores.add(score);

			} catch (NumberFormatException ex) {

				if (scores.isEmpty()) {
					continue;
				} else {
					
					switch (input[i]) {

					case "X":
						score = scores.get(scores.size() - 1) * 2;
						scores.add(score);
						break;

					case "Z":
						score = -scores.remove(scores.size() - 1);						
						break;

					case "+":
						score = scores.get(scores.size() - 1) + scores.get(scores.size() - 2);
						scores.add(score);
						break;
					}
				}
			}
			totalScore += score;
		}
		System.out.println(totalScore);
	}

}
