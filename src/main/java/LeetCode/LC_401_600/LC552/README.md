# 552: Student Attendance Record II

### Solution 1: Brute Force - TLE
Exploring all string combination possibilities using `A`, `L`, `P`, then find the matched string.

**Time Complexity:** `O(3 ^ N)`. `N` is the number `n`.

**Space Complexity:** `O(N ^ N)`. Recursion tree can go up to depth `N` and each not can represent a string length of `N`.

### Solution 2: DP
Need to break this question: first only consider the awarded string without `A`, i.e. the possible attendance records of length `n` only contains letter `L` and `P`. Then consider add `A` into above string at any position to calculate the final result.

1. String without `A`.

   Scenario A: string end with `P`, the ith position can be inserted either `P` or `L`, so `dp[i] = dp[i - 1]`.

   Scenario B: string end with `L`, the ith position can be inserted as `P` without issues, but inserting `L` need to be careful. 
               For example if inserting `L` an invalid possibility will be `...PLLL` so need to take out the `...PLL` result. So `dp[i] = dp[i - 1] - dp[i - 4]`.
   
   Combine the scenario A and scenario B, we have `dp[i] = 2 * dp[i - 1] - dp[i - 4]`.
2. String with `A`.

   After fill out the `dp` array we can just insert `A` at any position. Assume put `A` at index i: `...(i - 1) A (i + 1)...`. We will have additional total result if put `A` at position i: `dp[i - 1] * dp[n - i]`.

**Time Complexity:** `O(N)`. 

**Space Complexity:** `O(N)`.

### Related
551: Student Attendance Record I.

552: Student Attendance Record II.
