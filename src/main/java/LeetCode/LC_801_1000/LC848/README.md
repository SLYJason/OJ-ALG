# 848: Shifting Letters

### Solution 1: Postfix Sum
Similar to prefix sum problems, the number of shift at position `i` is `shifts[i] + shifts[i+1] + ... + shifts[shifts.length - 1]`. Thus, we need to accumulate the sum from the end, more list postfix sum.

**Time Complexity:** `O(N)`. `N` is the length of `shifts` and string `s`.

**Space Complexity:** `O(1)`.

### Related
848: Shifting Letters.

2381: Shifting Letters II.
