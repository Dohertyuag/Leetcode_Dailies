package September;

import java.util.Arrays;

/*
You have observations of n + m 6-sided dice rolls with each face numbered from 1 to 6. n of the observations went missing, and you only have the observations of m rolls. Fortunately, you have also calculated the average value of the n + m rolls.

You are given an integer array rolls of length m where rolls[i] is the value of the ith observation. You are also given the two integers mean and n.

Return an array of length n containing the missing observations such that the average value of the n + m rolls is exactly mean. If there are multiple valid answers, return any of them. If no such array exists, return an empty array.

The average value of a set of k numbers is the sum of the numbers divided by k.

Note that mean is an integer, so the sum of the n + m rolls should be divisible by n + m.



Example 1:

Input: rolls = [3,2,4,3], mean = 4, n = 2
Output: [6,6]
Explanation: The mean of all n + m rolls is (3 + 2 + 4 + 3 + 6 + 6) / 6 = 4.
Example 2:

Input: rolls = [1,5,6], mean = 3, n = 4
Output: [2,3,2,2]
Explanation: The mean of all n + m rolls is (1 + 5 + 6 + 2 + 3 + 2 + 2) / 7 = 3.
Example 3:

Input: rolls = [1,2,3,4], mean = 6, n = 4
Output: []
Explanation: It is impossible for the mean to be 6 no matter what the 4 missing rolls are.
 */
public class Find_Missing_Observations {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        System.out.println("Rolls: " + Arrays.toString(rolls) + ", Mean: " + mean + ", N: " + n);
        int total_sum_rolls = 0;
        int m = rolls.length;

        for (int roll : rolls) {
            total_sum_rolls += roll;
        }

        int total_sum = mean * (m + n);
        int required_sum = total_sum - total_sum_rolls;

        int base_value = required_sum / n;
        int remainder = required_sum % n;

        if (base_value <= 0 || base_value > 6 || (base_value == 6 && remainder > 0)) {
            return new int[0];
        }

        int[] result = new int[n];
        Arrays.fill(result, base_value);
        System.out.println("Results : " + Arrays.toString(result));
        for (int i = 0; i < required_sum % n; ++i) {
            result[i] += 1;
        }
        return result;
    }

    public void driver(int[][] n) {
        for (int i = 0; i < n.length; i += 3) {
            missingRolls(n[i], Integer.parseInt(Arrays.toString(n[i + 1]).substring(1,2)), Integer.parseInt(Arrays.toString(n[i + 2]).substring(1,2)));
        }
    }
}
