import java.util.*;
public class longestPalindromicSubsequenceDP {
    static int [][]dp;
    public static int helper(String str, int left, int right){
        if(left > right){
            return 0;
        }
        if(left == right){
            return 1;
        }
        if(dp[left][right] != -1){
            return dp[left][right];
        }
        if(str.charAt(left) == str.charAt(right)){
            return dp[left][right] = 2 + helper(str, left + 1, right - 1);
        }
        else{
            return dp[left][right] = Math.max(helper(str, left + 1, right), helper(str, left, right - 1));
        }
    }
    public static int longestPalindromeSubseq(String s) {
        int n = s.length();
        dp = new int [n][n];
        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i],-1);

        }
        return helper(s, 0, n-1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = "bab";
        int length = longestPalindromeSubseq(str);
        System.out.println(length);
        sc.close();
    }
}