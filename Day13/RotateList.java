/*
Question Link:
https://leetcode.com/problems/rotate-list/

Question:
Rotate linked list to the right by k places.
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
    Find length of list.

    Connect tail to head
    to form a circular list.

    Move to new tail position.

    Break circle and return new head.
    */

    public ListNode rotateRight(
            ListNode head,
            int k) {

        if (head == null ||
            head.next == null) {

            return head;
        }

        ListNode temp = head;

        int nodes = 0;

        ListNode dummy = new ListNode(0);

        dummy.next = temp;

        while (temp != null) {

            temp = temp.next;

            nodes++;

            dummy = dummy.next;
        }

        // Make circular list
        dummy.next = head;

        k = k % nodes;

        temp = head;

        for (int i = 1;
             i <= nodes - k;
             i++) {

            temp = temp.next;

            dummy = dummy.next;
        }

        // Break circle
        dummy.next = null;

        return temp;
    }
}