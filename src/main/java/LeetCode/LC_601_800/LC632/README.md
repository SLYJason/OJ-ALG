# 632: Smallest Range Covering Elements from K Lists

### Solution 1: Brute Force
Get all possible combinations for the list, then find the smallest range.

**Time Complexity:** `O(N ^ N)`.

**Space Complexity:** `O(N)`.

### Solution 2: PriorityQueue
The idea is similar to LC23: Merge K sorted List. Using a PriorityQueue to keep poll the smallest number from the queue and find the smallest range on the fly.

**Time Complexity:** `O(N * K * logK)`. `N` is the average length of each `num` in `nums`, `K` is the length of `nums` aka the size of priority queue. 
Go through all number in `nums` takes `O(N * K)`, each poll operation in priority queue takes `O(logK)`. 

**Space Complexity:** `O(K)`.