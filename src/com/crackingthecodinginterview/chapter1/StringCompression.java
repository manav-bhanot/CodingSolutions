package com.crackingthecodinginterview.chapter1;

import java.util.List;

/**
 * Implement a method to perform basic string compression using the counts
 * of repeated characters. For example, the string aabcccccaaa would become a2b1c5a3. If the
 * "compressed" string would not become smaller than the original string, your method should return
 * the original string. You can assume the string has only uppercase and lowercase letters (a - z).
 */
public class StringCompression {

    public static void main(String[] args) {
        for (String s : testStrings()) {
            System.out.println("Input String: " + s + " :: Compressed String : " + compressString(s));
        }
    }

    private static String compressString(String inputString) {

        StringBuilder compressedStringBuilder = new StringBuilder();

        int count = 0;
        int compressedStringLength = 0;

        int charIndex = 0;

        do {
            if (charIndex + 1 < inputString.length() && inputString.charAt(charIndex) == inputString.charAt(charIndex + 1)) {
                count++;
            } else {
                compressedStringBuilder
                        .append(inputString.charAt(charIndex))
                        .append(++count);
                count = 0;

                compressedStringLength += Integer.toString(count).length() + 1;
                if (compressedStringLength > inputString.length()) {
                    return inputString;
                }
            }
            charIndex++;
        } while (charIndex < inputString.length());

        return compressedStringBuilder.toString();
    }

    private static List<String> testStrings() {
        return List.of(
                "aabcccccaaa",
                "aaaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbbbbbbccccccccaaaaaaaaaaaaaddddddddddd",
                "abcdefghijklmnopqrstuvwxyz",
                "aaaaabbbbbcccccddddde",
                "abbbcccdddeee"
        );
    }
}
