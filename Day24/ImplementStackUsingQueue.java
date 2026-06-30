/*
Question Link:
https://leetcode.com/problems/implement-stack-using-queues/

Question:
Implement LIFO Stack using only Queue operations.
*/

class MyStack {

    Queue<Integer> q;

    public MyStack() {
        q = new LinkedList<>();
    }

    /*
    Push new element.

    Rotate previous elements
    behind the new element.

    Queue front becomes stack top.
    */

    public void push(int x) {
        q.offer(x);

        int size = q.size();

        for(int i = 0; i < size - 1; i++) {
            q.offer(q.poll());
        }
    }

    public int pop() {
        return q.poll();
    }

    public int top() {
        return q.peek();
    }

    public boolean empty() {
        return q.isEmpty();
    }
}