# 1649: Create Sorted Array through Instructions

### Solution: Binary Indexed Tree
Similar LC315, We use BIT to calculate prefix sum of `rank_frequency`.

**Time Complexity:** `O(N * logM)`, `N` is the length of `instructions`,  `M` is the maximum value in `instructions`.

**Space Complexity:** `O(logM)`. We need `M` space to store the BIT, but here we define space as `100001` for simplicity.

### Related  
315: Count of Smaller Numbers After Self.

1649: Create Sorted Array through Instructions.