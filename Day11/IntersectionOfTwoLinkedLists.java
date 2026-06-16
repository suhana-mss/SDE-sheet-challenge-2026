/*
Question Link:
https://leetcode.com/problems/intersection-of-two-linked-lists/

Question:
Find the node where two linked lists intersect.
Return null if no intersection exists.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
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
    Traverse both lists.

    When pointer reaches end:
    switch to other list.

    This equalizes path lengths.

    If intersection exists:
    both pointers meet there.

    Otherwise:
    both become null together.
    */

    public ListNode getIntersectionNode(
            ListNode headA,
            ListNode headB) {

        ListNode a = headA;
        ListNode b = headB;

        while (a != b) {

            if (a == null) {
                a = headB;
            } else {
                a = a.next;
            }

            if (b == null) {
                b = headA;
            } else {
                b = b.next;
            }
        }

        return b;
    }
}