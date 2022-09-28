# 2272 Substring With Largest Variance

### Solution 1: Brute Force - TLE
**Time Complexity:** `O(N ^ 2)`.

**Space Complexity:** `O(1)`.

### Solution 2: Kadane's Algorithm
Similar to the maximum sum subarray problem using the Kadane's algorithm, see [reference](https://medium.com/@rsinghal757/kadanes-algorithm-dynamic-programming-how-and-why-does-it-work-3fd8849ed73d).
In fact, we only need to consider two distinct characters `a` and `b`(`a` and `b` can be any character), see here for [details](https://ssg.leetcode-cn.com/problems/substring-with-largest-variance/solution/by-endlesscheng-5775/).

**Time Complexity:** `O(26 * 26 * N)`.

**Space Complexity:** `O(1)`.
