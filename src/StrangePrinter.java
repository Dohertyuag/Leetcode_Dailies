import java.util.Arrays;

//There is a strange printer with the following two special properties:
//
//The printer can only print a sequence of the same character each time.
//At each turn, the printer can print new characters starting from and ending at any place and will cover the original existing characters.
//Given a string s, return the minimum number of turns the printer needed to print it.
//
//
//
//        Example 1:
//
//Input: s = "aaabbb"
//Output: 2
//Explanation: Print "aaa" first and then print "bbb".
//Example 2:
//
//Input: s = "aba"
//Output: 2
//Explanation: Print "aaa" first and then print "b" from the second place of the string, which will cover the existing character 'a'.
//
//
//Constraints:
//
//        1 <= s.length <= 100
//s consists of lowercase English letters.
public class StrangePrinter {
    public int strangePrinter(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        System.out.println(s);
        // Filling DP table
        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = 1; // A single character needs 1 turn
            for (int j = i + 1; j < n; j++) {
                dp[i][j] = dp[i][j - 1] + 1; // Initial assumption, print s[j] separately
                for (int k = i; k < j; k++) {
                    if (s.charAt(k) == s.charAt(j)) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j - 1]);
                    }
                }
            }
        }

        return dp[0][n - 1];
    }
}
