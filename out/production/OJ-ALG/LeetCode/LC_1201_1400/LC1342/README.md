# 1342: Number of Steps to Reduce a Number to Zero

### Solution: Bit Manipulation
Iterate the binary string of `nums`:
1. When meet `1`: steps += 2, since we do `-1` first and then divide.
2. When meet `0`: steps += 1, since we do divide only.
3. When meet last `1`, just need `-1` and it becomes 0 finally.

**Time Complexity:** `O(logN)`. Convert to binary string takes `O(logN)`.

**Space Complexity:** `O(1)`.