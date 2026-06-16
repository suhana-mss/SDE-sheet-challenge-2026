/*
Question Link:
https://leetcode.com/problems/palindrome-linked-list/

Question:
Check whether a linked list
forms a palindrome.
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
    Find middle.

    Reverse second half.

    Compare first half
    and reversed second half.
    */

    public boolean isPalindrome(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null &&
               fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;
        }

        // Odd length list
        if (fast != null) {
            slow = slow.next;
        }

        ListNode secondHalf = reverse(slow);

        ListNode firstHalf = head;

        while (secondHalf != null) {

            if (firstHalf.val != secondHalf.val) {
                return false;
            }

            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        return true;
    }

    private ListNode reverse(ListNode head) {

        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {

            ListNode front = curr.next;

            curr.next = prev;

            prev = curr;

            curr = front;
        }

        return prev;
    }
}