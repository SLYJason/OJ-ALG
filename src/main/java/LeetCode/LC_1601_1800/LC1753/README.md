# 1753: Maximum Score From Removing Stones

### Solution 1: PriorityQueue
Always remove stones from the top 2 most piles.

**Time Complexity:** `O(2 * max(a, b, c))`. In the worst case, suppose `a`, `b`, `c` are same, overall PriorityQueue operation will be `2 * max(a, b, c)`. Singe single `poll` takes `log3` time, so it's can be treated as constant time.

**Space Complexity:** `O(1)`.

### Solution 2: Math
Suppose given sorted array `[a, b, c]`, there has 2 scenarios need to consider:
1. `a + b <= c`: we can remove stones from `[a, c]`, then remove stones from `[b, c]`, so the overall score is `a + b`.
2. `a + b > c`: If `a + b + c` is odd, then there must have one pile has left only 1 stone. If `a + b + c` is even, all piles will be 0 eventually. So the score is `(a + b + c) / 2`.

**Time Complexity:** `O(1)`.

**Space Complexity:** `O(1)`.
