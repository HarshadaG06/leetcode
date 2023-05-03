/*
03-05-2023
https://leetcode.com/problems/find-the-difference-of-two-arrays/

Given two 0-indexed integer arrays nums1 and nums2, return a list answer of size 2 where:

answer[0] is a list of all distinct integers in nums1 which are not present in nums2.
answer[1] is a list of all distinct integers in nums2 which are not present in nums1.
Note that the integers in the lists may be returned in any order.

Examples:
Input: nums1 = [1,2,3], nums2 = [2,4,6]
Output: [[1,3],[4,6]]
Explanation:
For nums1, nums1[1] = 2 is present at index 0 of nums2, whereas nums1[0] = 1 and nums1[2] = 3 are not present in nums2. Therefore, answer[0] = [1,3].
For nums2, nums2[0] = 2 is present at index 1 of nums1, whereas nums2[1] = 4 and nums2[2] = 6 are not present in nums2. Therefore, answer[1] = [4,6].

Input: nums1 = [1,2,3,3], nums2 = [1,1,2,2]
Output: [[3],[]]
Explanation:
For nums1, nums1[2] and nums1[3] are not present in nums2. Since nums1[2] == nums1[3], their value is only included once and answer[0] = [3].
Every integer in nums2 is present in nums1. Therefore, answer[1] = [].

*/
import java.util.*;
public class findDiffOf2Arrays {
    public static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>>ans = new ArrayList<>();
        Set<Integer> s1 = new HashSet<>();
        Set<Integer> s2 = new HashSet<>();

        for(int i : nums1) {
            s1.add(i);
        }  
        for(int i : nums2) {
          s2.add(i);
        }
        ans.add(new ArrayList());
        ans.add(new ArrayList());
        for(int i : s1){
            if(!s2.contains(i)){
                ans.get(0).add(i);
            }
        }
        for(int i : s2){
            if(!s1.contains(i)){
                ans.get(1).add(i);
            }
        }
        
        return ans;
    }
    public static void main(String args[]){
        Scanner scn = new Scanner(System.in);
        int[] nums1 = {1,2,3};
        int[] nums2 = {2,4,6};
        List<List<Integer>>ans = findDifference(nums1,nums2);
        System.out.println(ans);
        scn.close();
    }
}
