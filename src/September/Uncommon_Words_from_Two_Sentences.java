package September;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

/*
A sentence is a string of single-space separated words where each word consists only of lowercase letters.

A word is uncommon if it appears exactly once in one of the sentences, and does not appear in the other sentence.

Given two sentences s1 and s2, return a list of all the uncommon words. You may return the answer in any order.

Example 1:

Input: s1 = "this apple is sweet", s2 = "this apple is sour"

Output: ["sweet","sour"]

Explanation:

The word "sweet" appears only in s1, while the word "sour" appears only in s2.

Example 2:

Input: s1 = "apple apple", s2 = "banana"

Output: ["banana"]
 */
public class Uncommon_Words_from_Two_Sentences {
    public String[] uncommonFromSentences(String string1, String string2) {
        Map<String, Integer> string_map = new HashMap<>();

        String[] s1 = string1.split(" ");
        String[] s2 = string2.split(" ");


        for (String str : s1) {
            string_map.put(str, string_map.getOrDefault(str, 0) + 1);
        }
        for (String str : s2) {
            string_map.put(str, string_map.getOrDefault(str, 0) + 1);
        }
        ArrayList<String> res = new ArrayList<>();
        for (String str : string_map.keySet()) {
            if (string_map.get(str) == 1) {
                res.add(str);
            }
        }
        System.out.println(res);
        return res.toArray(new String[0]);
    }

    public void driver() {
        String[] strings = {"this apple is sweet", "this apple is sour", "apple apple", "banana"};
        for (int i = 0; i < strings.length; i += 2) {
            uncommonFromSentences(strings[i], strings[i + 1]);
        }

    }
}
