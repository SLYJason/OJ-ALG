# 767: Reorganize String

### Solution 1: PriorityQueue
Build a priority queue to store each character frequency. And then keep polling the most **2** frequency char from the queue and place it one by one.

**Time Complexity:** `O(N)`. Sorting using the priority queue is constant since the size of the queue is never bigger than 26.

**Space Complexity:** `O(1)`.

### Solution 2: Smart Filling.
First place the most frequent character into the result by every other slot, i.e. at index 0, 2, 4..., then place the rest character starting from index **1**.

**Time Complexity:** `O(N)`. It uses less time compared to the solution 1 in reality.

**Space Complexity:** `O(1)`.

### Related
621: Task Scheduler.

767: Reorganize String.