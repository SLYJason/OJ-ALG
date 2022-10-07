# 359: Logger Rate Limiter

### Solution 1: Queue + Set
**Time Complexity:** `O(N)`. `N` is the size of the queue, in the worse case all messages in the queue are obsolete so need to clean it up.

**Space Complexity:** `O(N)`.

### Solution 2: Map.
**Time Complexity:** `O(1)`.

**Space Complexity:** `O(N)`.

### Related
359: Logger Rate Limiter.

362: Design Hit Counter.
