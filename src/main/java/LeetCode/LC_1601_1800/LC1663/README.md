# 1663: Smallest String With A Given Numeric Value

### Solution 1: Greedy Build from Left to Right
From left to right, fill `a` as much as possible. If not able to fill `a`, fill the rest.

**Time Complexity:** `O(N)`.

**Space Complexity:** `O(1)`.

### Solution 2: Greedy Build from Right to Left
Initialize a string with length `n` and fill with it all `a`. Scan from the right to left, fill `z` as much as possible. If not able to fill `z`, fill the rest.
 
**Time Complexity:** `O(N)`.

**Space Complexity:** `O(1)`.