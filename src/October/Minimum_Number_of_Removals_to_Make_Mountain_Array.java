package October;

import java.util.Arrays;

/*
You may recall that an array arr is a mountain array if and only if:

1. arr.length >= 3
2. There exists some index i (0-indexed) with 0 < i < arr.length - 1 such that:
    arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
    arr[i] > arr[i + 1] > ... > arr[arr.length - 1]

Given an integer array 'nums', return the minimum number of elements to remove to make 'nums' a mountain array.



Example 1:

Input: nums = [1,3,1]
Output: 0
Explanation: The array itself is a mountain array so we do not need to remove any elements.
Example 2:

Input: nums = [2,1,1,5,6,2,3,1]
Output: 3
Explanation: One solution is to remove the elements at indices 0, 1, and 5, making the array nums = [1,5,6,3,1].


Constraints:

3 <= n <= 1000
1 <= nums[i] <= 10^9
It is guaranteed that you can make a mountain array out of nums.
 */
public class Minimum_Number_of_Removals_to_Make_Mountain_Array {
    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;
        int[] longest_increasing_subsequence = new int[n];
        int[] longest_decreasing_subsequence = new int[n];

        longest_increasing_subsequence[0] = 1;
        longest_decreasing_subsequence[n - 1] = 1;

        for (int i = 1; i < n; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (longest_increasing_subsequence[j] > max) {
                        max = longest_increasing_subsequence[j];
                    }
                }

            }
            longest_increasing_subsequence[i] = max + 1;

        }
        for (int i = n - 2; i >= 0; i--) {
            int max = 0;
            for (int j = i; j < n; j++) {
                if (nums[i] > nums[j]) {
                    if (longest_decreasing_subsequence[j] > max) {
                        max = longest_decreasing_subsequence[j];
                    }
                }
            }
            longest_decreasing_subsequence[i] = max + 1;
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {
            if(longest_increasing_subsequence[i] >= 2 &&  longest_decreasing_subsequence[i] >=2){
                ans = Math.max(ans, longest_increasing_subsequence[i] + longest_decreasing_subsequence[i] - 1);
            }
        }

        return n - ans;
    }

    public void driver() {
        int[][] data = {{100, 92, 89, 77, 74, 66, 64, 66, 64}, {1, 3, 1}, {2, 1, 1, 5, 6, 2, 3, 1}};

        for (int[] d : data) {
            System.out.println("Result: " + minimumMountainRemovals(d));
        }

    }

}
