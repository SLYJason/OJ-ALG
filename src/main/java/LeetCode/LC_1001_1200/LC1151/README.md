# 1151: Minimum Swaps to Group All 1's Together

### Solution: Sliding Window
To group these 1, there must have a subarray contains all 1 eventually. So in this case, we can use the sliding window.

Count the number of all 1 as `ones`. Then set the window size as `ones` and move the window to count the number of 1 inside the window as `windowOnes`. 
`ones - windowOnes` is the number of 0 inside the window and the `min(ones - windowOnes)` is the number of minimum swaps need to be performed to group all 1.

**Time Complexity:** `O(N)`.

**Space Complexity:** `O(1)`.

### Related
1151: Minimum Swaps to Group All 1's Together.

1703: Minimum Adjacent Swaps for K Consecutive Ones.