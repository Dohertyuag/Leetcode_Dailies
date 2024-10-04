package October;
/*
You are given a positive integer array skill of even length n where skill[i] denotes the skill of the ith player. Divide the players into n / 2 teams of size 2 such that the total skill of each team is equal.

The chemistry of a team is equal to the product of the skills of the players on that team.

Return the sum of the chemistry of all the teams, or return -1 if there is no way to divide the players into teams such that the total skill of each team is equal.


Example 1:

Input: skill = [3,2,5,1,3,4]
Output: 22
Explanation:
Divide the players into the following teams: (1, 5), (2, 4), (3, 3), where each team has a total skill of 6.
The sum of the chemistry of all the teams is: 1 * 5 + 2 * 4 + 3 * 3 = 5 + 8 + 9 = 22.
Example 2:

Input: skill = [3,4]
Output: 12
Explanation:
The two players form a team with a total skill of 7.
The chemistry of the team is 3 * 4 = 12.
Example 3:

Input: skill = [1,1,2,3]
Output: -1
Explanation:
There is no way to divide the players into teams such that the total skill of each team is equal.


Constraints:

2 <= skill.length <= 105
skill.length is even.
1 <= skill[i] <= 1000
 */

import java.util.Arrays;

public class Divide_Players_Into_Teams_of_Equal_Skill {
    public long dividePlayers(int[] skill) {
        int n = skill.length;
        int[] res = new int[n / 2];
        System.out.println("n: " + n + "\tres: " + res.length);
        long sum = 0;
        Arrays.sort(skill);
        int target = skill[0] + skill[n - 1];
        for (int i = 0; i < (n / 2); i++) {
            int curr = skill[i] + skill[n - i - 1];
            if (curr == target) {
                res[i] = skill[i] * skill[n - i - 1];

            } else if (curr != target) {
                return -1;
            }
        }
        System.out.println("res: " + Arrays.toString(res));
        for (int num : res) {
            sum += num;
        }
        return sum;

    }

    public void driver() {
        int[][] nums = {{3, 2, 5, 1, 3, 4}, {3, 4}, {1, 1, 2, 3}, {1, 1, 1, 2, 3, 3, 3, 7, 7, 8, 8, 8, 9, 9}, {40, 24, 16, 14}, {3, 5}};

        for (int i = 0; i < nums.length; i++) {
            System.out.println("Result: " + dividePlayers(nums[i]));
        }
    }

}
