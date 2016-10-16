package com.internetbrands;

import java.util.HashMap;
import java.util.Map;

public class Gemstones {

	static int gemstones(String[] rocks) {
		int totalGemstones = 0;

		Map<Character, Integer> stones = new HashMap<Character, Integer>();

		for (int i = 0; i < rocks.length; i++) {
			String rock = rocks[i];

			for (char stone : rock.toCharArray()) {

				if (stones.get(stone) == null) {
					stones.put(stone, 1);
				}
				if (stones.get(stone) != null) {
					if (stones.get(stone) == i+1) {
						continue;
					} else {
						stones.put(stone, stones.get(stone) + 1);
					}					
				}
				if (stones.get(stone) >= rocks.length) {
					totalGemstones++;
				}
			}			
		}
		return totalGemstones;
	}

	public static void main(String[] args) {
		String[] rocks = new String[] { "abcdde", "baccd", "eeabg" };
		System.out.println(gemstones(rocks));
	}

}
