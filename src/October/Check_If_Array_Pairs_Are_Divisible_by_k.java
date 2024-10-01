package October;

import java.util.Arrays;

/*
Given an array of integers arr of even length n and an integer k.

We want to divide the array into exactly n / 2 pairs such that the sum of each pair is divisible by k.

Return true If you can find a way to do that or false otherwise.



Example 1:

Input: arr = [1,2,3,4,5,10,6,7,8,9], k = 5
Output: true
Explanation: Pairs are (1,9),(2,8),(3,7),(4,6) and (5,10).
Example 2:

Input: arr = [1,2,3,4,5,6], k = 7
Output: true
Explanation: Pairs are (1,6),(2,5) and(3,4).
Example 3:

Input: arr = [1,2,3,4,5,6], k = 10
Output: false
Explanation: You can try all possible pairs to see that there is no way to divide arr into 3 pairs each with sum divisible by 10.


Constraints:

arr.length == n
1 <= n <= 10^5
n is even.
-109 <= arr[i] <= 10^9
1 <= k <= 10^5
*/
public class Check_If_Array_Pairs_Are_Divisible_by_k {
    public boolean canArrange(int[] arr, int k) {
        if (k == 1) return true;
        int[] freq = new int[k];
        System.out.println("Array: " + Arrays.toString(arr) + "\tk : " + k);

        for (int i = 0; i < arr.length; i++) {
            int remainder = arr[i] % k;

            if (remainder < 0) {
                remainder += k;
            }
            freq[remainder]++;
        }
        if (freq[0] % 2 != 0) return false;
        for (int i = 1; i < k; i++) {
            if (freq[i] != freq[k - i]) return false;
        }

        return true;
    }

    public void driver() {
        int[][] nums = {{1, 2, 3, 4, 5, 10, 6, 7, 8, 9}, {5}, {1, 2, 3, 4, 5, 6}, {7}, {1, 2, 3, 4, 5, 6}, {10}, {0, 5, 10, 0}, {5}, {1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, 100009, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -9, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000, 1000000000, 200000000, -1000000000, -1000000000}, {100000}, {123456789, 987654321, -123456789, -987654321, 123456789, 987654321, -123456789, -987654321, 123456789, 987654321, -123456789, -987654321, 123456789, 987654321, -123456789, -987654321}, {11111}, {987654321, -987654321, 765432100, -765432100}, {99999}, {-1, 0, -2, 2, -3, 3}, {4}};
        for (int i = 0; i < nums.length; i += 2) {
            System.out.println("Result : " + canArrange(nums[i], nums[i + 1][0]));
        }
    }
}