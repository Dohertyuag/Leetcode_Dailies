package November;

/*
The bitwise AND of an array nums is the bitwise AND of all integers in nums.

For example, for nums = [1, 5, 3], the bitwise AND is equal to 1 & 5 & 3 = 1.
Also, for nums = [7], the bitwise AND is 7.
You are given an array of positive integers candidates. Evaluate the bitwise AND of every combination of numbers of candidates. Each number in candidates may only be used once in each combination.

Return the size of the largest combination of candidates with a bitwise AND greater than 0.



Example 1:

Input: candidates = [16,17,71,62,12,24,14]
Output: 4
Explanation: The combination [16,17,62,24] has a bitwise AND of 16 & 17 & 62 & 24 = 16 > 0.
The size of the combination is 4.
It can be shown that no combination with a size greater than 4 has a bitwise AND greater than 0.
Note that more than one combination may have the largest size.
For example, the combination [62,12,24,14] has a bitwise AND of 62 & 12 & 24 & 14 = 8 > 0.
Example 2:

Input: candidates = [8,8]
Output: 2
Explanation: The largest combination [8,8] has a bitwise AND of 8 & 8 = 8 > 0.
The size of the combination is 2, so we return 2.


Constraints:

1 <= candidates.length <= 10^5
1 <= candidates[i] <= 10^7
 */
public class Largest_Combination_With_Bitwise_AND_Greater_Than_Zero {
    public int largestCombination(int[] candidates) {
        int res = 0;

        for(int i = 0; i < 32; i++){
            int count = 0;
            for(int candidate : candidates){
                if((candidate & (1 << i)) > 0)
                    count++;
            }
            res = Math.max(res, count);
        }

        return res;
    }

    public void driver() {
        int[][] data = {{16, 17, 71, 62, 12, 24, 14}, {8, 8}, {10000000, 6777215}, {10000000, 8388608}, {1024, 1, 512, 2097152, 8, 32, 256, 4096, 16, 4194304, 524288, 8388608, 2048, 64, 8192, 4, 16384, 262144, 2, 131072, 1048576, 128, 32768, 65536}, {2902691, 5795304, 6498538, 1107154, 3738293, 98410, 3100740, 3426513, 3819969, 2927409, 9470990, 4682704, 4309602, 203465, 9498164, 6165150, 6570823, 8253453, 959683, 7967139, 1785588, 1659810, 937808, 2033944}, {7864428, 6776705, 9568137, 4280196, 9052185, 6860105, 2378400, 9259675, 4589279, 7663845, 8651968, 7179776, 6887367, 598853, 2827868, 7844978, 3557665, 89836, 1206763, 8791281, 176082, 1444344, 2858681, 9724930, 2582982, 6269480, 5318547, 5812393, 9048045}, {3789982, 7208092, 6206972, 9750454, 9844126, 2355625, 1182239, 3427469, 221728, 3907397, 9856431, 1549882, 9513252, 9510589, 8559750, 3156537, 129641, 1083720, 8834948, 2923086, 7077544, 9560786, 3669227, 3316786, 260585}, {1205916, 2017227, 5914256, 8152708, 3675641, 656382, 5836032, 2672733, 5163015, 5070816, 5952549, 501167, 3092148, 8313659, 5952936, 1708369, 8971061, 4659222, 1050938, 4191464}, {7917066, 4342947, 6244619, 3248103, 5720057, 86462, 9543176, 7644671, 1463701, 655791, 6505287, 1529871, 4769452, 319316, 1690914, 1114906, 9431449, 3259514, 5517227, 3687009, 1496638, 8384593, 7262346, 5968124, 6599644, 2651452, 8375662, 7353481, 6562273}, {9452577, 5000319, 8976514, 8629397, 6462390, 2504358, 997470, 3774684, 8230138, 7791118, 7057067, 6999647, 2571060, 3176711, 5653579, 8692049, 7855482, 1359560, 2118290, 5651653, 9103921, 2912746, 6023628}, {2460841, 6918408, 2163172, 2068407, 5890367, 9591140, 5850049, 8130149, 4874291, 5554496, 7049260, 2724687, 939343, 8275842, 6975697, 5320965, 707426, 5171756, 9999066, 2553056}, {1582495, 7019966, 5716674, 1514058, 5700085, 628950, 6836632, 8133082, 2582922, 3230036, 5524838, 8071874, 8276882, 3160594, 1812428, 3114649, 5467352, 3599216, 8162504, 8973006, 6847893, 2390016, 9079950, 3810041}, {4718227, 4911315, 4365844, 6175786, 1088698, 7523907, 5491050, 3168711, 6123472, 5090481, 4622343, 1968916, 4483711, 3861769, 1099630, 9182149, 2972539, 9832570, 676142, 4702468, 9495512, 4508924, 3807594, 4995498, 9406934, 7547378, 2574894}, {5993499, 6002348, 1942597, 5556400, 6478456, 7237775, 2561242, 8680198, 9363284, 2657519, 929647, 4628290, 5962061, 938461, 7039891, 1721095, 8171714, 1931986, 4934475, 6962283, 9330169}};


        for (int[] d : data) {
            System.out.println("Result: " + largestCombination(d));
        }
    }
}
