/*
 * 15-08-23
 * https://leetcode.com/problems/partition-list/description/
 * Given the head of a linked list and a value x, partition it such that all nodes less than x come before 
 * nodes greater than or equal to x.
 * You should preserve the original relative order of the nodes in each of the two partitions.
 * 
 * Example 1:
 * Input: head = [1,4,3,2,5,2], x = 3
 * Output: [1,2,2,4,3,5]
 * 
 * Example 2:
 * Input: head = [2,1], x = 2
 * Output: [1,2]
 * 
 */

public class partitionList {
    public class ListNode{
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode partition(ListNode head, int x) {
        ListNode left = new ListNode(0);
        ListNode right = new ListNode(0);

        ListNode leftTail = left;
        ListNode rightTail = right;
        while(head != null){
            if(head.val < x){
                leftTail.next = head;
                leftTail = leftTail.next;
            }
            else{
                rightTail.next = head;
                rightTail = rightTail.next;
            }
            head = head.next;
        }
        leftTail.next = right.next;
        rightTail.next = null;
        return left.next;
    }
}
