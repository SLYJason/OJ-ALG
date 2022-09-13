# 1981: Minimize the Difference Between Target and Chosen Elements

### Solution 1: Brute Force - TLE
Explore all the possibilities of the row sum and then find the minimum absolute difference.

**Time Complexity:** `O(N ^ M)`. Given the `M * N` matrix, there are `N ^ M` total possibilities.

**Space Complexity:** `O(N ^ M)`. The set consumes `O(N ^ M)` space.

### Solution 2: Sorting + Prune
An optimization of brute force, first add two base cases to make the program exit earlier by sorting each row:
1. If sum of the every row first number is **bigger** than the target, then return `Math.abs(target - min)`.
2. If sum of the every row last number is **smaller** than the target, then return `Math.abs(target - max)`.

Then prune the whole loop to make it exit earlier if `sum + n > target` so we don't need to check the rest of the row.

**Time Complexity:** `O(M * N * logN + N ^ M)`. Sorting row by row takes `O(M * N * logN)`, same as brute force worst cases sill have `N ^ M` total possibilities.

**Space Complexity:** `O(N ^ M)`. The set consumes `O(N ^ M)` space.
