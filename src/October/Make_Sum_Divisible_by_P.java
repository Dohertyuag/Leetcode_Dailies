package October;

import java.util.Arrays;
import java.util.HashMap;

/*
Given an array of positive integers nums, remove the smallest subarray (possibly empty) such that the sum of the remaining elements is divisible by p. It is not allowed to remove the whole array.

Return the length of the smallest subarray that you need to remove, or -1 if it's impossible.

A subarray is defined as a contiguous block of elements in the array.



Example 1:

Input: nums = [3,1,4,2], p = 6
Output: 1
Explanation: The sum of the elements in nums is 10, which is not divisible by 6. We can remove the subarray [4], and the sum of the remaining elements is 6, which is divisible by 6.
Example 2:

Input: nums = [6,3,5,2], p = 9
Output: 2
Explanation: We cannot remove a single element to get a sum divisible by 9. The best way is to remove the subarray [5,2], leaving us with [6,3] with sum 9.
Example 3:

Input: nums = [1,2,3], p = 3
Output: 0
Explanation: Here the sum is 6. which is already divisible by 3. Thus we do not need to remove anything.


Constraints:

1 <= nums.length <= 10^5
1 <= nums[i] <= 10^9
1 <= p <= 10^9
 */
public class Make_Sum_Divisible_by_P {
    public int minSubarray(int[] nums, int p) {
        System.out.println("nums: " + Arrays.toString(nums) + "\tp: " + p);
        double sum = 0;

        for (int num : nums) {
            sum += num;
        }

        if (sum % p == 0.0) return 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        int temp = 0;
        sum %= p;
        int substringLen = nums.length;
        int s = (int) sum;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == (sum % p)) return 1;

            temp = (nums[i] + temp) % p;
            map.put(temp, i);
            if (s == temp) {
                substringLen = Math.min(substringLen, i + 1);
            }
            if (map.get((temp + p - s) % p) != null) {
                substringLen = Math.min(substringLen, i - map.get((temp + p - s) % p));
            }
        }

        if (substringLen == nums.length) return -1;

        return substringLen;
    }

    public void driver() {
        int[][] nums = {{3, 1, 4, 2}, {6}, {6, 3, 5, 2}, {9}, {1, 2, 3}, {3}, {1000000000, 1000000000, 1000000000}, {3}};
        for (int i = 0; i < nums.length; i += 2) {
            System.out.println("result: " + minSubarray(nums[i], nums[i + 1][0]));
        }
    }
}
