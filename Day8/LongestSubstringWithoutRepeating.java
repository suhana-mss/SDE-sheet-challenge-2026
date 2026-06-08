/*
Question Link:
https://leetcode.com/problems/longest-substring-without-repeating-characters/

Question:
Find length of longest substring
without repeating characters.
 */

class Solution {

    /*
    Sliding Window + HashMap.

    Store latest index of characters.

    If duplicate character appears:
    move left pointer ahead of
    previous occurrence.
     */
    public int lengthOfLongestSubstring(String s) {

        HashMap<Character, Integer> map
                = new HashMap<>();

        int left = 0;

        int maxLen = 0;

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            // Duplicate character found
            if (map.containsKey(ch)) {

                left = Math.max(
                        left,
                        map.get(ch) + 1
                );
            }

            map.put(ch, i);

            maxLen = Math.max(
                    maxLen,
                    i - left + 1
            );
        }

        return maxLen;
    }
}
