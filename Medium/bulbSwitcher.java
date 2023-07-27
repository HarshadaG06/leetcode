package Medium;
/*
27-04-2023
https://leetcode.com/problems/bulb-switcher/

There are n bulbs that are initially off. You first turn on all the bulbs, then you turn off every second bulb.

On the third round, you toggle every third bulb (turning on if it's off or turning off if it's on). For the ith round, you toggle every i bulb. For the nth round, you only toggle the last bulb.

Return the number of bulbs that are on after n rounds.

Examples:
Input: n = 3
Output: 1
Explanation: At first, the three bulbs are [off, off, off].
After the first round, the three bulbs are [on, on, on].
After the second round, the three bulbs are [on, off, on].
After the third round, the three bulbs are [on, off, off]. 
So you should return 1 because there is only one bulb is on.

Input: n = 0
Output: 0

Input: n = 1
Output: 1
*/
import java.util.*;
import java.lang.Math;
public class bulbSwitcher {
    public static int bulbSwitch(int n) {
        // List <Integer> ans = new ArrayList<>();
        // for(int i = 1; i*i <= n; i++){
        //     ans.add(i*i);
        // }
        // return ans.size();
        return (int)Math.sqrt(n);
    }
    public static void main(String args[]){
        Scanner scn = new Scanner(System.in);
        int n = 4;
        int ans = bulbSwitch(n);
        System.out.println(ans);
        scn.close();
    }
}
