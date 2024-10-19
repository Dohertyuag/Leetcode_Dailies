package October;

/*
Given two positive integers n and k, the binary string Sn is formed as follows:

S1 = "0"
Si = Si - 1 + "1" + reverse(invert(Si - 1)) for i > 1
Where + denotes the concatenation operation, reverse(x) returns the reversed string x, and invert(x) inverts all the bits in x (0 changes to 1 and 1 changes to 0).

For example, the first four strings in the above sequence are:

S1 = "0"
S2 = "011"
S3 = "0111001"
S4 = "011100110110001"
Return the kth bit in Sn. It is guaranteed that k is valid for the given n.



Example 1:

Input: n = 3, k = 1
Output: "0"
Explanation: S3 is "0111001".
The 1st bit is "0".
Example 2:

Input: n = 4, k = 11
Output: "1"
Explanation: S4 is "011100110110001".
The 11th bit is "1".


Constraints:

1 <= n <= 20
1 <= k <= 2^n - 1
*/
public class Find_Kth_Bit_in_Nth_Binary_String {
    public char findKthBit(int n, int k) {
        System.out.println("n : " + n + ", k : " + k);
        if (n == 1) {
            return '0';
        }

        int len = (int) Math.pow(2, n) - 1;

        if (k == ((len / 2) + 1)) {
            return '1';
        }
        else if (k < ((len / 2) + 1)) {
            return findKthBit(n - 1, k);
        }
        else {
            char ch = findKthBit(n - 1, len - k + 1);
            return ch == '0' ? '1' : '0';
        }

    }


    public void driver() {
        int[] data = {2, 2, 3, 1, 4, 11, 4, 12, 3, 5, 3, 2, 20, 243002, 20, 189470, 20, 426580, 20, 1048575, 20, 32944};

        for (int i = 0; i < data.length; i += 2) {
            System.out.println("Result: " + findKthBit(data[i], data[i + 1]));
        }

    }
}
