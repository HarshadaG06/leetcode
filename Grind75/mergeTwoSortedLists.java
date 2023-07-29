/* 
https://leetcode.com/problems/merge-two-sorted-lists/description/
You are given the heads of two sorted linked lists list1 and list2.

Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.

Return the head of the merged linked list.

Example 1:
Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]

Example 2:
Input: list1 = [], list2 = []
Output: []

Example 3:
Input: list1 = [], list2 = [0]
Output: [0]
 */



public class mergeTwoSortedLists {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int val){this.val = val; }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2){
        ListNode head = null;
        ListNode start = null;

        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }

        while(list1 != null && list2 != null){
            if(list1.val <= list2.val){
                if(head == null){
                    head = list1;
                    start = list1;
                }
                else{
                    start.next = list1;
                    start = start.next;
                }
                list1 = list1.next;
            }
            else if(list1.val > list2.val){
                if(head == null){
                    head = list2;
                    start = list2;
                }
                else{
                    start.next = list2;
                    start = start.next;
                }
                list2 = list2.next;
            }
        }
        if(list1 == null && list2 != null){
            start.next = list2;
        }
        else if(list2 == null && list1 != null){
            start.next = list1;
        }
        return head;
    }
}
