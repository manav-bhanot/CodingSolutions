/**
 * 
 */
package com.hackerrank.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Manav
 *
 */
public class Demo {

	// a single consonant
	private static final String c = "[^aeiou]";
	// a single vowel
	private static final String v = "[aeiouy]";

	// a sequence of consonants; the second/third/etc consonant cannot be 'y'
	private static final String C = c + "[^aeiouy]*";
	// a sequence of vowels; the second/third/etc cannot be 'y'
	private static final String V = v + "[aeiou]*";

	// this regex pattern tests if the token has measure > 0 [at least one VC].
	private static final Pattern mGr0 = Pattern.compile("^(" + C + ")?" + V + C);

	private static final Pattern quotes = Pattern.compile("^[\\w|\\W]*(\"[\\w|\\W|\\s]*\")[\\w|\\W]*$");

	private static final String specialCharsRegexStart = "^[^\\w]*";

	// Regex to remove the special chars from the end of the word
	private static final String specialCharsRegexEnd = "[^\\w]*$";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final String regex = "\\S+over\\b";
		final String string = "The \\\"quick brown fox\\\" jumpsoverjumpsover";

		final Pattern pattern = Pattern.compile(regex);
		final Matcher matcher = pattern.matcher(string);

		while (matcher.find()) {
			System.out.println("Full match: " + matcher.group(0));
			for (int i = 1; i <= matcher.groupCount(); i++) {
				System.out.println("Group " + i + ": " + matcher.group(i));
			}
		}
		/*
		 * String str = "The \"quick brown fox\" jumps over jumpsover"; Pattern
		 * quotes =
		 * Pattern.compile("^[\\w|\\W]*(\"[\\w|\\W|\\s]*\")[\\w|\\W]*$");
		 * 
		 * 
		 * Pattern startend = Pattern.compile("\\S+over\\b");
		 * 
		 * Matcher match = startend.matcher(str); if (match.matches()) {
		 * System.out.println(match.group()); System.out.println("Hi"); }
		 */

		/*
		 * Matcher matcher = quotes.matcher(str); if (matcher.matches()) {
		 * System.out.println(matcher.group(1)); }
		 */
		System.out.println(processWord("****", false));

	}

	public static String processWord(String word, boolean removeHyphens) {
		word = word.trim().replaceAll(specialCharsRegexStart, "").replaceAll(specialCharsRegexEnd, "").replaceAll("'",
				"");
		if (removeHyphens)
			word.replaceAll("-", "");
		return word.toLowerCase();
	}

}
