package com.crackingthecodinginterview.chapter1;

public class ReplaceSpacesInString {

	public static void main(String[] args) {

		String str = "Aastha is a good girl";

		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ' ') {
				str = str.substring(0, i) + "%20" + str.substring(i + 1, str.length());
				System.out.println(str);
			}
		}
	}
}
