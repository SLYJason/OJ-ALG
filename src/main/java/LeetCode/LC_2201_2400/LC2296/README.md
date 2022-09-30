# 2296: Design a Text Editor

### Solution 1: StringBuilder
**Time Complexity:** every operation takes `O(k)`.

**Space Complexity:** `O(N)`. `N` is the total text length.

### Solution 2: Two Stacks
The cursor can split the whole string into left stack or right stack.

**Time Complexity:** every operation takes `O(k)`.

**Space Complexity:** `O(N)`. `N` is the total text length.