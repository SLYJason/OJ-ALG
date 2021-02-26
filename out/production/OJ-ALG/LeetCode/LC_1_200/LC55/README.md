# 55: Jump Game

### Clarification
If want to reach any position, each jump step can exceed that position, does not need to arrive exactly at that point. This is the key in `Solution 2` and `Solution 3`.

### Solution 1: Backtrack + Memo
**Time Complexity:** `O(N ^ 2)`. Without memorization, the time complexity is `O(2 ^ N)` because for each position we can jump to it or not.

**Space Complexity:** `O(N)`.

### Solution 2: DP
**Time Complexity:** `O(N ^ 2)`.

**Space Complexity:** `O(N)`.

### Solution 3: Greedy
Look backwards from the last index and check if we can reach to the 0 index finally.

**Time Complexity:** `O(N)`.

**Space Complexity:** `O(1)`.

### Related
55: Jump Game.

45: Jump Game II.

1306: Jump Game III.