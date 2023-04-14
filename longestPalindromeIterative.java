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