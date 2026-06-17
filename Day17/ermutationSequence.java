/*
Question Link:
https://leetcode.com/problems/permutation-sequence/

Question:
Return the kth permutation of numbers 1 to n.
*/

class Solution {

    /*
    There are (n-1)! permutations
    starting with each first digit.

    Use k to identify which block
    contains the answer.

    Pick digit, remove it,
    then repeat for remaining positions.
    */

    public static String getPermutation(int n, int k) {

        List<Integer> numbers = new ArrayList<>();

        int fact = 1;

        for(int i = 1; i < n; i++) {
            fact *= i;
        }

        for(int i = 1; i <= n; i++) {
            numbers.add(i);
        }

        k--;

        StringBuilder answer = new StringBuilder();

        while(true) {

            answer.append(numbers.get(k / fact));

            numbers.remove(k / fact);

            if(numbers.size() == 0) {
                break;
            }

            k %= fact;

            fact /= numbers.size();
        }

        return answer.toString();
    }
}