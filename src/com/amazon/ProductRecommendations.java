/**
 * 
 */
package com.amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * @author Manav
 * 
 * Amazon wants to improve recommendation of the items for the customers by using customers's purchase information.
 * Based on historical customer purchase information an item association is defined as, 
 * if a given item A is ordered by a customer, the item B is also likely to be ordered by the customer (e.g. Harry
 * Potter 1 is frequently ordered with Harry Potter 2). All items that are linked together by item association can be
 * considered to be in the same item association group. An item without item association to any other group
 * can be considered to be in its own item association group of size 1.
 * 
 * Given a list of item association relationships, write an algorithm that outputs the largest item association group.
 * If two groups have the same number of items then select the group which contains the item that appears first (in ascending 
 * order) in lexicographic order
 * 
 * Input to the program consists of an argument - itemAssociation, a list of containing  pairs of items that are ordered together
 * 
 * Output is a list representing the largest item Association Group.
 * 
 * Input :
 * 	itemAssociation :
 * 		[ [Item1, Item2],
 * 		  [Item3, Item4],
 * 		  [Item4, Item5] ]
 * 
 * Output :
 * 	[Item3, Item4, Item5]
 *
 */
public class ProductRecommendations {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String[][] inputs = new String[][] {
			{"Item1", "Item2"},
			{"Item3", "Item4"},
			{"Item4", "Item5"}
		};
		
		List<List<String>> itemAssociation = new ArrayList<List<String>>();
		
		for (int i = 0; i < inputs.length; i++) {
			
			List<String> itemPair = new ArrayList<String>();
			itemPair.add(inputs[i][0]);
			itemPair.add(inputs[i][1]);
			
			itemAssociation.add(itemPair);			
		}
		
		for (String items : findLargestAssociationGroup(itemAssociation)) {
			System.out.print(items + " ");
		}
		
		
	}
	
	public static List<String> findLargestAssociationGroup(List<List<String>> itemAssociation) {
		
		Map<String, SortedSet<String>> map = new HashMap<String, SortedSet<String>>();
		
		for (List<String> pair : itemAssociation) {
			
			String item1 = pair.get(0);
			String item2 = pair.get(1);
			
			String item1_parent = "";
			String item2_parent = "";
			
			// Check if any item from this pair already belongs to a set
			for (String key : map.keySet()) {
				
				if (map.get(key).contains(item1)) {
					item1_parent = key;
				}
				
				if (map.get(key).contains(item2)) {
					item2_parent = key;
				}				
			}
			
			// Merge the two sets or add the unidentified item in the corresponding set or create a new set containing 2 new items
			
			if (item1_parent.equals("") && item2_parent.equals("")) {
				
				map.put(item1, new TreeSet<String>());
				map.get(item1).add(item1);
				map.get(item1).add(item2);
				
			} else if (!item1_parent.equals("") && !item2_parent.equals("")) {
				
				if (map.get(item1_parent).size() > map.get(item2_parent).size()) {
					map.get(item1_parent).addAll(map.get(item2_parent));
					map.remove(item2_parent);
				} else {
					map.get(item2_parent).addAll(map.get(item1_parent));
					map.remove(item1_parent);
				}				
			} else {
				
				if (item1_parent.equals("")) {
					
					// Add item1 to item2's set
					map.get(item2_parent).add(item1);					
					
				} else if (item2_parent.equals("")) {
					map.get(item1_parent).add(item2);	
				}
				
			}
		}
		
		// Now iterate the disjoint sets created here and find the largest set
		// If two sets have the same size then select the set whose 1st item is lexicographically smaller than the 1st item of other set
		
		List<String> result = new ArrayList<String>();
		int maxSize = Integer.MIN_VALUE;
		
		for (SortedSet<String> set : map.values()) {			
			if (set.size() > maxSize) {				
				result.clear();
				result.addAll(set);
			} else if (set.size() == maxSize) {				
				if (set.first().compareTo(result.get(0)) == -1) {
					result.clear();
					result.addAll(set);
				}				
			}

			maxSize = result.size();
		}		
		return result;		
	}

}
