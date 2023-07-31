
/*
14-04-2023
https://leetcode.com/problems/longest-palindromic-subsequence/

Given a string s, find the longest palindromic subsequence's length in s.

A subsequence is a sequence that can be derived from another sequence by deleting some or no elements without
changing the order of the remaining elements.

Examples:
Input: s = "bbbab"
Output: 4
Explanation: One possible longest palindromic subsequence is "bbbb".

Input: s = "cbbd"
Output: 2
Explanation: One possible longest palindromic subsequence is "bb".
*/
import java.util.*;
public class longestPalindromeIterative {
    public static int longestPalindromeSubseq(String s) {
       String rs = new StringBuilder(s).reverse().toString();
       int n = s.length();
       int[] prev = new int[n+1];
       for(int i = 1; i <= n; i++){
        int[] curr = new int[n+1];
        for(int j = 1; j <= n; j++){
            if(s.charAt(i-1) == rs.charAt(j-1)){
                curr[j] = 1 + prev[j-1];
            }
            else{
                curr[j] = Math.max(prev[j], curr[j-1]);
            }
        }
        prev = curr;
       }
       return prev[n];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = "bab";
        int length = longestPalindromeSubseq(str);
        System.out.println(length);
        sc.close();
    }
}