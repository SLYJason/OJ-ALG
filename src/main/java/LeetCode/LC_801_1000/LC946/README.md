# 946: Validate Stack Sequences

### Solution: Stack
Push element from `pushed` one by one. In each step, pop as much as element from `popped`. Finally, check the stack is empty or not.

**Time Complexity:** `O(N)`.

**Space Complexity:** `O(N)`.