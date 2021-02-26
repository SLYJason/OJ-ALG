# 340: Longest Substring with At Most K Distinct Characters

### Solution 1 & 2: Sliding Window v1, v2
Both `Solution_1` and `Solution_2` are same logic, just different implementation.

Map structure: `Key` -> `Character`, `Value` -> `count of Character`.

**Time Complexity:** `O(N)`, `N` is the length of string.

**Space Complexity:** `O(k)`, since `HashMap` contains `k` entries at most.

### Solution 3: Sliding Window v3
Map structure: `Key` -> `Character`, `Value` -> `rightmost index of Character`.

Time Complexity and Space Complexity same as `Solution_1` and `Solution_2`.

### Related
3: Longest Substring Without Repeating Characters.

159: Longest Substring with At Most Two Distinct Characters.

340: Longest Substring with At Most K Distinct Characters.