# 2262: Total Appeal of A String

### Solution: DP
Think about how many substring ending at `j` that each substring appeal can contribute at position `j`? 
Given a string like `xxxaxxb` with `s[i] = a` and `s[j] = b`, `s[i]` is the last character `a` before `b`. 
So the total number substring contains last `a` is `i + 1` which is `xxxaxxb`, `xxaxxb` `xaxxb` and `axxb` that can contribute the appeal of substring ending with `j`.

**Time Complexity:** `O(N)`.

**Time Complexity:** `O(1)`.

### Related
828: Count Unique Characters of All Substrings of a Given String.

2262: Total Appeal of A String.