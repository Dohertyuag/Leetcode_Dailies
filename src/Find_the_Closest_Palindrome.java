import java.util.Arrays;
import java.util.Collection;

/*
Given a string n representing an integer, return the closest integer (not including itself), which is a palindrome. If there is a tie, return the smaller one.

The closest is defined as the absolute difference minimized between two integers.

Example 1:
Input: n = "123"
Output: "121"

Example 2:
Input: n = "1"
Output: "0"
Explanation: 0 and 2 are the closest palindromes but we return the smallest which is 0.

Constraints:
        1 <= n.length <= 18
n consists of only digits.
n does not have leading zeros.
n is representing an integer in the range [1, 1018 - 1].
*/
public class Find_the_Closest_Palindrome {
    public String nearestPalindromic(String n) {
        int l = n.length();
        boolean foundPalindrome = false;

        long originalNum = Long.parseLong(n);
        long checkUpper = originalNum + 1;
        long checkLower = originalNum - 1;
        long ans = 0;

        while(!foundPalindrome){
            foundPalindrome = checkPalindrome(String.valueOf(checkLower));
            ans = checkLower;
            checkLower--;
            if(foundPalindrome) break;

            foundPalindrome = checkPalindrome(String.valueOf(checkUpper));
            ans = checkUpper;
            checkUpper++;

        }
        return Long.toString(ans);
    }
    public boolean checkPalindrome(String str) {
        int len = str.length();
        for (int i = 0; i < len / 2; i++) {
            if (str.charAt(i) != str.charAt(len - i - 1))
                return false;
        }
        return true;
    }
}
//807045053350540708