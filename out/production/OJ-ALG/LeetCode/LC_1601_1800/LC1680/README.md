# 1680: Concatenation of Consecutive Binary Numbers

### Solution 1: Change to Binary String
Given `n = 3`, each number binary representation is:
```
1 -> 1
2 -> 10
3 -> 11
```
When a new number need to be concatenated, convert it to binary string first. Then iterate this binary string, the current result need to be doubled when scan this string before add current binary digit.

**Time Complexity:** `O(N * logN)`, transform to binary string take `O(logN)`.

**Space Complexity:** `O(N)`, need `O(N)` space to store the binary string.

### Solution 2: Bitwise Manipulation
The key observation is when concatenate a new number, current result is shifted to left by the binary representation length of the new number.

Here using `(x & (x - 1)) == 0` to determine a number is a power of 2. If `ith` number is power of 2, increase the current binary representation length.

**Time Complexity:** `O(N)`.

**Space Complexity:** `O(1)`.
