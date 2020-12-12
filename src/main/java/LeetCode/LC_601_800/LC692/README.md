# 692: Top K Frequent Words

### Solution 1: Min-Heap
When meet top K largest or smallest question, rules of thumb: **Largest -> Min Heap, Smallest -> Max Heap**. So in this question, we have to use min heap.

**Time Complexity:** `O(N * logK)`.

**Space Complexity:** `O(N)`.

### Solution 2: Max-Heap
Using max heap increased the time complexity, just for reference here.

**Time Complexity:** `O(N * logN)`.

**Space Complexity:** `O(N)`.

### Related
215: Kth Largest Element in an Array.

347: Top K Frequent Elements.

414: Third Maximum Number.

973: K Closest Points to Origin.

692: Top K Frequent Words.