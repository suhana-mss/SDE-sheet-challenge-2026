/*
Question Link:
https://leetcode.com/problems/implement-queue-using-stacks/

Question:
Implement FIFO Queue using two stacks.
*/

class MyQueue {

    Stack<Integer> input;
    Stack<Integer> output;

    public MyQueue() {
        input = new Stack<>();
        output = new Stack<>();
    }

    public void push(int x) {
        input.push(x);
    }

    /*
    If output stack is empty,
    move all elements from input.

    This reverses order and gives
    queue behaviour.
    */

    public int pop() {

        if(output.isEmpty()) {
            while(!input.isEmpty()) {
                output.push(input.pop());
            }
        }

        return output.pop();
    }

    public int peek() {

        if(output.isEmpty()) {
            while(!input.isEmpty()) {
                output.push(input.pop());
            }
        }

        return output.peek();
    }

    public boolean empty() {
        return input.isEmpty() && output.isEmpty();
    }
}