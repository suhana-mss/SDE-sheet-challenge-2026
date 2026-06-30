/*
Question Link:
https://leetcode.com/problems/min-stack/

Question:
Design a stack that supports:

push()
pop()
top()
getMin()

All operations should work in O(1).
*/


import java.util.Stack;
/*
    x >= min -> x is a normal value.
    x < min -> x is an encoded value.
    Actual popped value = min.
    Previous minimum = 2 * min - x.
*/
class MinStack {
    private Stack<Long> stack;   // use Long instead of Integer
    private long min;            // use long to avoid overflow

    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int val) {
       if (stack.isEmpty()) {
           stack.push((long) val);
           min = val;
       } else {
           if (val >= min) stack.push((long) val);
           else {
               stack.push(2L * val - min); // use long arithmetic
               min = val;
           }
       }
    }
    
    public void pop() {
        if (stack.isEmpty()) return;
        long x = stack.pop();
        if (x < min) {
            min = 2 * min - x;   // restore previous min
        }
    }
    
    public int top() {
        if (stack.isEmpty()) throw new RuntimeException("Stack is empty!");
        long x = stack.peek();
        if (x >= min) return (int) x;
        else return (int) min;
    }
    
    public int getMin() {
        if (stack.isEmpty()) throw new RuntimeException("Stack is empty!");
        return (int) min;

    }
}