/*
Question Link:
https://leetcode.com/problems/valid-parentheses/

Question:
Given a string containing only (), {}, [],
determine whether the input string is valid.
*/

class Solution {

    /*
        Push the expected closing bracket.

        When a closing bracket comes,
        it should match the top.

        At the end,
        stack must be empty.
    */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for(char c : s.toCharArray()) {

            if(c == '(') {
                stack.push(')');
            }
            else if(c == '{') {
                stack.push('}');
            }
            else if(c == '[') {
                stack.push(']');
            }
            else if(stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }

        return stack.isEmpty();
    }
}