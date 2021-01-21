# 1673: Find the Most Competitive Subsequence

### Solution: Stack
Scan the whole array, we want to find the smallest element as much as possible. Using a stack to keep tracking, if current element is smaller than the top of the stack, we replace it. One thing need to note here is we have to make sure have enough rest elements can be pushed.

**Time Complexity:** `O(N)`.

**Space Complexity:** `O(k)`.