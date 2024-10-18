package October;

import java.util.Arrays;

/*
You are given an integer num. You can swap two digits at most once to get the maximum valued number.

Return the maximum valued number you can get.



Example 1:

Input: num = 2736
Output: 7236
Explanation: Swap the number 2 and the number 7.
Example 2:

Input: num = 9973
Output: 9973
Explanation: No swap.


Constraints:

0 <= num <= 10^8
 */
public class Maximum_Swap {
    public int maximumSwap(int num) {
        System.out.println("num = " + num);
        char[] num_arr = Integer.toString(num).toCharArray();
        int n = num_arr.length;
        int right = -1;
        int min_index = -1;
        int max_index = -1;

        for(int i = n - 1; i >= 0; i--) {
            if(max_index == -1 || num_arr[i] > num_arr[max_index]) {
                max_index = i;
            }
            else if(num_arr[i] < num_arr[max_index]) {
                min_index = i;
                right = max_index;
            }
        }

        if(right != -1) {
            char temp = num_arr[right];
            num_arr[right] = num_arr[min_index];
            num_arr[min_index] = temp;
        }

        return Integer.parseInt(new String(num_arr));
    }

    public void driver() {
        int[] nums = {2736, 9973, 3, 1993, 6687, 98368, 56867898, 98004365, 98765432, 98800435};
        for(int n : nums){
            System.out.println("Result: " + maximumSwap(n));
        }
    }
}
