# 1249: Minimum Remove to Make Valid Parentheses

### Solution 1: Stack 
**Time Complexity:** `O(N)`.

**Space Complexity:** `O(N)`.

### Solution 2: Two Pass
Traverse `s` two passes, start -> end and end -> start.
```
start -> end: remove redundant ) from s.
end -> start: remove redundant ( from s.
```
So after two passes, we get the balanced string.

**Time Complexity:** `O(N)`.

**Space Complexity:** `O(N)`.

### Related
20: Valid Parentheses.

32: Longest Valid Parentheses.

1249: Minimum Remove to Make Valid Parentheses.