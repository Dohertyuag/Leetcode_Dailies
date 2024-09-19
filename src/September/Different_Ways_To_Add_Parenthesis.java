package September;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given a string expression of numbers and operators, return all possible results from computing all the different possible ways to group numbers and operators. You may return the answer in any order.

The test cases are generated such that the output values fit in a 32-bit integer and the number of different results does not exceed 104.

Example 1:

Input: expression = "2-1-1"
Output: [0,2]
Explanation:
((2-1)-1) = 0
(2-(1-1)) = 2
Example 2:

Input: expression = "2*3-4*5"
Output: [-34,-14,-10,-10,10]
Explanation:
(2*(3-(4*5))) = -34
((2*3)-(4*5)) = -14
((2*(3-4))*5) = -10
(2*((3-4)*5)) = -10
(((2*3)-4)*5) = 10

Constraints:

1 <= expression.length <= 20
expression consists of digits and the operator '+', '-', and '*'.
All the integer values in the input expression are in the range [0, 99].
The integer values in the input expression do not have a leading '-' or '+' denoting the sign.
*/
public class Different_Ways_To_Add_Parenthesis {
    public List<Integer> diffWaysToCompute(String expresssion) {
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < expresssion.length(); i++) {
            char operator = expresssion.charAt(i);
            if(operator == '+' || operator == '-' || operator == '*' ) {
                List<Integer> left = diffWaysToCompute(expresssion.substring(0, i));
                List<Integer> right = diffWaysToCompute(expresssion.substring(i+1));
                for(int a : left) {
                    for(int b : right) {
                        if(operator == '+') {
                            res.add(a+b);
                        }
                        else if(operator == '-') {
                            res.add(a-b);
                        }
                        else if(operator == '*') {
                            res.add(a*b);
                        }
                    }
                }
            }
        }
        if( res.isEmpty() ) res.add(Integer.parseInt(expresssion));
        return res;
    }

    public void driver() {
        String[] s = {"2-1-1", "2*3-4*5", "99", "9-8+7-6+5-4", "0+0+0+0+0*0+0+0*0+0", "99*87-78+66*55-44+33", "12+34-56*78+90", "1+2-3+4-5+6-7+8-9+10"};
        for(String exp : s) {
            System.out.println(diffWaysToCompute(exp));
        }

    }

}
