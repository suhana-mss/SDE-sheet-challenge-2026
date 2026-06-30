/*
Question Link:
https://leetcode.com/problems/find-median-from-data-stream/

Question:
Design a data structure that supports:
1. addNum()
2. findMedian()
*/

class MedianFinder {

    PriorityQueue<Integer> left;
    PriorityQueue<Integer> right;

    public MedianFinder() {

        // Max Heap -> smaller half
        left = new PriorityQueue<>((a, b) -> b - a);

        // Min Heap -> larger half
        right = new PriorityQueue<>();
    }

    /*
    Maintain two heaps:

    left  -> smaller half
    right -> larger half

    Keep:
    left.size() == right.size()
    OR
    left.size() == right.size() + 1
    */

    public void addNum(int num) {

        if(left.isEmpty() || num <= left.peek()) {
            left.offer(num);
        } else {
            right.offer(num);
        }

        // Balance heaps.
        if(left.size() > right.size() + 1) {
            right.offer(left.poll());
        }
        else if(right.size() > left.size()) {
            left.offer(right.poll());
        }
    }

    public double findMedian() {

        if(left.size() == right.size()) {
            return (left.peek() + right.peek()) / 2.0;
        }

        return left.peek();
    }
}