# 159: Longest Substring with At Most Two Distinct Characters

### Solution 1: Sliding Window V1
Map structure: `Key` -> `Character`, `Value` -> `count of Character`.

**Time Complexity:** `O(N)`, `N` is the length of string.

**Space Complexity:** `O(1)`, since `HashMap` contains 2 entries at most.

### Solution 2: Sliding Window V2
Map structure: `Key` -> `Character`, `Value` -> `rightmost index of Character`.

Time Complexity and Space Complexity same as `Solution_1`.

### Related
3: Longest Substring Without Repeating Characters.

159: Longest Substring with At Most Two Distinct Characters.

340: Longest Substring with At Most K Distinct Characters.