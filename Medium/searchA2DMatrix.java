/*
 07-08-23
 https://leetcode.com/problems/search-a-2d-matrix/
 
 You are given an m x n integer matrix matrix with the following two properties:

Each row is sorted in non-decreasing order.
The first integer of each row is greater than the last integer of the previous row.
Given an integer target, return true if target is in matrix or false otherwise.

Example 1 : 
Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
Output: true

Example 2:
Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
Output: false

Intuition :

Enter the matrix from any of the four corners.
For example:

Target = 3

1 3 5 7
10 11 16 20
23 30 34 60

The top left corner and bottom right corners are unsuitable for entry because:

Top left : We start at 1 < 3. Since both the adjacent elements 3 and 10 are greater than 1, we are stuck
Bottom right : We start at 60 > 3. Since both the adjacent elements are smaller than 60, again we're stuck.
Hence, top right and bottom left are good places to begin.

Let's build a solution with entering the matrix from the top right corner.

Approach:
Before starting the search, we initialize two variables, row = 0 and column = n-1.
We loop through the 2D matrix till row < n and col >= 0.
Inside the loop, We first check if matrix[row][col] is equal to target. If yes, we return true.
If the target is lesser than the current element, we reduce col by 1.
If the target is greater than current element, we increase row by one.
If the loop is complete without finding the element, we return false.

 */
public class searchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int data) {
        int nc = matrix[0].length;
        int nr = matrix.length;
        int row = 0;
        int col = nc-1;
        while(row < nr && col >= 0){
            if(matrix[row][col] == data){
                return true;
            }
            if(matrix[row][col] > data){
                col--;
            }
            else{
                row++;
            }
        }
        return false;
    }
}
