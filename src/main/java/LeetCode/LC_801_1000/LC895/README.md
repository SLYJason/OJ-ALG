# 895: Maximum Frequency Stack

### Solution: HashMap
Using 2 HashMap:
1. `freq`: `K -> x`, `V -> frequency of x`.
2. `group`: `K -> frequency`, `V -> a stack of numbers x has current freqency`.

**Time Complexity:** `O(1)` for `push()` and `pop()`.

**Space Complexity:** `O(N)`.

### Related
146: LRU Cache.

460: LFU Cache.

895: Maximum Frequency Stack.