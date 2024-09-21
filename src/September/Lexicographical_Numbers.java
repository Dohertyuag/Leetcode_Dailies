package September;

import java.util.ArrayList;
import java.util.List;

/*
Given an integer n, return all the numbers in the range [1, n] sorted in lexicographical order.

You must write an algorithm that runs in O(n) time and uses O(1) extra space.



Example 1:

Input: n = 13
Output: [1,10,11,12,13,2,3,4,5,6,7,8,9]
Example 2:

Input: n = 2
Output: [1,2]


Constraints:

1 <= n <= 5 * 10^4
 */
public class Lexicographical_Numbers {
    public List<Integer> lexicalOrder(int n) {
        int count = 1;
        List<Integer> list = new ArrayList<Integer>();

        for (int i = 1; i <= n; i++) {
            list.add(count);

            if (count * 10 <= n) {
                count = count * 10;
            } else {
                while (count % 10 == 9 || count >= n) {
                    count /= 10;
                }
                count++;
            }
        }

        System.out.println(list);
        return list;
    }

    public void driver() {
        int[] nums = {13, 2, 50000, 911, 1, 8957, 10, 50};
        for (int n : nums) {
            System.out.println(lexicalOrder(n));
        }
    }
}
