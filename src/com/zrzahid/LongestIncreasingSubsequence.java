/**
 * 
 */
package com.zrzahid;

/**
 * @author Manav
 *
 */
public class LongestIncreasingSubsequence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int[] arr = new int[] {3,1,5,2,6,4,9};		
		findLongestIncreasingSubsequence(arr);
		
		arr = new int[] {0,8,4,12,2,10,6,14,1,9,5,13,3,11,7,15};		
		findLongestIncreasingSubsequence(arr);
		
		arr = new int[] {10,9,2,5,3,4};		
		findLongestIncreasingSubsequence(arr);
	}

	private static void findLongestIncreasingSubsequence(int[] arr) {
		
		int[] endElements = new int[arr.length];
		int[] parent = new int[arr.length + 1];
		int length = 0;
		
		endElements[0] = arr[0];
		length++;
		
		// Traverse the array
		for (int idx = 1; idx < arr.length; idx++) {
			
			// If the current element of the array is greater than
			// all the end elements, then append it and increase the 
			// length of lis by 1
			if (arr[idx] > endElements[length - 1]) {
				
				// Append this element in the endElements array
				endElements[length] = arr[idx];
				
				// Update the parent array
				// parent[idx] =  
				length++;
				
			} else {
				// Find the index of that element
				// in the endElements array which is greater than
				// the element arr[idx] and replace it with arr[idx]
				
				int low = -1;
				int high = length - 1;
				
				while (high - low > 1) {
					int mid = low + (high - low)/2;
					
					if (endElements[mid] < arr[idx]) {
						// Move right
						low = mid;
					} else {
						// Move left
						high = mid;
					}
				}
				
				int pos = high;
				
				// Update the endElements array
				endElements[pos] = arr[idx];
				
				// Update the parent array
				// parent[idx] = ;
			}
		}
		System.out.println("Length of longest increasing subsequence found = " + length);
		
		/*System.out.println("Printing the longest increasing subsequence now");
		
		int lis[] = new int[length];
		int k = endElements[length];
		
		for (int i = length - 1; i >= 0; i--) {
			lis[i] = arr[k];
			k = parent[k];
		}
		
		for (int i = 0; i < lis.length; i++) {
			System.out.print(lis[i] + " ");
		}*/
	}
}
