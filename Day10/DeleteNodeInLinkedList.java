/*
Question Link:
https://leetcode.com/problems/delete-node-in-a-linked-list/

Question:
Delete given node from linked list.
Access to head is NOT provided.
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {

    /*
    Cannot move backward in singly linked list.

    So:
    copy next node value into current node
    and skip next node.
     */
    public void deleteNode(ListNode node) {

        node.val = node.next.val;

        node.next = node.next.next;
    }
}
