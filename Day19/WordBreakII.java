/*
Question Link:
https://leetcode.com/problems/word-break-ii/

Question:
Return all possible sentences that can be formed
using words from the dictionary.
*/

class Solution {

    public List<String> wordBreak(String s, List<String> dict) {

        HashSet<String> set = new HashSet<>();

        for(String word : dict) {
            set.add(word);
        }

        List<String> res = new ArrayList<>();

        solve(0, s, set, res, "");

        return res;
    }

    /*
    Try every possible word starting
    from current index.

    If current substring exists
    in dictionary:

    include it in sentence and recurse.
    */

    void solve(int start, String s, HashSet<String> set,
               List<String> res, String sentence) {

        if(start == s.length()) {
            res.add(sentence.trim());
            return;
        }

        for(int end = start; end < s.length(); end++) {

            String word = s.substring(start, end + 1);

            if(set.contains(word)) {
                solve(end + 1, s, set, res, sentence + word + " ");
            }
        }
    }
}