# 1423: Maximum Points You Can Obtain from Cards

### Solution: Sliding Window
We can think another way of this problem: Find the smallest subarray's sum with length `cardPoints.length - k`. Then we can use a sliding window with fixed window size to solve this problem.

**Time Complexity:** `O(N)`.

**Space Complexity:** `O(1)`.