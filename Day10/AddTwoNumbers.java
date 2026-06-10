/*
Question Link:
https://leetcode.com/problems/add-two-numbers/

Question:
Two linked lists represent numbers.
Add them and return answer as linked list.
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
    Add digits one-by-one
    along with carry.

    Dummy node helps build answer list
    without special first-node handling.
    */

    public ListNode addTwoNumbers(
            ListNode l1,
            ListNode l2) {

        ListNode dummy = new ListNode(0);

        ListNode temp = dummy;

        int carry = 0;

        while (l1 != null ||
               l2 != null ||
               carry != 0) {

            int sum = carry;

            if (l1 != null) {

                sum += l1.val;

                l1 = l1.next;
            }

            if (l2 != null) {

                sum += l2.val;

                l2 = l2.next;
            }

            carry = sum / 10;

            temp.next =
                    new ListNode(sum % 10);

            temp = temp.next;
        }

        return dummy.next;
    }
}