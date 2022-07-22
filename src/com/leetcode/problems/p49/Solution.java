package com.leetcode.problems.p49;

import java.util.*;

/**
 * 49. Group Anagrams
 * https://leetcode.com/problems/group-anagrams/
 *
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 *
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 *
 *
 *
 * Example 1:
 *
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * Example 2:
 *
 * Input: strs = [""]
 * Output: [[""]]
 * Example 3:
 *
 * Input: strs = ["a"]
 * Output: [["a"]]
 *
 *
 * Constraints:
 *
 * 1 <= strs.length <= 104
 * 0 <= strs[i].length <= 100
 * strs[i] consists of lowercase English letters.
 *
 */
public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> anagramGroups = new HashMap<>();

        for (String str: strs) {
            String sortedStr = sortString(str);
            if (anagramGroups.containsKey(sortedStr)) {
                anagramGroups.get(sortedStr).add(str);
            } else {
                List<String> anagramGroup = new ArrayList();
                anagramGroup.add(str);
                anagramGroups.put(sortedStr, anagramGroup);
            }
        }

        List<List<String>> result = new ArrayList<>();
        for (List<String> group: anagramGroups.values()) {
            result.add(group);
        }

        return result;
    }

    private String sortString(String s) {
        char[] charsOfS = s.toCharArray();
        Arrays.sort(charsOfS);
        return new String(charsOfS);
    }
}
