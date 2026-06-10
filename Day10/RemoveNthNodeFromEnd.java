/*
Question Link:
https://leetcode.com/problems/remove-nth-node-from-end-of-list/

Question:
Remove nth node from end of linked list.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) {
 *         this.val = val;
 *         this.next = next;
 *     }
 * }
 */

class Solution {

    /*
    Move fast pointer n steps ahead first.

    Then move slow and fast together.

    When fast reaches end:
    slow reaches node before target.
    */

    public ListNode removeNthFromEnd(
            ListNode head,
            int n) {

        if (head == null ||
            head.next == null) {

            return null;
        }

        ListNode slow = head;

        ListNode fast = head;

        // Move fast ahead by n steps
        for (int i = 0; i < n; i++) {

            fast = fast.next;
        }

        // Remove first node case
        if (fast == null) {

            return head.next;
        }

        while (fast.next != null) {

            slow = slow.next;

            fast = fast.next;
        }

        // Skip target node
        slow.next = slow.next.next;

        return head;
    }
}