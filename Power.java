/*
24-07-23
https://leetcode.com/problems/powx-n/description/
Implement pow(x, n), which calculates x raised to the power n (i.e., xn).

Example 1:

Input: x = 2.00000, n = 10
Output: 1024.00000
Example 2:

Input: x = 2.10000, n = 3
Output: 9.26100
Example 3:

Input: x = 2.00000, n = -2
Output: 0.25000
Explanation: 2-2 = 1/22 = 1/4 = 0.25
 */
public class Power {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        double xpnb2 = myPow(x, n / 2);
        
        if (n % 2 == 0) {
            // n is even
            return xpnb2 * xpnb2;
        } else {
            // n is odd
            if (n > 0) {
                return xpnb2 * xpnb2 * x;
            } else {
                return xpnb2 * xpnb2 * (1 / x);
            }
        }
    }
}
