/*
22/07/23

https://leetcode.com/problems/knight-probability-in-chessboard/description/

On an n x n chessboard, a knight starts at the cell (row, column) and attempts to make exactly k moves. 
The rows and columns are 0-indexed, so the top-left cell is (0, 0), and the bottom-right cell is (n - 1, n - 1).

Each move is two cells in a cardinal direction, then one cell in an orthogonal direction.

Each time the knight is to move, it chooses one of eight possible moves uniformly at random 
(even if the piece would go off the chessboard) and moves there.

The knight continues moving until it has made exactly k moves or has moved off the chessboard.

Return the probability that the knight remains on the board after it has stopped moving.

Example 1:
Input: n = 3, k = 2, row = 0, column = 0
Output: 0.06250
Explanation: There are two moves (to (1,2), (2,1)) that will keep the knight on the board.
From each of those positions, there are also two moves that will keep the knight on the board.
The total probability the knight stays on the board is 0.0625.

Example 2:

Input: n = 1, k = 0, row = 0, column = 0
Output: 1.00000
*/

import java.util.Arrays;

public class knightsProbabilityInChessboard{
    public double knightProbability(int n, int k, int row, int column) {
        double[][][] memo = new double[n][n][k + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(memo[i][j], -1);
            }
        }
        return findProbability(n, k, row, column, memo);
    }

    public double findProbability(int n, int k, int r, int c, double[][][] memo) {
        if (r < 0 || c < 0 || r >= n || c >= n) {
            return 0;
        } else if (k == 0) {
            return 1;
        } else if (memo[r][c][k] != -1) {
            return memo[r][c][k];
        }

        double totalProbability = 0;
        int[] dr = {-2, -1, 1, 2, 2, 1, -1, -2};
        int[] dc = {1, 2, 2, 1, -1, -2, -2, -1};

        for (int i = 0; i < 8; i++) {
            double prob = 0.125; // Probability of each move (1/8)
            int newRow = r + dr[i];
            int newCol = c + dc[i];
            totalProbability += prob * findProbability(n, k - 1, newRow, newCol, memo);
        }

        memo[r][c][k] = totalProbability; // Memoize the result
        return totalProbability;
    }
}