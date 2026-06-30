/*
Question Link:
https://leetcode.com/problems/roman-to-integer/

Question:
Convert a Roman numeral into an integer.
*/

class Solution {

    /*
        Traverse from right to left.

        If current value is smaller than
        previous value, subtract it.

        Otherwise, add it.
    */
    public int romanToInt(String s) {

        int ans = 0;
        int prev = 0;

        for(int i = s.length() - 1; i >= 0; i--) {

            int cur = value(s.charAt(i));

            if(cur < prev) {
                ans -= cur;
            }
            else {
                ans += cur;
            }

            prev = cur;
        }

        return ans;
    }

    int value(char ch) {
        if(ch == 'I') return 1;
        else if(ch == 'V') return 5;
        else if(ch == 'X') return 10;
        else if(ch == 'L') return 50;
        else if(ch == 'C') return 100;
        else if(ch == 'D') return 500;
        else return 1000;
    }
}