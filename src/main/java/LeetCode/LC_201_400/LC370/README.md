# 370: Range Addition

### Solution 1: Brute Force
**Time Complexity:** `O(N * M)`, where `N` is the length of `arr` and `M` is the length of `updates`.

**Space Complexity:** `O(1)`.

### Solution 2: Optimized
The algorithm is:
1. Loop `updates`: put `inc` at `start` index, and `-inc` at `end + 1` index.
2. Loop `arr`, carry out previous value at index `i - 1` to `i`, accumulate to the end.

The reason is:
- Put `inc` at `start` index allows the **`inc` to be carried to the next index** when we do the sum accumulation.
- Put `-inc` at `end + 1` index simply means **cancel out the previous carry to the next index of the `end` index**, because the previous carry should not be counted beyond `end` index.

**Time Complexity:** `O(N + M)`, where `N` is the length of `arr` and `M` is the length of `updates`.

**Space Complexity:** `O(1)`.

### Related
370: Range Addition.

598: Range Addition II.
