/*
Question Link:
https://leetcode.com/problems/reverse-nodes-in-k-group/

Question:
Reverse linked list in groups of k.
If remaining nodes are less than k,
leave them unchanged.
*/

class Solution {

    /*
    Find k nodes.

    Reverse current group.

    Reconnect with remaining list.

    prevGroupEnd always points
    to node before current group.

    Stop when fewer than k nodes remain.
    */

    public ListNode reverseKGroup(
            ListNode head,
            int k) {

        if (head == null ||
            head.next == null ||
            k == 1) {

            return head;
        }

        // Helps handle head changes
        ListNode dummy = new ListNode();

        dummy.next = head;

        ListNode prevGroupEnd = dummy;

        while (true) {

            // Find kth node
            ListNode kth =
                    getKthNode(prevGroupEnd, k);

            // Not enough nodes left
            if (kth == null) {
                break;
            }

            ListNode groupStart =
                    prevGroupEnd.next;

            ListNode nextGroupStart =
                    kth.next;

            /*
            Reverse current group.

            Start prev from nextGroupStart
            so reversed group automatically
            connects to remaining list.
            */

            ListNode prev = nextGroupStart;

            ListNode curr = groupStart;

            while (curr != nextGroupStart) {

                ListNode front = curr.next;

                curr.next = prev;

                prev = curr;

                curr = front;
            }

            // kth becomes new group head
            prevGroupEnd.next = kth;

            // groupStart becomes group tail
            prevGroupEnd = groupStart;
        }

        return dummy.next;
    }

    // Returns kth node or null
    private ListNode getKthNode(
            ListNode start,
            int k) {

        while (start != null &&
               k > 0) {

            start = start.next;
            k--;
        }

        return start;
    }
}