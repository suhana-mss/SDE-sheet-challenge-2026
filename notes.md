# Day 2 Notes

## Maximum Subarray — Kadane’s Algorithm

Core Idea:

* Negative running sum is useless → drop it immediately.
* Keep extending subarray only while it helps increase sum.

Mental Trigger:
“Would I start a new subarray here or continue the old one?”

Pattern:

* Running Sum
* Greedy

Flow:

1. Add current element
2. Update maxSum
3. If running sum < 0 → reset to 0

Time: O(n)
Space: O(1)

---

## Sort Colors — Dutch National Flag

Core Idea:

* Maintain 3 regions:

  * 0s on left
  * 1s in middle
  * 2s on right

Pointers:

* low → next place for 0
* mid → current element
* high → next place for 2

Mental Trigger:
“Partition array into zones.”

Rules:

* 0 → swap(low, mid), low++, mid++
* 1 → mid++
* 2 → swap(mid, high), high--

Important:
After swapping with high, DO NOT move mid immediately because new element needs checking.

Time: O(n)
Space: O(1)

---

## Best Time to Buy and Sell Stock

Core Idea:

* Keep track of cheapest buying price seen so far.
* At every step:
  profit = currentPrice - minPrice

Mental Trigger:
“What’s the best profit if I sell today?”

Flow:

1. Update minimum price
2. Compute current profit
3. Update max profit

Pattern:

* Running minimum
* Greedy

Time: O(n)
Space: O(1)