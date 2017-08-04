/**
 * 
 */
package com.zrzahid;

import java.util.Stack;

/**
 * @author Manav
 * 
 *         A celebrity/influencer is a person who doesn’t know anybody but is
 *         known to or followed by everybody. Given N peoples and a matrix for
 *         known or following information then find the celebrity or influencer
 *         among the group of N peoples.
 *         Given a matrix of following between N users (with ids from 0 to N-1):
 *         following[i][j] == true iff user i is following user j
 *         thus following[i][j] doesn’t imply following[j][i].
 *         Let’s also agree that followingMatrix[i][i] == false
 *
 *         Influencer is a user who is:
 *         – followed by everyone else and
 *         – not following anyone himself
 *
 *         Find an Influencer by a given matrix of following,
 *         or return -1 if there is no Influencer in this group.
 *
 */
public class FindInfluencerOrCelebrity {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int n = 5;

		int[][] following = new int[n][n];

		following[0][3] = 1;
		following[0][1] = 1;
		following[1][3] = 1;
		following[1][0] = 1;
		following[1][4] = 1;
		following[4][3] = 1;
		following[2][3] = 1;
		following[2][4] = 1;

		int celebrity = findCelebrityUsingStack(following);
		System.out.println("Celebrity found using Stack = " + celebrity);

		celebrity = findCelebrityUsingTwoPointers(following);
		System.out.println("Celebrity found using 2 pointers approach = " + celebrity);

	}

	/**
	 * 
	 * @param following
	 * @return
	 */
	private static int findCelebrityUsingTwoPointers(int[][] following) {

		int left = 0, right = following.length - 1;
		int potentialCeleb = -1;

		while (left < right) {

			// If left is following right. Then left is definitely not a celebrity 
			// and right might be a celebrity. So we advance left pointer
			// and check the next person with the current right
			if (following[left][right] == 1) {
				// Right might be a celebrity
				left++;
			} else {
				// left might be a celebrity
				right--;
			}
		}

		potentialCeleb = left;
		
		// Check if this is actually the celebrity
		for (int i = 0; i < following.length; i++) {
			if (i == potentialCeleb)
				continue;
			if (following[i][potentialCeleb] == 0 || following[potentialCeleb][i] == 1) {
				return -1;
			}
		}

		return potentialCeleb;
	}

	/**
	 * 
	 * Approach using stack
	 * 
	 * @param following
	 * @return
	 */
	private static int findCelebrityUsingStack(int[][] following) {

		Stack<Integer> stack = new Stack<Integer>();

		for (int i = 0; i < following.length; i++) {
			stack.push(i);
		}

		while (stack.size() > 1) {

			int p1 = stack.pop();
			int p2 = stack.pop();

			if (following[p1][p2] == 1) {
				// p1 cant be celebrity
				stack.push(p2);
			} else {
				// p2 can't be celebrity
				stack.push(p1);
			}
		}

		int celeb = stack.pop();
		// System.out.println(celeb);

		// Check if this is actually the celebrity
		for (int i = 0; i < following.length; i++) {
			if (i == celeb)
				continue;
			if (following[i][celeb] == 0 || following[celeb][i] == 1) {
				return -1;
			}
		}

		return celeb;
	}

}
