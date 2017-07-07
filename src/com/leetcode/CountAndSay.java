/**
 * 
 */
package com.leetcode;

/**
 * @author Manav
 * 
 *         src : https://leetcode.com/problems/count-and-say/#/description
 * 
 *         The count-and-say sequence is the sequence of integers with the first
 *         five terms as following:
 * 
 *         1. 1
 *         2. 11
 *         3. 21
 *         4. 1211
 *         5. 111221
 *         6. 312211
 *         7. 13112221
 *         8. 1113213211
 *         9. 31131211131221
 * 
 *         1 is read off as "one 1" or 11. 
 *         11 is read off as "two 1s" or 21. 
 *         21 is read off as "one 2, then one 1" or 1211. 
 *         Given an integer n, generate the nth term of the count-and-say sequence.
 * 
 *         Note: Each term of the sequence of integers will be represented as a
 *         string.
 * 
 *         Example 1:
 * 
 *         Input: 1 Output: "1" Example 2:
 * 
 *         Input: 4 Output: "1211" 
 */
public class CountAndSay {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CountAndSay obj = new CountAndSay();
		System.out.println(obj.countAndSay(9));
	}

	public String countAndSay(int n) {
		StringBuilder seq = new StringBuilder();

		seq.append("1");
		n--;

		while (n > 0) {

			for (int i = 0; i < seq.length(); i++) {
				int countNum = 0;
				int num = Integer.parseInt("" + seq.charAt(i));
				int start = i;
				while (i < seq.length() && Integer.parseInt("" + seq.charAt(i)) == num) {
					countNum++;
					i++;
				}
				seq.delete(start, i);
				String s = "" + countNum + num;
				seq.insert(start, s);

				i = start + s.length() - 1;
			}
			n--;
		}

		return seq.toString();
	}

}
