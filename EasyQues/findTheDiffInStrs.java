/*
You are given two strings s and t.
String t is generated by random shuffling string s and then add one more letter at a random position.
Return the letter that was added to t.

Example 1:
Input: s = "abcd", t = "abcde"
Output: "e"
Explanation: 'e' is the letter that was added.

Example 2:

Input: s = "", t = "y"
Output: "y" 
*/
public class  findTheDiffInStrs{
    public char findTheDifference(String s, String t) {
        int num = 0;
        for(int ch : t.toCharArray()) {
            num += ch;
        }
        for(int ch : s.toCharArray()) {
            num -= ch;
        }
        return (char) (num);
    }
}