package Medium;
/*
13-04-2023
https://leetcode.com/problems/validate-stack-sequences/

Given two integer arrays pushed and popped each with distinct values, return true if this could have been 
the result of a sequence of push and pop operations on an initially empty stack, or false otherwise.

Examples:
Input: pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
Output: true
Explanation: We might do the following sequence:
push(1), push(2), push(3), push(4),
pop() -> 4,
push(5),
pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1

Input: pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
Output: false
Explanation: 1 cannot be popped before 2.
*/
import java.util.*;
class validateSTSeq {
    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        if(pushed.length != popped.length) {
            return false;
        }

        Stack<Integer> stack = new Stack<>();
        int popIndex = 0;

        for(int pushIndex = 0; pushIndex < pushed.length; pushIndex++) {
            stack.push(pushed[pushIndex]);
            
            while(!stack.isEmpty() && stack.peek() == popped[popIndex]) {
                stack.pop();
                popIndex++;
            }
        }

        return stack.isEmpty();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter pushed array elements : ");
        int[]pushed = new int[5];
        int[]popped = new int[5];
        for(int i = 0; i < pushed.length; i++){
            pushed[i] = sc.nextInt();
        }
        System.out.println("Enter popped array elements : ");
        for(int i = 0; i < pushed.length; i++){
            popped[i] = sc.nextInt();
        }
        boolean result = validateStackSequences(pushed,popped);
        System.out.println("The ans is : "+result);
        sc.close();
    }
}