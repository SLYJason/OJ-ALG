# 34: Find First and Last Position of Element in Sorted Array

### Solution: Binary Search
The idea is using 2 times binary search to find `first` index and `last` index respectively.

**Time Complexity:** `O(logN)`.

**Space Complexity:** `O(1)`.

### Follow Up
Q: Find the number of occurrence of k in a sorted array.

A: Just find the first and last index of k in the sorted array, then the answer is `first - last + 1`.
