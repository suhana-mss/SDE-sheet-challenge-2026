/*
Question Link:
https://www.geeksforgeeks.org/problems/flattening-a-linked-list/1

Question:
Flatten a linked list where each node
contains:
1. next pointer
2. bottom pointer

Return a single sorted list using bottom pointers.
*/

/*
class Node {
    int data;
    Node next;
    Node bottom;

    Node(int x) {
        data = x;
        next = null;
        bottom = null;
    }
}
*/

class Solution {

    /*
    Recursively flatten the remaining list.

    Then merge:
    current list
    with already flattened list.

    Similar to merge step
    of merge sort.
    */

    public Node flatten(Node root) {

        if (root == null ||
            root.next == null) {

            return root;
        }

        Node mergedHead =
                flatten(root.next);

        return mergeTwoLists(
                root,
                mergedHead
        );
    }

    public Node mergeTwoLists(
            Node list1,
            Node list2) {

        Node dummy = new Node(0);

        Node temp = dummy;

        while (list1 != null &&
               list2 != null) {

            if (list1.data <= list2.data) {

                temp.bottom = list1;

                list1 = list1.bottom;

            } else {

                temp.bottom = list2;

                list2 = list2.bottom;
            }

            temp = temp.bottom;
        }

        if (list1 != null) {

            temp.bottom = list1;

        } else {

            temp.bottom = list2;
        }

        return dummy.bottom;
    }
}