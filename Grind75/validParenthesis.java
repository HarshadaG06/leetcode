/*
https://leetcode.com/problems/valid-parentheses/
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.
 

Example 1:

Input: s = "()"
Output: true
Example 2:

Input: s = "()[]{}"
Output: true
Example 3:

Input: s = "(]"
Output: false */
package Grind75;

import java.util.Stack;

public class validParenthesis {
    public boolean isValid(String s) {
        if (s.length() % 2 != 0) return false;
        Stack<Character> st = new Stack<>();
        for(int idx = 0; idx < s.length(); idx++){
            char ch = s.charAt(idx);
            if(ch == '('|| ch == '[' ||ch == '{')st.push(ch);
            else if(ch == ')'|| ch == ']' ||ch == '}'){
                if(st.size() == 0){
                    return false;//nCB > nOB
                }
                if(ch == ')'){
                    if(st.peek() == '('){
                        st.pop();
                    }
                    else{
                        return false; // invalid pair
                    }
                }
                if(ch == ']'){
                    if(st.peek() == '['){
                        st.pop();
                    }
                    else{
                        return false; // invalid pair
                    }
                }
                if(ch == '}'){
                    if(st.peek() == '{'){
                        st.pop();
                    }
                    else{
                        return false; // invalid pair
                    }
                }
            }
        }
        return st.size() == 0;
    }
}
