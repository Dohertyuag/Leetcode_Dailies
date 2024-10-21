package October;

import java.util.HashSet;

/*
Given a string s, return the maximum number of unique substrings that the given string can be split into.

You can split string s into any list of non-empty substrings, where the concatenation of the substrings forms the original string. However, you must split the substrings such that all of them are unique.

A substring is a contiguous sequence of characters within a string.



Example 1:

Input: s = "ababccc"
Output: 5
Explanation: One way to split maximally is ['a', 'b', 'ab', 'c', 'cc']. Splitting like ['a', 'b', 'a', 'b', 'c', 'cc'] is not valid as you have 'a' and 'b' multiple times.
Example 2:

Input: s = "aba"
Output: 2
Explanation: One way to split maximally is ['a', 'ba'].
Example 3:

Input: s = "aa"
Output: 1
Explanation: It is impossible to split the string any further.


Constraints:

1 <= s.length <= 16

s contains only lower case English letters.
 */
public class Split_a_String_Into_the_Max_Number_of_Unique_Substrings {
    public int maxUniqueSplit(String s) {
        return backtrack(0, s, new HashSet<>());
    }

    private int backtrack(int index, String s, HashSet<String> set) {
        if (index == s.length()) {
            return 0;
        }

        int max = 0;
        for(int end = index + 1; end <= s.length(); end++) {
            String sub = s.substring(index, end);
            if(!set.contains(sub)) {
                set.add(sub);
                max = Math.max(max, 1 + backtrack(end, s, set));
                set.remove(sub);
            }
        }
        return max;

    }
    public void driver() {
        String[] str = {"ababccc", "aba", "aa", "dbbpaaaab", "aacaccckaaaaaa", "jnafaeffbehaif", "aaaaaaaaaaaaaaaa", "igppsagzepaaaaba", "lwaacaajuefdegb", "wwwzfvedwfvhsww", "eeajlaanlbeohbb"};
        for(String s : str) {
            System.out.println("Result: " + maxUniqueSplit(s));
        }
    }
}
