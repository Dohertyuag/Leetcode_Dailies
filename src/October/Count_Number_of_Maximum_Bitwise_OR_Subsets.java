package October;

import java.util.Arrays;

/*
Given an integer array nums, find the maximum possible bitwise OR of a subset of nums and return the number of different non-empty subsets with the maximum bitwise OR.

An array a is a subset of an array b if a can be obtained from b by deleting some (possibly zero) elements of b. Two subsets are considered different if the indices of the elements chosen are different.

The bitwise OR of an array a is equal to a[0] OR a[1] OR ... OR a[a.length - 1] (0-indexed).



Example 1:

Input: nums = [3,1]
Output: 2
Explanation: The maximum possible bitwise OR of a subset is 3. There are 2 subsets with a bitwise OR of 3:
- [3]
- [3,1]
Example 2:

Input: nums = [2,2,2]
Output: 7
Explanation: All non-empty subsets of [2,2,2] have a bitwise OR of 2. There are 23 - 1 = 7 total subsets.
Example 3:

Input: nums = [3,2,1,5]
Output: 6
Explanation: The maximum possible bitwise OR of a subset is 7. There are 6 subsets with a bitwise OR of 7:
- [3,5]
- [3,1,5]
- [3,2,5]
- [3,2,1,5]
- [2,5]
- [2,1,5]


Constraints:

1 <= nums.length <= 16
1 <= nums[i] <= 10^5
 */
public class Count_Number_of_Maximum_Bitwise_OR_Subsets {
    private int count = 0;
    private int target = 0;

    public int countMaxOrSubsets(int[] nums) {
        if (nums.length == 1) return 1;

        for (int n : nums) {
            target |= n;
        }

        backtrack(nums, 0, 0);

        return count;
    }

    private void backtrack(int[] nums, int index, int current_or) {
        if (current_or == target) {
            count++;
        }

        for (int i = index; i < nums.length; i++) {
            backtrack(nums, i + 1, current_or | nums[i]);
        }
    }

    public void driver() {
        int[][] data = {{12007}, {39317, 28735, 71230, 59313, 19954}, {35569, 91997, 54930, 66672, 12363}, {32, 39, 37, 31, 42, 38, 29, 43, 40, 36, 44, 35, 41, 33, 34, 30}, {63609, 94085, 69432, 15248, 22060, 76843, 84075, 835, 23463, 66399, 95031, 22676, 92115}, {6890, 6890, 6890, 6890, 6890, 6890, 6890, 6890, 6890, 6890, 6890, 6890, 6890, 6890, 6890, 6890}, {90193, 56697, 77229, 72927, 74728, 93652, 70751, 32415, 94774, 9067, 14758, 59835, 26047, 36393, 60530, 64649}, {89260, 58129, 16949, 64128, 9782, 26664, 96968, 59838, 27627, 68561, 4026, 91345, 26966, 28876, 46276, 19878}};
        for (int[] datum : data) {
            System.out.println("Result: " + countMaxOrSubsets(datum));
        }

    }
}
