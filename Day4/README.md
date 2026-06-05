# Day 4 Notes

## Find the Duplicate Number

Core Idea:

* Treat array like a linked list.
* Value at index acts as next pointer.

Mental Trigger:
“Duplicate number creates a cycle.”

Flow:

1. Use slow and fast pointers
2. Find meeting point inside cycle
3. Reset slow to start
4. Move both one step
5. Meeting point = duplicate number

Important:

* Floyd’s Cycle Detection Algorithm
* No extra space used

Pattern:

* Linked List Cycle Detection

Time: O(n)
Space: O(1)

---

## Set Mismatch

Core Idea:

* Every number should ideally be at index:
  value - 1

Mental Trigger:
“Place every number at its correct index.”

Flow:

1. Cyclic sort array
2. Swap until current number reaches correct index
3. Traverse again
4. Mismatch index gives:
   duplicate + missing number

Important:

* Duplicate blocks correct placement

Pattern:

* Cyclic Sort

Time: O(n)
Space: O(1)

---

## Count Inversions

Core Idea:

* During merge sort:
  if left > right,
  then all remaining left elements form inversions.

Mental Trigger:
“Sorted halves help count inversions efficiently.”

Flow:

1. Divide array
2. Count inversions in left half
3. Count inversions in right half
4. Count cross inversions during merge

Important:

* When arr[left] > arr[right]:
  inversions += mid - left + 1

Pattern:

* Merge Sort

Time: O(n log n)
Space: O(n)