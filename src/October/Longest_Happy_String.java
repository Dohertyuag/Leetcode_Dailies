package October;

/*
A string s is called happy if it satisfies the following conditions:

s only contains the letters 'a', 'b', and 'c'.
s does not contain any of "aaa", "bbb", or "ccc" as a substring.
s contains at most a occurrences of the letter 'a'.
s contains at most b occurrences of the letter 'b'.
s contains at most c occurrences of the letter 'c'.
Given three integers a, b, and c, return the longest possible happy string. If there are multiple longest happy strings, return any of them. If there is no such string, return the empty string "".

A substring is a contiguous sequence of characters within a string.



Example 1:

Input: a = 1, b = 1, c = 7
Output: "ccaccbcc"
Explanation: "ccbccacc" would also be a correct answer.
Example 2:

Input: a = 7, b = 1, c = 0
Output: "aabaa"
Explanation: It is the only correct answer in this case.


Constraints:

0 <= a, b, c <= 100
a + b + c > 0
 */
public class Longest_Happy_String {
    public String longestDiverseString(int a, int b, int c) {
        int total = a + b + c;
        int count_a = 0, count_b = 0, count_c = 0;
        StringBuilder str = new StringBuilder();

        System.out.println("a: " + a + ", b: " + b + ", c: " + c );

        while(total-- > 0){
            if((a >=b && a >= c && count_a != 2) || (a > 0 && (count_b == 2 || count_c == 2))){
                str.append('a');
                count_a++;
                a--;
                count_b = count_c = 0;
            }
            else if((b >= c && b >= a && count_b != 2) || (b > 0 && (count_a == 2 || count_c == 2))){
                str.append('b');
                count_b++;
                b--;
                count_a = count_c = 0;
            }
            else if((c >= a && c >= b && count_c != 2) || (c > 0 && (count_a == 2 || count_b == 2))){
                str.append('c');
                count_c++;
                c--;
                count_a = count_b = 0;
            }
        }
        System.out.println(str);

        return str.toString();
    }

    public void driver() {
        int[] data = {1, 1, 7, 7, 1, 0};

        for (int i = 0; i < data.length; i+=3) {
            System.out.println("Result: " + longestDiverseString(data[i], data[i+1], data[i+2]));
        }
    }
}
