import java.util.Arrays;
import java.util.Scanner;

/*
Given a string expression representing an expression of fraction addition and subtraction, return the calculation result in string format.

The final result should be an irreducible fraction. If your final result is an integer, change it to the format of a fraction that has a denominator 1. So in this case, 2 should be converted to 2/1.

Example 1:

Input: expression = "-1/2+1/2"
Output: "0/1"
Example 2:

Input: expression = "-1/2+1/2+1/3"
Output: "1/3"
Example 3:

Input: expression = "1/3-1/2"
Output: "-1/6"


Constraints:

The input string only contains '0' to '9', '/', '+' and '-'. So does the output.
Each fraction (input and output) has the format ±numerator/denominator. If the first input fraction or the output is positive, then '+' will be omitted.
The input only contains valid irreducible fractions, where the numerator and denominator of each fraction will always be in the range [1, 10]. If the denominator is 1, it means this fraction is actually an integer in a fraction format defined above.
The number of given fractions will be in the range [1, 10].
The numerator and denominator of the final result are guaranteed to be valid and in the range of 32-bit int.
*/
public class Fraction_Addition_and_Subtraction {
    public String fractionAddition(String expression) {
        int a = 0, b = 1;   //a = numerator, b = denominator
        String[] nums = expression.split("/|(?=[-+])");
        int n = nums.length;
        System.out.println(Arrays.toString(nums));
        for (int i = 0; i < n - 1; i += 2) {
            int c = Integer.parseInt(nums[i]);
            int d = Integer.parseInt(nums[i + 1]);
            a = a * d + b * c;
            b = d * b;
            System.out.println("a: " + a + "\tb: " + b);
            int gcd = get_gcd(a, b);
            a /= gcd;
            b /= gcd;
        }

        return a + "/" + b;
    }

    public int get_gcd(int a, int b) {
        return a == 0 ? Math.abs(b) : get_gcd(b % a, a);
    }
}
