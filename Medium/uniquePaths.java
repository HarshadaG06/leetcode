/*
03-09-2023
https://leetcode.com/problems/unique-paths/
There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). 
The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). 
The robot can only move either down or right at any point in time.
Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.
The test cases are generated so that the answer will be less than or equal to 2 * 109.

Example - 1
Input: m = 3, n = 7
Output: 28

Example 2:
Input: m = 3, n = 2
Output: 3
Explanation: From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Down -> Down
2. Down -> Down -> Right
3. Down -> Right -> Down

 */

import java.util.*;
public class uniquePaths {
    public int uniquePath(int m, int n) {
        int[][] dp = new int[m][n];
         for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }
        return getPaths(0, 0, m, n, dp);
    }
    public int getPaths(int i, int j, int m, int n, int[][] dp){
        if(dp[i][j] != -1) return dp[i][j];
        if(i == m-1 && j == n-1){
            return 1;
        }
        int rightPaths = 0;
        int downPaths = 0;
        if(i < m-1){
            rightPaths = getPaths(i+1, j, m, n, dp);
        }
        if(j < n-1){
            downPaths = getPaths(i, j+1, m, n, dp);
        }
        dp[i][j] = rightPaths + downPaths;
        return dp[i][j];
    }
}