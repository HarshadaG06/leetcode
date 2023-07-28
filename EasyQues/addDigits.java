
/*
26-04-2023
https://leetcode.com/problems/add-digits/

Given an integer num, repeatedly add all its digits until the result has only one digit, and return it.

Examples:
Input: num = 38
Output: 2
Explanation: The process is
38 --> 3 + 8 --> 11
11 --> 1 + 1 --> 2 
Since 2 has only one digit, return it.

Input: num = 0
Output: 0
*/
package EasyQues;
import java.util.*;
public class addDigits{
    public static int addDigitsOfNum(int num) {
        while(true){
            if(num <= 9) break;
            int sum = 0;
            while(num > 0){
                sum = sum + num % 10;
                num/=10;
            }
            num =sum;
        }
        return num;
    }
    public static void main(String args[]){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int sum = addDigitsOfNum(n);
        System.out.println(sum);
        scn.close();
    }
}