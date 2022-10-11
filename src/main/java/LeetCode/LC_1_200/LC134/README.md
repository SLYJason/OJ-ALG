# 134: Gas Station

### Solution 1: Brute Force
**Time Complexity**: `O(N ^ 2)`. `N` is the size of the array.

**Space Complexity**: `O(1)`.

### Solution 2: One Pass
Similar to take the Kadane's idea, if we run out of gas at `i` gas station, all the gas stations between `i` and starting point are bad starting points.
Thus, it means we can start trying at next gas station on the `i + 1`.

**Time Complexity**: `O(N)`.

**Space Complexity**: `O(1)`.
