/**
 * 
 */
package com.leetcode;

/**
 * @author Manav
 *
 */
public class CountAndSay {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CountAndSay obj = new CountAndSay();
		System.out.println(obj.countAndSay(7));
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
