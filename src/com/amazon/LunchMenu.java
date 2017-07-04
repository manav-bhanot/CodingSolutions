/**
 * 
 */
package com.amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Manav
 * 
 *         Edward is organizing a meeting and has to order lunch for everyone in
 *         the team. To make the task simpler, he has prepared two lists. The
 *         first list has pairs of team members and their preferred cuisine
 *         types. Each team member either has a preference for a particular
 *         cuisine or does not have any particular preference and likes all
 *         cuisines. The second one contains a list of lunch options along with
 *         the cuisine type to which it belongs. Each lunch option belongs to
 *         only one cuisine type.
 * 
 *         Write an algorithm that outputs a list of all possible pairs of team
 *         members along with lunch option they would enjoy. There can be no,
 *         one or more entries for a team member in the output list depending on
 *         how many lunch options satisfy their choice of cuisine(s).
 * 
 *         The input to the function consists of four arguments - lunchMenuPairs
 *         -> representing a list containing pairs of lunch option and its
 *         associated cuisine type. teamCuisinePreference -> representing a list
 *         containing pairs of team members and their cuisine preferences.
 * 
 *         Output a list representing all possible pairs of team members and
 *         lunch options they would enjoy.
 * 
 *         NOTE : If a team member has no particular preference and likes all
 *         cuisines, then the preference is specified as a " * " in the team
 *         cuisine preference list. Order of the rows in the returned list does
 *         not matter.
 * 
 *         Input : lunchMenuPairs: [[Pizza, Italian], [Curry, Indian], [Masala,
 *         Indian]]
 * 
 *         teamCuisinePreferenc: [[Jose, Italian], [John, Indian], [Sarah,
 *         Thai], [Mary, *]]
 * 
 *         Output: [[John, Curry], [John, Masala], [Jose, Pizza], [Mary, Curry],
 *         [Mary, Masala], [Mary, Pizza]]
 * 
 * 
 *
 */
public class LunchMenu {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String[][] lunchMenuPairsArray = new String[][] { { "Pizza", "Italian" }, { "Curry", "Indian" },
				{ "Masala", "Indian" } };
		String[][] teamCuisinePrefArray = new String[][] { { "Jose", "Italian" }, { "John", "Indian" },
				{ "Sarah", "Thai" }, { "Mary", "*" } };

		List<List<String>> lunchMenuPairs = new ArrayList<List<String>>();
		List<List<String>> teamCuisinePairs = new ArrayList<List<String>>();

		for (int i = 0; i < lunchMenuPairsArray.length; i++) {

			List<String> pair = new ArrayList<String>();
			pair.add(lunchMenuPairsArray[i][0]);
			pair.add(lunchMenuPairsArray[i][1]);

			lunchMenuPairs.add(pair);
		}

		for (int i = 0; i < teamCuisinePrefArray.length; i++) {

			List<String> pair = new ArrayList<String>();
			pair.add(teamCuisinePrefArray[i][0]);
			pair.add(teamCuisinePrefArray[i][1]);

			teamCuisinePairs.add(pair);
		}

		printAllMatches(lunchMenuPairs, teamCuisinePairs);
	}

	private static void printAllMatches(List<List<String>> lunchMenuPairs, List<List<String>> teamCuisinePairs) {

		Map<String, List<String>> menuCard = new HashMap<String, List<String>>();

		for (List<String> cuisineFoodItemPair : lunchMenuPairs) {

			String cuisine = cuisineFoodItemPair.get(1);
			String foodItem = cuisineFoodItemPair.get(0);

			if (!menuCard.containsKey(cuisine)) {
				menuCard.put(cuisine, new ArrayList<String>());
			}
			menuCard.get(cuisine).add(foodItem);
		}

		List<List<String>> teamAndFoodItemsCombinations = new ArrayList<List<String>>();

		for (List<String> cuisineGuestPair : teamCuisinePairs) {

			String name = cuisineGuestPair.get(0);
			String cuisine = cuisineGuestPair.get(1);
			
			List<String> pairs = null;

			if (menuCard.containsKey(cuisine)) {
				
				for (String foodItem : menuCard.get(cuisine)) {
					pairs = new ArrayList<String>();
					pairs.add(name);
					pairs.add(foodItem);
					teamAndFoodItemsCombinations.add(pairs);
				}
				
			} else if (cuisine.equals("*")) {
				
				for (List<String> foodItems : menuCard.values()) {
					
					for (String foodItem : foodItems) {
						pairs = new ArrayList<String>();
						pairs.add(name);
						pairs.add(foodItem);
						teamAndFoodItemsCombinations.add(pairs);
					}
				}				
			}
		}
		
		printList(teamAndFoodItemsCombinations);
	}

	private static void printList(List<List<String>> teamAndFoodItemsCombinations) {
		
		for (List<String> guestCuisinePair : teamAndFoodItemsCombinations) {
			System.out.println(guestCuisinePair.get(0) + " : " + guestCuisinePair.get(1));
		}
		
	}
}
