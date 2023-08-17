/*
 16-08-23
 https://leetcode.com/problems/sliding-window-maximum/
 
 You are given an array of integers nums, there is a sliding window of size k which is moving from the very left
  of the array to the very right. 
 You can only see the k numbers in the window. 
 Each time the sliding window moves right by one position.
 Return the max sliding window.
 
Example 1:
Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
Output: [3,3,5,5,6,7]
Explanation: 
Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7

Example 2:
Input: nums = [1], k = 1
Output: [1]

Approach:
1. Initialize two pointers, left and right, to define the current sliding window.
2. Initialize maxIndex as the index of the maximum element within the initial window [left, right].
3. Iterate through the array until the sliding window's right pointer reaches the end of the array:
    - If maxIndex is within the current window (maxIndex >= left), add the maximum element within the current window
     to the result (res), increment left, and update right.
    - If maxIndex is not within the current window, check whether the new element at right is greater than or equal 
    to the maximum element in the previous window (maxIndex >= nums[maxIndex]). 
    If so, update maxIndex to the current right index.
    - If neither of the above conditions is met, it means the maximum element within the previous window is not 
    within the current window. In this case, use the maxIndex function to find the maximum element's index 
    within the new window [left, right].

Logic:
The initial window [left, right] contains the first k elements. 
The maxIndex function is used to find the index of the maximum element within this window.
As you slide the window to the right, you need to efficiently update the maxIndex:
If the maximum element from the previous window (maxIndex) is within the current window, 
simply compare the new element at the right pointer with the previous maximum element. 
If it's greater, update maxIndex to the right index.
If the maximum element from the previous window is not within the current window, use the maxIndex function to 
find the maximum element's index within the new window [left, right].
 */
package Hard;

class slidingWindowMax {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n-k+1];
        int left = 0, right = k-1, maxIndex = maxIndex(nums, 0, k-1);
        while(true){
            if(maxIndex >= left) {
                res[left++] = nums[maxIndex];
                right++;
                if(right == n) break;
                if(nums[right] >= nums[maxIndex]) maxIndex = right;

            }
            else{
                if(nums[right] >= nums[maxIndex]-1) maxIndex = right;
                else if(nums[left] >= nums[maxIndex]-1) maxIndex = left;
                else maxIndex = maxIndex(nums, left, right);
            }
        }
        return res;
    }

    public int maxIndex(int[] nums, int start, int end){
        int index = start, val = nums[start];
        for (int i = start + 1; i <= end; i++) {
            if(val <= nums[i]){
                val = nums[i];
                index = i;
            }
        }
        return index;
    }
}