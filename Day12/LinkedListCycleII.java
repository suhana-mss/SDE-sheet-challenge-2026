/*
Question Link:
https://leetcode.com/problems/linked-list-cycle-ii/

Question:
Return the node where the cycle begins.
Return null if no cycle exists.
 */

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {

    /*
    Detect cycle using Floyd's Algorithm.

    Once slow and fast meet:
    reset slow to head.

    Move both one step at a time.

    Their next meeting point
    is the start of the cycle.
     */
    public ListNode detectCycle(ListNode head) {

        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null
                && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {

                slow = head;

                while (slow != fast) {

                    slow = slow.next;
                    fast = fast.next;
                }

                return slow;
            }
        }

        return null;
    }
}
