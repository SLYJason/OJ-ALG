# 23: Merge k Sorted Lists

### Solution 1: Brute Force
Merge each list one by one.

**Time Complexity:** `O(k * N)`, `k` is the number of linked lists, `N` is the number of nodes in each linked list.

**Space Complexity:** `O(1)`.

### Solution 2: PriorityQueue
**Time Complexity:** `O(N * logk)`, `k` is the number of linked lists, `N` is the number of nodes in each linked list.

**Space Complexity:** `O(k)`.

### Related
21: Merge Two Sorted Lists.

23: Merge k Sorted Lists.

88: Merge Sorted Array.