package October;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
There is a party where n friends numbered from 0 to n - 1 are attending. There is an infinite number of chairs in this party that are numbered from 0 to infinity. When a friend arrives at the party, they sit on the unoccupied chair with the smallest number.

For example, if chairs 0, 1, and 5 are occupied when a friend comes, they will sit on chair number 2.
When a friend leaves the party, their chair becomes unoccupied at the moment they leave. If another friend arrives at that same moment, they can sit in that chair.

You are given a 0-indexed 2D integer array times where times[i] = [arrivali, leavingi], indicating the arrival and leaving times of the ith friend respectively, and an integer targetFriend. All arrival times are distinct.

Return the chair number that the friend numbered targetFriend will sit on.



Example 1:

Input: times = [[1,4],[2,3],[4,6]], targetFriend = 1
Output: 1
Explanation:
- Friend 0 arrives at time 1 and sits on chair 0.
- Friend 1 arrives at time 2 and sits on chair 1.
- Friend 1 leaves at time 3 and chair 1 becomes empty.
- Friend 0 leaves at time 4 and chair 0 becomes empty.
- Friend 2 arrives at time 4 and sits on chair 0.
Since friend 1 sat on chair 1, we return 1.
Example 2:

Input: times = [[3,10],[1,5],[2,6]], targetFriend = 0
Output: 2
Explanation:
- Friend 1 arrives at time 1 and sits on chair 0.
- Friend 2 arrives at time 2 and sits on chair 1.
- Friend 0 arrives at time 3 and sits on chair 2.
- Friend 1 leaves at time 5 and chair 0 becomes empty.
- Friend 2 leaves at time 6 and chair 1 becomes empty.
- Friend 0 leaves at time 10 and chair 2 becomes empty.
Since friend 0 sat on chair 2, we return 2.


Constraints:

n == times.length
2 <= n <= 104
times[i].length == 2
1 <= arrivali < leavingi <= 105
0 <= targetFriend <= n - 1
Each arrivali time is distinct.
 */
public class The_Number_of_the_Smallest_Unoccupied_Chair {
    public int smallestChair(int[][] times, int targetFriend) {
        System.out.println("Times: " + Arrays.deepToString(times) + "\tTarget: " + targetFriend);

        int n = times.length;

        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        Arrays.sort(arr, Comparator.comparingInt(a -> times[a][0]));

        PriorityQueue<Integer> empty_seats = new PriorityQueue<>();
        PriorityQueue<int[]> occupied_seats = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        for (int i = 0; i < n; i++) {
            empty_seats.offer(i);
        }

        for (int i : arr) {
            int arrival = times[i][0];
            int departure = times[i][1];

            while (!occupied_seats.isEmpty() && occupied_seats.peek()[0] <= arrival) {
                empty_seats.offer(occupied_seats.poll()[1]);
            }

            int seat = empty_seats.poll();

            if (i == targetFriend) {
                return seat;
            }

            occupied_seats.offer(new int[]{departure, seat});

        }

        return -1;
    }

    public void driver() {
        int[][][] data = {{{1, 2}, {2, 10}, {3, 10}, {4, 10}, {5, 10}, {6, 10}, {7, 10}, {8, 10}, {9, 10}, {10, 11}}, {new int[]{8}}, {{1, 2}, {2, 3}}, {new int[]{1}}, {{4, 5}, {6, 8}, {8, 10}, {1, 8}}, {new int[]{2}}, {{33, 35}, {26, 29}, {9, 28}, {4, 31}, {8, 10}, {32, 34}, {15, 24}, {27, 39}, {14, 36}, {1, 14}, {25, 39}, {5, 27}, {6, 15}, {2, 38}, {19, 36}, {24, 34}, {3, 26}}, {new int[]{0}}, {{7, 10}, {6, 7}, {1, 3}, {2, 7}, {4, 5}}, {new int[]{0}}, {{2, 4}, {4, 9}, {3, 4}, {6, 8}, {5, 10}}, {new int[]{4}}, {{99999, 100000}, {1, 2}}, {new int[]{1}}, {{1, 10000}, {2, 10000}, {3, 10000}, {4, 10000}, {5, 10000}, {6, 10000}, {7, 10000}, {8, 10000}, {9, 10000}, {10, 10000}, {11, 10000}, {12, 10000}, {13, 10000}, {14, 10000}, {15, 10000}, {16, 10000}, {17, 10000}, {18, 10000}, {19, 10000}, {20, 10000}, {21, 10000}, {22, 10000}, {23, 10000}, {24, 10000}, {25, 10000}, {26, 10000}, {27, 10000}, {28, 10000}, {29, 10000}, {30, 10000}, {31, 10000}, {32, 10000}, {33, 10000}, {34, 10000}, {35, 10000}, {36, 10000}, {37, 10000}, {38, 10000}, {39, 10000}, {40, 10000}, {41, 10000}, {42, 10000}, {43, 10000}, {44, 10000}, {45, 10000}, {46, 10000}, {47, 10000}, {48, 10000}, {49, 10000}, {50, 10000}, {51, 10000}, {52, 10000}, {53, 10000}, {54, 10000}, {55, 10000}, {56, 10000}, {57, 10000}, {58, 10000}, {59, 10000}, {60, 10000}, {61, 10000}, {62, 10000}, {63, 10000}, {64, 10000}, {65, 10000}, {66, 10000}, {67, 10000}, {68, 10000}, {69, 10000}, {70, 10000}, {71, 10000}, {72, 10000}, {73, 10000}, {74, 10000}, {75, 10000}, {76, 10000}, {77, 10000}, {78, 10000}, {79, 10000}, {80, 10000}, {81, 10000}, {82, 10000}, {83, 10000}, {84, 10000}, {85, 10000}, {86, 10000}, {87, 10000}, {88, 10000}, {89, 10000}, {90, 10000}, {91, 10000}, {92, 10000}, {93, 10000}, {94, 10000}, {95, 10000}, {96, 10000}, {97, 10000}, {98, 10000}, {99, 10000}, {100, 10000}, {101, 10000}, {102, 10000}, {103, 10000}, {104, 10000}, {105, 10000}, {106, 10000}, {107, 10000}, {108, 10000}, {109, 10000}, {110, 10000}, {111, 10000}, {112, 10000}, {113, 10000}, {114, 10000}, {115, 10000}, {116, 10000}, {117, 10000}, {118, 10000}, {119, 10000}, {120, 10000}, {121, 10000}, {122, 10000}, {123, 10000}, {124, 10000}, {125, 10000}, {126, 10000}, {127, 10000}, {128, 10000}, {129, 10000}, {130, 10000}, {131, 10000}, {132, 10000}, {133, 10000}, {134, 10000}, {135, 10000}, {136, 10000}, {137, 10000}, {138, 10000}, {139, 10000}, {140, 10000}, {141, 10000}, {142, 10000}, {143, 10000}, {144, 10000}, {145, 10000}, {146, 10000}, {147, 10000}, {148, 10000}, {149, 10000}, {150, 10000}, {151, 10000}, {152, 10000}, {153, 10000}, {154, 10000}, {155, 10000}, {156, 10000}, {157, 10000}, {158, 10000}, {159, 10000}, {160, 10000}, {161, 10000}, {162, 10000}, {163, 10000}, {164, 10000}, {165, 10000}, {166, 10000}, {167, 10000}, {168, 10000}, {169, 10000}, {170, 10000}, {171, 10000}, {172, 10000}, {173, 10000}, {174, 10000}, {175, 10000}, {176, 10000}, {177, 10000}, {178, 10000}, {179, 10000}, {180, 10000}, {181, 10000}, {182, 10000}, {183, 10000}, {184, 10000}, {185, 10000}, {186, 10000}, {187, 10000}, {188, 10000}, {189, 10000}, {190, 10000}, {191, 10000}, {192, 10000}, {193, 10000}, {194, 10000}, {195, 10000}, {196, 10000}, {197, 10000}, {198, 10000}, {199, 10000}, {200, 10000}, {201, 10000}, {202, 10000}, {203, 10000}, {204, 10000}, {205, 10000}, {206, 10000}, {207, 10000}, {208, 10000}, {209, 10000}, {210, 10000}, {211, 10000}, {212, 10000}, {213, 10000}, {214, 10000}, {215, 10000}, {216, 10000}, {217, 10000}, {218, 10000}, {219, 10000}, {220, 10000}, {221, 10000}, {222, 10000}, {223, 10000}, {224, 10000}, {225, 10000}, {226, 10000}, {227, 10000}, {228, 10000}, {229, 10000}, {230, 10000}, {231, 10000}, {232, 10000}, {233, 10000}, {234, 10000}, {235, 10000}, {236, 10000}, {237, 10000}, {238, 10000}, {239, 10000}, {240, 10000}, {241, 10000}, {242, 10000}, {243, 10000}, {244, 10000}, {245, 10000}, {246, 10000}, {247, 10000}, {248, 10000}, {249, 10000}, {250, 10000}, {251, 10000}, {252, 10000}, {253, 10000}, {254, 10000}, {255, 10000}, {256, 10000}, {257, 10000}, {258, 10000}, {259, 10000}, {260, 10000}, {261, 10000}, {262, 10000}, {263, 10000}, {264, 10000}, {265, 10000}, {266, 10000}, {267, 10000}, {268, 10000}, {269, 10000}, {270, 10000}, {271, 10000}, {272, 10000}, {273, 10000}, {274, 10000}, {275, 10000}, {276, 10000}, {277, 10000}, {278, 10000}, {279, 10000}, {280, 10000}, {281, 10000}, {282, 10000}, {283, 10000}, {284, 10000}, {285, 10000}, {286, 10000}, {287, 10000}, {288, 10000}, {289, 10000}, {290, 10000}, {291, 10000}, {292, 10000}, {293, 10000}, {294, 10000}, {295, 10000}, {296, 10000}, {297, 10000}, {298, 10000}, {299, 10000}, {300, 10000}, {301, 10000}, {302, 10000}, {303, 10000}, {304, 10000}, {305, 10000}, {306, 10000}, {307, 10000}, {308, 10000}, {309, 10000}, {310, 10000}, {311, 10000}, {312, 10000}, {313, 10000}, {314, 10000}, {315, 10000}, {316, 10000}, {317, 10000}, {318, 10000}, {319, 10000}, {320, 10000}, {321, 10000}, {322, 10000}, {323, 10000}, {324, 10000}, {325, 10000}, {326, 10000}, {327, 10000}, {328, 10000}, {329, 10000}, {330, 10000}, {331, 10000}, {332, 10000}, {333, 10000}, {334, 10000}, {335, 10000}, {336, 10000}, {337, 10000}, {338, 10000}, {339, 10000}, {340, 10000}, {341, 10000}, {342, 10000}, {343, 10000}, {344, 10000}, {345, 10000}, {346, 10000}, {347, 10000}, {348, 10000}, {349, 10000}, {350, 10000}, {351, 10000}, {352, 10000}, {353, 10000}, {354, 10000}, {355, 10000}, {356, 10000}, {357, 10000}, {358, 10000}, {359, 10000}, {360, 10000}, {361, 10000}, {362, 10000}, {363, 10000}, {364, 10000}, {365, 10000}, {366, 10000}, {367, 10000}, {368, 10000}, {369, 10000}, {370, 10000}, {371, 10000}, {372, 10000}, {373, 10000}, {374, 10000}, {375, 10000}, {376, 10000}, {377, 10000}, {378, 10000}, {379, 10000}, {380, 10000}, {381, 10000}, {382, 10000}, {383, 10000}, {384, 10000}, {385, 10000}, {386, 10000}, {387, 10000}, {388, 10000}, {389, 10000}, {390, 10000}, {391, 10000}, {392, 10000}, {393, 10000}, {394, 10000}, {395, 10000}, {396, 10000}, {397, 10000}, {398, 10000}, {399, 10000}, {400, 10000}, {401, 10000}, {402, 10000}, {403, 10000}, {404, 10000}, {405, 10000}, {406, 10000}, {407, 10000}, {408, 10000}, {409, 10000}, {410, 10000}, {411, 10000}, {412, 10000}, {413, 10000}, {414, 10000}, {415, 10000}, {416, 10000}, {417, 10000}, {418, 10000}, {419, 10000}, {420, 10000}, {421, 10000}, {422, 10000}, {423, 10000}, {424, 10000}, {425, 10000}, {426, 10000}, {427, 10000}, {428, 10000}, {429, 10000}, {430, 10000}, {431, 10000}, {432, 10000}, {433, 10000}, {434, 10000}, {435, 10000}, {436, 10000}, {437, 10000}, {438, 10000}, {439, 10000}, {440, 10000}, {441, 10000}, {442, 10000}, {443, 10000}, {444, 10000}, {445, 10000}, {446, 10000}, {447, 10000}, {448, 10000}, {449, 10000}, {450, 10000}, {451, 10000}, {452, 10000}, {453, 10000}, {454, 10000}, {455, 10000}, {456, 10000}, {457, 10000}, {458, 10000}, {459, 10000}, {460, 10000}, {461, 10000}, {462, 10000}, {463, 10000}, {464, 10000}, {465, 10000}, {466, 10000}, {467, 10000}, {468, 10000}, {469, 10000}, {470, 10000}, {471, 10000}, {472, 10000}, {473, 10000}, {474, 10000}, {475, 10000}, {476, 10000}, {477, 10000}, {478, 10000}, {479, 10000}, {480, 10000}, {481, 10000}, {482, 10000}, {483, 10000}, {484, 10000}, {485, 10000}, {486, 10000}, {487, 10000}, {488, 10000}, {489, 10000}, {490, 10000}, {491, 10000}, {492, 10000}, {493, 10000}, {494, 10000}, {495, 10000}, {496, 10000}, {497, 10000}, {498, 10000}, {499, 10000}, {500, 10000}, {501, 10000}, {502, 10000}, {503, 10000}, {504, 10000}, {505, 10000}, {506, 10000}, {507, 10000}, {508, 10000}, {509, 10000}, {510, 10000}, {511, 10000}, {512, 10000}, {513, 10000}, {514, 10000}, {515, 10000}, {516, 10000}, {517, 10000}, {518, 10000}, {519, 10000}, {520, 10000}, {521, 10000}, {522, 10000}, {523, 10000}, {524, 10000}, {525, 10000}, {526, 10000}, {527, 10000}, {528, 10000}, {529, 10000}, {530, 10000}, {531, 10000}, {532, 10000}, {533, 10000}, {534, 10000}, {535, 10000}, {536, 10000}, {537, 10000}, {538, 10000}, {539, 10000}, {540, 10000}, {541, 10000}, {542, 10000}, {543, 10000}, {544, 10000}, {545, 10000}, {546, 10000}, {547, 10000}, {548, 10000}, {549, 10000}, {550, 10000}, {551, 10000}, {552, 10000}, {553, 10000}, {554, 10000}, {555, 10000}, {556, 10000}, {557, 10000}, {558, 10000}, {559, 10000}, {560, 10000}, {561, 10000}, {562, 10000}, {563, 10000}, {564, 10000}, {565, 10000}, {566, 10000}, {567, 10000}, {568, 10000}, {569, 10000}, {570, 10000}, {571, 10000}, {572, 10000}, {573, 10000}, {574, 10000}, {575, 10000}, {576, 10000}, {577, 10000}, {578, 10000}, {579, 10000}, {580, 10000}, {581, 10000}, {582, 10000}, {583, 10000}, {584, 10000}, {585, 10000}, {586, 10000}, {587, 10000}, {588, 10000}, {589, 10000}, {590, 10000}, {591, 10000}, {592, 10000}, {593, 10000}, {594, 10000}, {595, 10000}, {596, 10000}, {597, 10000}, {598, 10000}, {599, 10000}, {600, 10000}, {601, 10000}, {602, 10000}, {603, 10000}, {604, 10000}, {605, 10000}, {606, 10000}, {607, 10000}, {608, 10000}, {609, 10000}, {610, 10000}, {611, 10000}, {612, 10000}, {613, 10000}, {614, 10000}, {615, 10000}, {616, 10000}, {617, 10000}, {618, 10000}, {619, 10000}, {620, 10000}, {621, 10000}, {622, 10000}, {623, 10000}, {624, 10000}, {625, 10000}, {626, 10000}, {627, 10000}, {628, 10000}, {629, 10000}, {630, 10000}, {631, 10000}, {632, 10000}, {633, 10000}, {634, 10000}, {635, 10000}, {636, 10000}, {637, 10000}, {638, 10000}, {639, 10000}, {640, 10000}, {641, 10000}, {642, 10000}, {643, 10000}, {644, 10000}, {645, 10000}, {646, 10000}, {647, 10000}, {648, 10000}, {649, 10000}, {650, 10000}, {651, 10000}, {652, 10000}, {653, 10000}, {654, 10000}, {655, 10000}, {656, 10000}, {657, 10000}, {658, 10000}, {659, 10000}, {660, 10000}, {661, 10000}, {662, 10000}, {663, 10000}, {664, 10000}, {665, 10000}, {666, 10000}, {667, 10000}, {668, 10000}, {669, 10000}, {670, 10000}, {671, 10000}, {672, 10000}, {673, 10000}, {674, 10000}, {675, 10000}, {676, 10000}, {677, 10000}, {678, 10000}, {679, 10000}, {680, 10000}, {681, 10000}, {682, 10000}, {683, 10000}, {684, 10000}, {685, 10000}, {686, 10000}, {687, 10000}, {688, 10000}, {689, 10000}, {690, 10000}, {691, 10000}, {692, 10000}, {693, 10000}, {694, 10000}, {695, 10000}, {696, 10000}, {697, 10000}, {698, 10000}, {699, 10000}, {700, 10000}, {701, 10000}, {702, 10000}, {703, 10000}, {704, 10000}, {705, 10000}, {706, 10000}, {707, 10000}, {708, 10000}, {709, 10000}, {710, 10000}, {711, 10000}, {712, 10000}, {713, 10000}, {714, 10000}, {715, 10000}, {716, 10000}, {717, 10000}, {718, 10000}, {719, 10000}, {720, 10000}, {721, 10000}, {722, 10000}, {723, 10000}, {724, 10000}, {725, 10000}, {726, 10000}, {727, 10000}, {728, 10000}, {729, 10000}, {730, 10000}, {731, 10000}, {732, 10000}, {733, 10000}, {734, 10000}, {735, 10000}, {736, 10000}, {737, 10000}, {738, 10000}, {739, 10000}, {740, 10000}, {741, 10000}, {742, 10000}, {743, 10000}, {744, 10000}, {745, 10000}, {746, 10000}, {747, 10000}, {748, 10000}, {749, 10000}, {750, 10000}, {751, 10000}, {752, 10000}, {753, 10000}, {754, 10000}, {755, 10000}, {756, 10000}, {757, 10000}, {758, 10000}, {759, 10000}, {760, 10000}, {761, 10000}, {762, 10000}, {763, 10000}, {764, 10000}, {765, 10000}, {766, 10000}, {767, 10000}, {768, 10000}, {769, 10000}, {770, 10000}, {771, 10000}, {772, 10000}, {773, 10000}, {774, 10000}, {775, 10000}, {776, 10000}, {777, 10000}, {778, 10000}, {779, 10000}, {780, 10000}, {781, 10000}, {782, 10000}, {783, 10000}, {784, 10000}, {785, 10000}, {786, 10000}, {787, 10000}, {788, 10000}, {789, 10000}, {790, 10000}, {791, 10000}, {792, 10000}, {793, 10000}, {794, 10000}, {795, 10000}, {796, 10000}, {797, 10000}, {798, 10000}, {799, 10000}, {800, 10000}, {801, 10000}, {802, 10000}, {803, 10000}, {804, 10000}, {805, 10000}, {806, 10000}, {807, 10000}, {808, 10000}, {809, 10000}, {810, 10000}, {811, 10000}, {812, 10000}, {813, 10000}, {814, 10000}, {815, 10000}, {816, 10000}, {817, 10000}, {818, 10000}, {819, 10000}, {820, 10000}, {821, 10000}, {822, 10000}, {823, 10000}, {824, 10000}, {825, 10000}, {826, 10000}, {827, 10000}, {828, 10000}, {829, 10000}, {830, 10000}, {831, 10000}, {832, 10000}, {833, 10000}, {834, 10000}, {835, 10000}, {836, 10000}, {837, 10000}, {838, 10000}, {839, 10000}, {840, 10000}, {841, 10000}, {842, 10000}, {843, 10000}, {844, 10000}, {845, 10000}, {846, 10000}, {847, 10000}, {848, 10000}, {849, 10000}, {850, 10000}, {851, 10000}, {852, 10000}, {853, 10000}, {854, 10000}, {855, 10000}, {856, 10000}, {857, 10000}, {858, 10000}, {859, 10000}, {860, 10000}, {861, 10000}, {862, 10000}, {863, 10000}, {864, 10000}, {865, 10000}, {866, 10000}, {867, 10000}, {868, 10000}, {869, 10000}, {870, 10000}, {871, 10000}, {872, 10000}, {873, 10000}, {874, 10000}, {875, 10000}, {876, 10000}, {877, 10000}, {878, 10000}, {879, 10000}, {880, 10000}, {881, 10000}, {882, 10000}, {883, 10000}, {884, 10000}, {885, 10000}, {886, 10000}, {887, 10000}, {888, 10000}, {889, 10000}, {890, 10000}, {891, 10000}, {892, 10000}, {893, 10000}, {894, 10000}, {895, 10000}, {896, 10000}, {897, 10000}, {898, 10000}, {899, 10000}, {900, 10000}, {901, 10000}, {902, 10000}, {903, 10000}, {904, 10000}, {905, 10000}, {906, 10000}, {907, 10000}, {908, 10000}, {909, 10000}, {910, 10000}, {911, 10000}, {912, 10000}, {913, 10000}, {914, 10000}, {915, 10000}, {916, 10000}, {917, 10000}, {918, 10000}, {919, 10000}, {920, 10000}, {921, 10000}, {922, 10000}, {923, 10000}, {924, 10000}, {925, 10000}, {926, 10000}, {927, 10000}, {928, 10000}, {929, 10000}, {930, 10000}, {931, 10000}, {932, 10000}, {933, 10000}, {934, 10000}, {935, 10000}, {936, 10000}, {937, 10000}, {938, 10000}, {939, 10000}, {940, 10000}, {941, 10000}, {942, 10000}, {943, 10000}, {944, 10000}, {945, 10000}, {946, 10000}, {947, 10000}, {948, 10000}, {949, 10000}, {950, 10000}, {951, 10000}, {952, 10000}, {953, 10000}, {954, 10000}, {955, 10000}, {956, 10000}, {957, 10000}, {958, 10000}, {959, 10000}, {960, 10000}, {961, 10000}, {962, 10000}, {963, 10000}, {964, 10000}, {965, 10000}, {966, 10000}, {967, 10000}, {968, 10000}, {969, 10000}, {970, 10000}, {971, 10000}, {972, 10000}, {973, 10000}, {974, 10000}, {975, 10000}, {976, 10000}, {977, 10000}, {978, 10000}, {979, 10000}, {980, 10000}, {981, 10000}, {982, 10000}, {983, 10000}, {984, 10000}, {985, 10000}, {986, 10000}, {987, 10000}, {988, 10000}, {989, 10000}, {990, 10000}, {991, 10000}, {992, 10000}, {993, 10000}, {994, 10000}, {995, 10000}, {996, 10000}, {997, 10000}, {998, 10000}, {999, 10000}, {1000, 10000}, {1001, 10000}, {1002, 10000}, {1003, 10000}, {1004, 10000}, {1005, 10000}, {1006, 10000}, {1007, 10000}, {1008, 10000}, {1009, 10000}, {1010, 10000}, {1011, 10000}, {1012, 10000}, {1013, 10000}, {1014, 10000}, {1015, 10000}, {1016, 10000}, {1017, 10000}, {1018, 10000}, {1019, 10000}, {1020, 10000}, {1021, 10000}, {1022, 10000}, {1023, 10000}, {1024, 10000}, {1025, 10000}, {1026, 10000}, {1027, 10000}, {1028, 10000}, {1029, 10000}, {1030, 10000}, {1031, 10000}, {1032, 10000}, {1033, 10000}, {1034, 10000}, {1035, 10000}, {1036, 10000}, {1037, 10000}, {1038, 10000}, {1039, 10000}, {1040, 10000}, {1041, 10000}, {1042, 10000}, {1043, 10000}, {1044, 10000}, {1045, 10000}, {1046, 10000}, {1047, 10000}, {1048, 10000}, {1049, 10000}, {1050, 10000}, {1051, 10000}, {1052, 10000}, {1053, 10000}, {1054, 10000}, {1055, 10000}, {1056, 10000}, {1057, 10000}, {1058, 10000}, {1059, 10000}, {1060, 10000}, {1061, 10000}, {1062, 10000}, {1063, 10000}, {1064, 10000}, {1065, 10000}, {1066, 10000}, {1067, 10000}, {1068, 10000}, {1069, 10000}, {1070, 10000}, {1071, 10000}, {1072, 10000}, {1073, 10000}, {1074, 10000}, {1075, 10000}, {1076, 10000}, {1077, 10000}, {1078, 10000}, {1079, 10000}, {1080, 10000}, {1081, 10000}, {1082, 10000}, {1083, 10000}, {1084, 10000}, {1085, 10000}, {1086, 10000}, {1087, 10000}, {1088, 10000}, {1089, 10000}, {1090, 10000}, {1091, 10000}, {1092, 10000}, {1093, 10000}, {1094, 10000}, {1095, 10000}, {1096, 10000}, {1097, 10000}, {1098, 10000}, {1099, 10000}, {1100, 10000}, {1101, 10000}, {1102, 10000}, {1103, 10000}, {1104, 10000}, {1105, 10000}, {1106, 10000}, {1107, 10000}, {1108, 10000}, {1109, 10000}, {1110, 10000}, {1111, 10000}, {1112, 10000}, {1113, 10000}, {1114, 10000}, {1115, 10000}, {1116, 10000}, {1117, 10000}, {1118, 10000}, {1119, 10000}, {1120, 10000}, {1121, 10000}, {1122, 10000}, {1123, 10000}, {1124, 10000}, {1125, 10000}, {1126, 10000}, {1127, 10000}, {1128, 10000}, {1129, 10000}, {1130, 10000}, {1131, 10000}, {1132, 10000}, {1133, 10000}, {1134, 10000}, {1135, 10000}, {1136, 10000}, {1137, 10000}, {1138, 10000}, {1139, 10000}, {1140, 10000}, {1141, 10000}, {1142, 10000}, {1143, 10000}, {1144, 10000}, {1145, 10000}, {1146, 10000}, {1147, 10000}, {1148, 10000}, {1149, 10000}, {1150, 10000}, {1151, 10000}, {1152, 10000}, {1153, 10000}, {1154, 10000}, {1155, 10000}, {1156, 10000}, {1157, 10000}, {1158, 10000}, {1159, 10000}, {1160, 10000}, {1161, 10000}, {1162, 10000}, {1163, 10000}, {1164, 10000}, {1165, 10000}, {1166, 10000}, {1167, 10000}, {1168, 10000}, {1169, 10000}, {1170, 10000}, {1171, 10000}, {1172, 10000}, {1173, 10000}, {1174, 10000}, {1175, 10000}, {1176, 10000}, {1177, 10000}, {1178, 10000}, {1179, 10000}, {1180, 10000}, {1181, 10000}, {1182, 10000}, {1183, 10000}, {1184, 10000}, {1185, 10000}, {1186, 10000}, {1187, 10000}, {1188, 10000}, {1189, 10000}, {1190, 10000}, {1191, 10000}, {1192, 10000}, {1193, 10000}, {1194, 10000}, {1195, 10000}, {1196, 10000}, {1197, 10000}, {1198, 10000}, {1199, 10000}, {1200, 10000}, {1201, 10000}, {1202, 10000}, {1203, 10000}, {1204, 10000}, {1205, 10000}, {1206, 10000}, {1207, 10000}, {1208, 10000}, {1209, 10000}, {1210, 10000}, {1211, 10000}, {1212, 10000}, {1213, 10000}, {1214, 10000}, {1215, 10000}, {1216, 10000}, {1217, 10000}, {1218, 10000}, {1219, 10000}, {1220, 10000}, {1221, 10000}, {1222, 10000}, {1223, 10000}, {1224, 10000}, {1225, 10000}, {1226, 10000}, {1227, 10000}, {1228, 10000}, {1229, 10000}, {1230, 10000}, {1231, 10000}, {1232, 10000}, {1233, 10000}, {1234, 10000}, {1235, 10000}, {1236, 10000}, {1237, 10000}, {1238, 10000}, {1239, 10000}, {1240, 10000}, {1241, 10000}, {1242, 10000}, {1243, 10000}, {1244, 10000}, {1245, 10000}, {1246, 10000}, {1247, 10000}, {1248, 10000}, {1249, 10000}, {1250, 10000}, {1251, 10000}, {1252, 10000}, {1253, 10000}, {1254, 10000}, {1255, 10000}, {1256, 10000}, {1257, 10000}, {1258, 10000}, {1259, 10000}, {1260, 10000}, {1261, 10000}, {1262, 10000}, {1263, 10000}, {1264, 10000}, {1265, 10000}, {1266, 10000}, {1267, 10000}, {1268, 10000}, {1269, 10000}, {1270, 10000}, {1271, 10000}, {1272, 10000}, {1273, 10000}, {1274, 10000}, {1275, 10000}, {1276, 10000}, {1277, 10000}, {1278, 10000}, {1279, 10000}, {1280, 10000}, {1281, 10000}, {1282, 10000}, {1283, 10000}, {1284, 10000}, {1285, 10000}, {1286, 10000}, {1287, 10000}, {1288, 10000}, {1289, 10000}, {1290, 10000}, {1291, 10000}, {1292, 10000}, {1293, 10000}, {1294, 10000}, {1295, 10000}, {1296, 10000}, {1297, 10000}, {1298, 10000}, {1299, 10000}, {1300, 10000}, {1301, 10000}, {1302, 10000}, {1303, 10000}, {1304, 10000}, {1305, 10000}, {1306, 10000}, {1307, 10000}, {1308, 10000}, {1309, 10000}, {1310, 10000}, {1311, 10000}, {1312, 10000}, {1313, 10000}, {1314, 10000}, {1315, 10000}, {1316, 10000}, {1317, 10000}, {1318, 10000}, {1319, 10000}, {1320, 10000}, {1321, 10000}, {1322, 10000}, {1323, 10000}, {1324, 10000}, {1325, 10000}, {1326, 10000}, {1327, 10000}, {1328, 10000}, {1329, 10000}, {1330, 10000}, {1331, 10000}, {1332, 10000}, {1333, 10000}, {1334, 10000}, {1335, 10000}, {1336, 10000}, {1337, 10000}, {1338, 10000}, {1339, 10000}, {1340, 10000}, {1341, 10000}, {1342, 10000}, {1343, 10000}, {1344, 10000}, {1345, 10000}, {1346, 10000}, {1347, 10000}, {1348, 10000}, {1349, 10000}, {1350, 10000}, {1351, 10000}, {1352, 10000}, {1353, 10000}, {1354, 10000}, {1355, 10000}, {1356, 10000}, {1357, 10000}, {1358, 10000}, {1359, 10000}, {1360, 10000}, {1361, 10000}, {1362, 10000}, {1363, 10000}, {1364, 10000}, {1365, 10000}, {1366, 10000}, {1367, 10000}, {1368, 10000}, {1369, 10000}, {1370, 10000}, {1371, 10000}, {1372, 10000}, {1373, 10000}, {1374, 10000}, {1375, 10000}, {1376, 10000}, {1377, 10000}, {1378, 10000}, {1379, 10000}, {1380, 10000}, {1381, 10000}, {1382, 10000}, {1383, 10000}, {1384, 10000}, {1385, 10000}, {1386, 10000}, {1387, 10000}, {1388, 10000}, {1389, 10000}, {1390, 10000}, {1391, 10000}, {1392, 10000}, {1393, 10000}, {1394, 10000}, {1395, 10000}, {1396, 10000}, {1397, 10000}, {1398, 10000}, {1399, 10000}, {1400, 10000}, {1401, 10000}, {1402, 10000}, {1403, 10000}, {1404, 10000}, {1405, 10000}, {1406, 10000}, {1407, 10000}, {1408, 10000}, {1409, 10000}, {1410, 10000}, {1411, 10000}, {1412, 10000}, {1413, 10000}, {1414, 10000}, {1415, 10000}, {1416, 10000}, {1417, 10000}, {1418, 10000}, {1419, 10000}, {1420, 10000}, {1421, 10000}, {1422, 10000}, {1423, 10000}, {1424, 10000}, {1425, 10000}, {1426, 10000}, {1427, 10000}, {1428, 10000}, {1429, 10000}, {1430, 10000}, {1431, 10000}, {1432, 10000}, {1433, 10000}, {1434, 10000}, {1435, 10000}, {1436, 10000}, {1437, 10000}, {1438, 10000}, {1439, 10000}, {1440, 10000}, {1441, 10000}, {1442, 10000}, {1443, 10000}, {1444, 10000}, {1445, 10000}, {1446, 10000}, {1447, 10000}, {1448, 10000}, {1449, 10000}, {1450, 10000}, {1451, 10000}, {1452, 10000}, {1453, 10000}, {1454, 10000}, {1455, 10000}, {1456, 10000}, {1457, 10000}, {1458, 10000}, {1459, 10000}, {1460, 10000}, {1461, 10000}, {1462, 10000}, {1463, 10000}, {1464, 10000}, {1465, 10000}, {1466, 10000}, {1467, 10000}, {1468, 10000}, {1469, 10000}, {1470, 10000}, {1471, 10000}, {1472, 10000}, {1473, 10000}, {1474, 10000}, {1475, 10000}, {1476, 10000}, {1477, 10000}, {1478, 10000}, {1479, 10000}, {1480, 10000}, {1481, 10000}, {1482, 10000}, {1483, 10000}, {1484, 10000}, {1485, 10000}, {1486, 10000}, {1487, 10000}, {1488, 10000}, {1489, 10000}, {1490, 10000}, {1491, 10000}, {1492, 10000}, {1493, 10000}, {1494, 10000}, {1495, 10000}, {1496, 10000}, {1497, 10000}, {1498, 10000}, {1499, 10000}, {1500, 10000}, {1501, 10000}, {1502, 10000}, {1503, 10000}, {1504, 10000}, {1505, 10000}, {1506, 10000}, {1507, 10000}, {1508, 10000}, {1509, 10000}, {1510, 10000}, {1511, 10000}, {1512, 10000}, {1513, 10000}, {1514, 10000}, {1515, 10000}, {1516, 10000}, {1517, 10000}, {1518, 10000}, {1519, 10000}, {1520, 10000}, {1521, 10000}, {1522, 10000}, {1523, 10000}, {1524, 10000}, {1525, 10000}, {1526, 10000}, {1527, 10000}, {1528, 10000}, {1529, 10000}, {1530, 10000}, {1531, 10000}, {1532, 10000}, {1533, 10000}, {1534, 10000}, {1535, 10000}, {1536, 10000}, {1537, 10000}, {1538, 10000}, {1539, 10000}, {1540, 10000}, {1541, 10000}, {1542, 10000}, {1543, 10000}, {1544, 10000}, {1545, 10000}, {1546, 10000}, {1547, 10000}, {1548, 10000}, {1549, 10000}, {1550, 10000}, {1551, 10000}, {1552, 10000}, {1553, 10000}, {1554, 10000}, {1555, 10000}, {1556, 10000}, {1557, 10000}, {1558, 10000}, {1559, 10000}, {1560, 10000}, {1561, 10000}, {1562, 10000}, {1563, 10000}, {1564, 10000}, {1565, 10000}, {1566, 10000}, {1567, 10000}, {1568, 10000}, {1569, 10000}, {1570, 10000}, {1571, 10000}, {1572, 10000}, {1573, 10000}, {1574, 10000}, {1575, 10000}, {1576, 10000}, {1577, 10000}, {1578, 10000}, {1579, 10000}, {1580, 10000}, {1581, 10000}, {1582, 10000}, {1583, 10000}, {1584, 10000}, {1585, 10000}, {1586, 10000}, {1587, 10000}, {1588, 10000}, {1589, 10000}, {1590, 10000}, {1591, 10000}, {1592, 10000}, {1593, 10000}, {1594, 10000}, {1595, 10000}, {1596, 10000}, {1597, 10000}, {1598, 10000}, {1599, 10000}, {1600, 10000}, {1601, 10000}, {1602, 10000}, {1603, 10000}, {1604, 10000}, {1605, 10000}, {1606, 10000}, {1607, 10000}, {1608, 10000}, {1609, 10000}, {1610, 10000}, {1611, 10000}, {1612, 10000}, {1613, 10000}, {1614, 10000}, {1615, 10000}, {1616, 10000}, {1617, 10000}, {1618, 10000}, {1619, 10000}, {1620, 10000}, {1621, 10000}, {1622, 10000}, {1623, 10000}, {1624, 10000}, {1625, 10000}, {1626, 10000}, {1627, 10000}, {1628, 10000}, {1629, 10000}, {1630, 10000}, {1631, 10000}, {1632, 10000}, {1633, 10000}, {1634, 10000}, {1635, 10000}, {1636, 10000}, {1637, 10000}, {1638, 10000}, {1639, 10000}, {1640, 10000}, {1641, 10000}, {1642, 10000}, {1643, 10000}, {1644, 10000}, {1645, 10000}, {1646, 10000}, {1647, 10000}, {1648, 10000}, {1649, 10000}, {1650, 10000}, {1651, 10000}, {1652, 10000}, {1653, 10000}, {1654, 10000}, {1655, 10000}, {1656, 10000}, {1657, 10000}, {1658, 10000}, {1659, 10000}, {1660, 10000}, {1661, 10000}, {1662, 10000}, {1663, 10000}, {1664, 10000}, {1665, 10000}, {1666, 10000}, {1667, 10000}, {1668, 10000}, {1669, 10000}, {1670, 10000}, {1671, 10000}, {1672, 10000}, {1673, 10000}, {1674, 10000}, {1675, 10000}, {1676, 10000}, {1677, 10000}, {1678, 10000}, {1679, 10000}, {1680, 10000}, {1681, 10000}, {1682, 10000}, {1683, 10000}, {1684, 10000}, {1685, 10000}, {1686, 10000}, {1687, 10000}, {1688, 10000}, {1689, 10000}, {1690, 10000}, {1691, 10000}, {1692, 10000}, {1693, 10000}, {1694, 10000}, {1695, 10000}, {1696, 10000}, {1697, 10000}, {1698, 10000}, {1699, 10000}, {1700, 10000}, {1701, 10000}, {1702, 10000}, {1703, 10000}, {1704, 10000}, {1705, 10000}, {1706, 10000}, {1707, 10000}, {1708, 10000}, {1709, 10000}, {1710, 10000}, {1711, 10000}, {1712, 10000}, {1713, 10000}, {1714, 10000}, {1715, 10000}, {1716, 10000}, {1717, 10000}, {1718, 10000}, {1719, 10000}, {1720, 10000}, {1721, 10000}, {1722, 10000}, {1723, 10000}, {1724, 10000}, {1725, 10000}, {1726, 10000}, {1727, 10000}, {1728, 10000}, {1729, 10000}, {1730, 10000}, {1731, 10000}, {1732, 10000}, {1733, 10000}, {1734, 10000}, {1735, 10000}, {1736, 10000}, {1737, 10000}, {1738, 10000}, {1739, 10000}, {1740, 10000}, {1741, 10000}, {1742, 10000}, {1743, 10000}, {1744, 10000}, {1745, 10000}, {1746, 10000}, {1747, 10000}, {1748, 10000}, {1749, 10000}, {1750, 10000}, {1751, 10000}, {1752, 10000}, {1753, 10000}, {1754, 10000}, {1755, 10000}, {1756, 10000}, {1757, 10000}, {1758, 10000}, {1759, 10000}, {1760, 10000}, {1761, 10000}, {1762, 10000}, {1763, 10000}, {1764, 10000}, {1765, 10000}, {1766, 10000}, {1767, 10000}, {1768, 10000}, {1769, 10000}, {1770, 10000}, {1771, 10000}, {1772, 10000}, {1773, 10000}, {1774, 10000}, {1775, 10000}, {1776, 10000}, {1777, 10000}, {1778, 10000}, {1779, 10000}, {1780, 10000}, {1781, 10000}, {1782, 10000}, {1783, 10000}, {1784, 10000}, {1785, 10000}, {1786, 10000}, {1787, 10000}, {1788, 10000}, {1789, 10000}, {1790, 10000}, {1791, 10000}, {1792, 10000}, {1793, 10000}, {1794, 10000}, {1795, 10000}, {1796, 10000}, {1797, 10000}, {1798, 10000}, {1799, 10000}, {1800, 10000}, {1801, 10000}, {1802, 10000}, {1803, 10000}, {1804, 10000}, {1805, 10000}, {1806, 10000}, {1807, 10000}, {1808, 10000}, {1809, 10000}, {1810, 10000}, {1811, 10000}, {1812, 10000}, {1813, 10000}, {1814, 10000}, {1815, 10000}, {1816, 10000}, {1817, 10000}, {1818, 10000}, {1819, 10000}, {1820, 10000}, {1821, 10000}, {1822, 10000}, {1823, 10000}, {1824, 10000}, {1825, 10000}, {1826, 10000}, {1827, 10000}, {1828, 10000}, {1829, 10000}, {1830, 10000}, {1831, 10000}, {1832, 10000}, {1833, 10000}, {1834, 10000}, {1835, 10000}, {1836, 10000}, {1837, 10000}, {1838, 10000}, {1839, 10000}, {1840, 10000}, {1841, 10000}, {1842, 10000}, {1843, 10000}, {1844, 10000}, {1845, 10000}, {1846, 10000}, {1847, 10000}, {1848, 10000}, {1849, 10000}, {1850, 10000}, {1851, 10000}, {1852, 10000}, {1853, 10000}, {1854, 10000}, {1855, 10000}, {1856, 10000}, {1857, 10000}, {1858, 10000}, {1859, 10000}, {1860, 10000}, {1861, 10000}, {1862, 10000}, {1863, 10000}, {1864, 10000}, {1865, 10000}, {1866, 10000}, {1867, 10000}, {1868, 10000}, {1869, 10000}, {1870, 10000}, {1871, 10000}, {1872, 10000}, {1873, 10000}, {1874, 10000}, {1875, 10000}, {1876, 10000}, {1877, 10000}, {1878, 10000}, {1879, 10000}, {1880, 10000}, {1881, 10000}, {1882, 10000}, {1883, 10000}, {1884, 10000}, {1885, 10000}, {1886, 10000}, {1887, 10000}, {1888, 10000}, {1889, 10000}, {1890, 10000}, {1891, 10000}, {1892, 10000}, {1893, 10000}, {1894, 10000}, {1895, 10000}, {1896, 10000}, {1897, 10000}, {1898, 10000}, {1899, 10000}, {1900, 10000}, {1901, 10000}, {1902, 10000}, {1903, 10000}, {1904, 10000}, {1905, 10000}, {1906, 10000}, {1907, 10000}, {1908, 10000}, {1909, 10000}, {1910, 10000}, {1911, 10000}, {1912, 10000}, {1913, 10000}, {1914, 10000}, {1915, 10000}, {1916, 10000}, {1917, 10000}, {1918, 10000}, {1919, 10000}, {1920, 10000}, {1921, 10000}, {1922, 10000}, {1923, 10000}, {1924, 10000}, {1925, 10000}, {1926, 10000}, {1927, 10000}, {1928, 10000}, {1929, 10000}, {1930, 10000}, {1931, 10000}, {1932, 10000}, {1933, 10000}, {1934, 10000}, {1935, 10000}, {1936, 10000}, {1937, 10000}, {1938, 10000}, {1939, 10000}, {1940, 10000}, {1941, 10000}, {1942, 10000}, {1943, 10000}, {1944, 10000}, {1945, 10000}, {1946, 10000}, {1947, 10000}, {1948, 10000}, {1949, 10000}, {1950, 10000}, {1951, 10000}, {1952, 10000}, {1953, 10000}, {1954, 10000}, {1955, 10000}, {1956, 10000}, {1957, 10000}, {1958, 10000}, {1959, 10000}, {1960, 10000}, {1961, 10000}, {1962, 10000}, {1963, 10000}, {1964, 10000}, {1965, 10000}, {1966, 10000}, {1967, 10000}, {1968, 10000}, {1969, 10000}, {1970, 10000}, {1971, 10000}, {1972, 10000}, {1973, 10000}, {1974, 10000}, {1975, 10000}, {1976, 10000}, {1977, 10000}, {1978, 10000}, {1979, 10000}, {1980, 10000}, {1981, 10000}, {1982, 10000}, {1983, 10000}, {1984, 10000}, {1985, 10000}, {1986, 10000}, {1987, 10000}, {1988, 10000}, {1989, 10000}, {1990, 10000}, {1991, 10000}, {1992, 10000}, {1993, 10000}, {1994, 10000}, {1995, 10000}, {1996, 10000}, {1997, 10000}, {1998, 10000}, {1999, 10000}, {2000, 10000}, {2001, 10000}, {2002, 10000}, {2003, 10000}, {2004, 10000}, {2005, 10000}, {2006, 10000}, {2007, 10000}, {2008, 10000}, {2009, 10000}, {2010, 10000}, {2011, 10000}, {2012, 10000}, {2013, 10000}, {2014, 10000}, {2015, 10000}, {2016, 10000}, {2017, 10000}, {2018, 10000}, {2019, 10000}, {2020, 10000}, {2021, 10000}, {2022, 10000}, {2023, 10000}, {2024, 10000}, {2025, 10000}, {2026, 10000}, {2027, 10000}, {2028, 10000}, {2029, 10000}, {2030, 10000}, {2031, 10000}, {2032, 10000}, {2033, 10000}, {2034, 10000}, {2035, 10000}, {2036, 10000}, {2037, 10000}, {2038, 10000}, {2039, 10000}, {2040, 10000}, {2041, 10000}, {2042, 10000}, {2043, 10000}, {2044, 10000}, {2045, 10000}, {2046, 10000}, {2047, 10000}, {2048, 10000}, {2049, 10000}, {2050, 10000}, {2051, 10000}, {2052, 10000}, {2053, 10000}, {2054, 10000}, {2055, 10000}, {2056, 10000}, {2057, 10000}, {2058, 10000}, {2059, 10000}, {2060, 10000}, {2061, 10000}, {2062, 10000}, {2063, 10000}, {2064, 10000}, {2065, 10000}, {2066, 10000}, {2067, 10000}, {2068, 10000}, {2069, 10000}, {2070, 10000}, {2071, 10000}, {2072, 10000}, {2073, 10000}, {2074, 10000}, {2075, 10000}, {2076, 10000}, {2077, 10000}, {2078, 10000}, {2079, 10000}, {2080, 10000}, {2081, 10000}, {2082, 10000}, {2083, 10000}, {2084, 10000}, {2085, 10000}, {2086, 10000}, {2087, 10000}, {2088, 10000}, {2089, 10000}, {2090, 10000}, {2091, 10000}, {2092, 10000}, {2093, 10000}, {2094, 10000}, {2095, 10000}, {2096, 10000}, {2097, 10000}, {2098, 10000}, {2099, 10000}, {2100, 10000}, {2101, 10000}, {2102, 10000}, {2103, 10000}, {2104, 10000}, {2105, 10000}, {2106, 10000}, {2107, 10000}, {2108, 10000}, {2109, 10000}, {2110, 10000}, {2111, 10000}, {2112, 10000}, {2113, 10000}, {2114, 10000}, {2115, 10000}, {2116, 10000}, {2117, 10000}, {2118, 10000}, {2119, 10000}, {2120, 10000}, {2121, 10000}, {2122, 10000}, {2123, 10000}, {2124, 10000}, {2125, 10000}, {2126, 10000}, {2127, 10000}, {2128, 10000}, {2129, 10000}, {2130, 10000}, {2131, 10000}, {2132, 10000}, {2133, 10000}, {2134, 10000}, {2135, 10000}, {2136, 10000}, {2137, 10000}, {2138, 10000}, {2139, 10000}, {2140, 10000}, {2141, 10000}, {2142, 10000}, {2143, 10000}, {2144, 10000}, {2145, 10000}, {2146, 10000}, {2147, 10000}, {2148, 10000}, {2149, 10000}, {2150, 10000}, {2151, 10000}, {2152, 10000}, {2153, 10000}, {2154, 10000}, {2155, 10000}, {2156, 10000}, {2157, 10000}, {2158, 10000}, {2159, 10000}, {2160, 10000}, {2161, 10000}, {2162, 10000}, {2163, 10000}, {2164, 10000}, {2165, 10000}, {2166, 10000}, {2167, 10000}, {2168, 10000}, {2169, 10000}, {2170, 10000}, {2171, 10000}, {2172, 10000}, {2173, 10000}, {2174, 10000}, {2175, 10000}, {2176, 10000}, {2177, 10000}, {2178, 10000}, {2179, 10000}, {2180, 10000}, {2181, 10000}, {2182, 10000}, {2183, 10000}, {2184, 10000}, {2185, 10000}, {2186, 10000}, {2187, 10000}, {2188, 10000}, {2189, 10000}, {2190, 10000}, {2191, 10000}, {2192, 10000}, {2193, 10000}, {2194, 10000}, {2195, 10000}, {2196, 10000}, {2197, 10000}, {2198, 10000}, {2199, 10000}, {2200, 10000}, {2201, 10000}, {2202, 10000}, {2203, 10000}, {2204, 10000}, {2205, 10000}, {2206, 10000}, {2207, 10000}, {2208, 10000}, {2209, 10000}, {2210, 10000}, {2211, 10000}, {2212, 10000}, {2213, 10000}, {2214, 10000}, {2215, 10000}, {2216, 10000}, {2217, 10000}, {2218, 10000}, {2219, 10000}, {2220, 10000}, {2221, 10000}, {2222, 10000}, {2223, 10000}, {2224, 10000}, {2225, 10000}, {2226, 10000}, {2227, 10000}, {2228, 10000}, {2229, 10000}, {2230, 10000}, {2231, 10000}, {2232, 10000}, {2233, 10000}, {2234, 10000}, {2235, 10000}, {2236, 10000}, {2237, 10000}, {2238, 10000}, {2239, 10000}, {2240, 10000}, {2241, 10000}, {2242, 10000}, {2243, 10000}, {2244, 10000}, {2245, 10000}, {2246, 10000}, {2247, 10000}, {2248, 10000}, {2249, 10000}, {2250, 10000}, {2251, 10000}, {2252, 10000}, {2253, 10000}, {2254, 10000}, {2255, 10000}, {2256, 10000}, {2257, 10000}, {2258, 10000}, {2259, 10000}, {2260, 10000}, {2261, 10000}, {2262, 10000}, {2263, 10000}, {2264, 10000}, {2265, 10000}, {2266, 10000}, {2267, 10000}, {2268, 10000}, {2269, 10000}, {2270, 10000}, {2271, 10000}, {2272, 10000}, {2273, 10000}, {2274, 10000}, {2275, 10000}, {2276, 10000}, {2277, 10000}, {2278, 10000}, {2279, 10000}, {2280, 10000}, {2281, 10000}, {2282, 10000}, {2283, 10000}, {2284, 10000}, {2285, 10000}, {2286, 10000}, {2287, 10000}, {2288, 10000}, {2289, 10000}, {2290, 10000}, {2291, 10000}, {2292, 10000}, {2293, 10000}, {2294, 10000}, {2295, 10000}, {2296, 10000}, {2297, 10000}, {2298, 10000}, {2299, 10000}, {2300, 10000}, {2301, 10000}, {2302, 10000}, {2303, 10000}, {2304, 10000}, {2305, 10000}, {2306, 10000}, {2307, 10000}, {2308, 10000}, {2309, 10000}, {2310, 10000}, {2311, 10000}, {2312, 10000}, {2313, 10000}, {2314, 10000}, {2315, 10000}, {2316, 10000}, {2317, 10000}, {2318, 10000}, {2319, 10000}, {2320, 10000}, {2321, 10000}, {2322, 10000}, {2323, 10000}, {2324, 10000}, {2325, 10000}, {2326, 10000}, {2327, 10000}, {2328, 10000}, {2329, 10000}, {2330, 10000}, {2331, 10000}, {2332, 10000}, {2333, 10000}, {2334, 10000}, {2335, 10000}, {2336, 10000}, {2337, 10000}, {2338, 10000}, {2339, 10000}, {2340, 10000}, {2341, 10000}, {2342, 10000}, {2343, 10000}, {2344, 10000}, {2345, 10000}, {2346, 10000}, {2347, 10000}, {2348, 10000}, {2349, 10000}, {2350, 10000}, {2351, 10000}, {2352, 10000}, {2353, 10000}, {2354, 10000}, {2355, 10000}, {2356, 10000}, {2357, 10000}, {2358, 10000}, {2359, 10000}, {2360, 10000}, {2361, 10000}, {2362, 10000}, {2363, 10000}, {2364, 10000}, {2365, 10000}, {2366, 10000}, {2367, 10000}, {2368, 10000}, {2369, 10000}, {2370, 10000}, {2371, 10000}, {2372, 10000}, {2373, 10000}, {2374, 10000}, {2375, 10000}, {2376, 10000}, {2377, 10000}, {2378, 10000}, {2379, 10000}, {2380, 10000}, {2381, 10000}, {2382, 10000}, {2383, 10000}, {2384, 10000}, {2385, 10000}, {2386, 10000}, {2387, 10000}, {2388, 10000}, {2389, 10000}}, {new int[]{2388}}};
        for (int i = 0; i < data.length; i += 2) {
            System.out.println("Result: " + smallestChair(data[i], data[i + 1][0][0]));
        }
    }
}
