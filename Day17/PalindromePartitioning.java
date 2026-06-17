/*
Question Link:
https://leetcode.com/problems/palindrome-partitioning/

Question:
Partition string such that every substring
in the partition is a palindrome.
*/

class Solution {

    public List<List<String>> partition(String s) {

        List<List<String>> res = new ArrayList<>();

        solve(0, s, new ArrayList<>(), res);

        return res;
    }

    /*
    Try every possible cut.

    If current substring is palindrome,
    include it in current partition.

    When start reaches end,
    one valid partition is formed.
    */

    public void solve(int start, String s,
                      List<String> list,
                      List<List<String>> res) {

        if(start == s.length()) {
            res.add(new ArrayList<>(list));
            return;
        }

        for(int end = start; end < s.length(); end++) {

            if(isPalindrome(s, start, end)) {

                list.add(s.substring(start, end + 1));

                solve(end + 1, s, list, res);

                list.remove(list.size() - 1);
            }
        }
    }

    public boolean isPalindrome(String s, int start, int end) {

        while(start < end) {

            if(s.charAt(start) != s.charAt(end)) {
                return false;
            }

            start++;
            end--;
        }

        return true;
    }
}