/*
03-08-22
https://leetcode.com/problems/letter-combinations-of-a-phone-number/
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number 
could represent. Return the answer in any order.
A mapping of digits to letters (just like on the telephone buttons) is given below. 
Note that 1 does not map to any letters.

Example 1:
Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]

Example 2:
Input: digits = ""
Output: []

Example 3:
Input: digits = "2"
Output: ["a","b","c"]
 */
import java.util.*;
class letterCombinationsOfPhNo {
    public List<String> letterCombinations(String digits) {
       if(digits.length() == 0){
            return new ArrayList<>();
        }
        return getKpc(digits);
    }

    static String[] codes = {"","","abc","def","ghi", "jkl", "mno", "pqrs", "tuv","wxyz"};
    public List<String> getKpc(String digits) {
         if(digits.length() == 0){
            ArrayList<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        }
        char ch = digits.charAt(0);
        String ros = digits.substring(1);
        List<String> rres = getKpc(ros);
        List<String> mres = new ArrayList<>();
        String codeForch = codes[ch-'0'];
        for(int i = 0; i < codeForch.length(); i++){
            char chCode = codeForch.charAt(i);
            for(String rstr:rres){
                mres.add(chCode+rstr);
            }
        }
        return mres;
    }
}