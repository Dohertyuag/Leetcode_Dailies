package November;

import java.util.Stack;

/*
A fancy string is a string where no three consecutive characters are equal.

Given a string s, delete the minimum possible number of characters from s to make it fancy.

Return the final string after the deletion. It can be shown that the answer will always be unique.



Example 1:

Input: s = "leeetcode"
Output: "leetcode"
Explanation:
Remove an 'e' from the first group of 'e's to create "leetcode".
No three consecutive characters are equal, so return "leetcode".
Example 2:

Input: s = "aaabaaaa"
Output: "aabaa"
Explanation:
Remove an 'a' from the first group of 'a's to create "aabaaaa".
Remove two 'a's from the second group of 'a's to create "aabaa".
No three consecutive characters are equal, so return "aabaa".
Example 3:

Input: s = "aab"
Output: "aab"
Explanation: No three consecutive characters are equal, so return "aab".


Constraints:

1 <= s.length <= 10^5
s consists only of lowercase English letters.
 */
public class Delete_Characters_to_Make_Fancy_String {
    public String makeFancyString(String s) {
        System.out.println("String: " + s);
        if (s.length() < 3) return s;

        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            int n = sb.length();
            if (n < 2 || !(sb.charAt(n - 1) == c && sb.charAt(n - 2) == c)) {
                sb.append(c);
            }
        }

        return sb.toString();

    }

    public void driver() {
        String[] data = {"leeetcode", "aaabaaaa", "aab", "leeetcodeeeeeeeeeeeeeeeeeeeeeedddddddddddddddddddddd", "aaabaaaahgdkjzgfbdsjlhzvbldjfvhjjjjjjjjjjjjjjjjjjjjjjjjjgzzzzzzzzzzzzzzzzzzzzzzcbvhgvhgvkhgkvhgvkhgvhgkvkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkvvvvvvvvvvvvvvvvvvvvvvvvvvvvggggggggggggggggggffffffffffffffffffffffdddddddddddddddddddddddddddffffffffffffffffffffffffffffffffgggggggggggggggggggggggggggccccccccccccccccccccccccfffffffffffffffffffffdddddddddddddddfgjdhdhgfghfhjgfjhgfhgfhgggggggggggggggggggggggggggggggggggffdddddddddddddxcccccccccccccccccccccxxxxxxxxxxxxxxxxxxxxxxxxxxxxxzzzzzzzzzzzzzzzzzzzzzzzzsssssssssssssssssssssssssswwwwwwwwwwwwwwwwwdfffdfdgfdgfdgfghfhgfhgfhghgfhgfhghgfhghfhgfhgfhgfgfhgfhgfhgfhghfhgfhgfhghfhgfjhjfhjgfjhgfjhgjfcjgfcjgfxjgxdfdfxgcvvcxvcxvcxdxfdxfgdgfdcgfhgfhgvhg", "aab", "a"};

        for (String str : data) {
            System.out.println("Result: " + makeFancyString(str));
        }
    }


}
