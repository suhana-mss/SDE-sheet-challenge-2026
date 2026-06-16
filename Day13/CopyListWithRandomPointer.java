/*
Question Link:
https://leetcode.com/problems/copy-list-with-random-pointer/

Question:
Create a deep copy of a linked list where each node
contains both next and random pointers.
*/

/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {

    /*
    Step 1:
    Create copy nodes and insert them
    between original nodes.

    Step 2:
    Connect random pointers using:
    original.random.next

    Step 3:
    Separate original list and copied list.
    */

    public Node copyRandomList(Node head) {

        if (head == null) return null;

        // Insert copied nodes in between
        Node temp = head;

        while (temp != null) {

            Node newNode = new Node(temp.val);

            newNode.next = temp.next;

            temp.next = newNode;

            temp = temp.next.next;
        }

        // Connect random pointers
        temp = head;

        while (temp != null) {

            if (temp.random != null) {

                temp.next.random =
                        temp.random.next;
            }

            temp = temp.next.next;
        }

        // Extract copied list
        Node dummy = new Node(-1);

        Node res = dummy;

        temp = head;

        while (temp != null) {

            res.next = temp.next;

            temp.next = temp.next.next;

            res = res.next;

            temp = temp.next;
        }

        return dummy.next;
    }
}