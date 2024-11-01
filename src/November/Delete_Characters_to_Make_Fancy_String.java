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

        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        int counter = 1;
        char c = chars[0];
        stack.push(c);

        for (int i = 1; i < chars.length; i++) {
            if(chars[i] == stack.peek()){
                counter++;
                stack.push(chars[i]);
                if(counter > 2) stack.pop();
            }
            else {
                stack.push(chars[i]);
                counter = 1;
            }
        }
        System.out.println(stack);
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < stack.size(); i++) {
            sb.append(stack.get(i));
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
