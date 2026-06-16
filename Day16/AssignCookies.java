/*
Question Link:
https://leetcode.com/problems/assign-cookies/

Question:
Maximize number of satisfied children.
Each child needs a minimum cookie size.
*/

class Solution {

    /*
    Sort children and cookies.

    Give the smallest cookie
    that satisfies current child.

    If cookie is too small,
    discard it.
    */

    public int findContentChildren(int[] g, int[] s) {

        Arrays.sort(g);
        Arrays.sort(s);

        int i = 0;
        int j = 0;
        int count = 0;

        while(i < g.length && j < s.length) {

            if(s[j] >= g[i]) {
                count++;
                i++;
                j++;
            } else {
                j++;
            }
        }

        return count;
    }
}