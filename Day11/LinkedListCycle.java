/*
Question Link:
https://leetcode.com/problems/linked-list-cycle/

Question:
Determine whether a linked list contains a cycle.
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
    Slow moves 1 step.
    Fast moves 2 steps.

    If cycle exists:
    fast eventually catches slow.

    If fast reaches null:
    no cycle exists.
    */

    public boolean hasCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null &&
               fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }
}