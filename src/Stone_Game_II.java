//Alice and Bob continue their games with piles of stones.  There are a number of piles arranged in a row, and each pile has a positive integer number of stones piles[i].  The objective of the game is to end with the most stones.
//
//Alice and Bob take turns, with Alice starting first.  Initially, M = 1.
//
//On each player's turn, that player can take all the stones in the first X remaining piles, where 1 <= X <= 2M.  Then, we set M = max(M, X).
//
//The game continues until all the stones have been taken.
//
//Assuming Alice and Bob play optimally, return the maximum number of stones Alice can get.
//
//
//
//Example 1:
//
//Input: piles = [2,7,9,4,4]
//Output: 10
//Explanation:  If Alice takes one pile at the beginning, Bob takes two piles, then Alice takes 2 piles again. Alice can get 2 + 4 + 4 = 10 piles in total. If Alice takes two piles at the beginning, then Bob can take all three piles left. In this case, Alice get 2 + 7 = 9 piles in total. So we return 10 since it's larger.
//Example 2:
//
//Input: piles = [1,2,3,4,5,100]
//Output: 104


import java.util.Arrays;

public class Stone_Game_II {
    public int stoneGameII(int[] piles) {
        int length = piles.length;
        int[][] dp = new int[length + 1][length + 1];
        int[] suffix_sum = new int[length + 1];

        for (int i = length - 1; i >= 0; i--) {
            suffix_sum[i] = suffix_sum[i + 1] + piles[i];
            System.out.println("suffix_sum: " + suffix_sum[i + 1] + "\tpiles: " + piles[i]);
        }
        System.out.println(Arrays.toString(piles) + " || " + Arrays.toString(suffix_sum));
        return helper(dp, suffix_sum, 0, 1);
    }

    private int helper(int[][] dp, int[] sufsum, int i, int M) {
        if (i == sufsum.length) return 0;
        if (2 * M >= sufsum.length - i) return sufsum[i];
        if (dp[i][M] != 0) return dp[i][M];

        int res = Integer.MAX_VALUE;
        for (int X = 1; X <= 2 * M; X++) {
            res = Math.min(res, helper(dp, sufsum, i + X, Math.max(X, M)));
        }

        dp[i][M] = sufsum[i] - res;
        return dp[i][M];
    }
}
