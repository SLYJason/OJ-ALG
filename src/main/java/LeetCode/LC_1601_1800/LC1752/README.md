# 1752: Check if Array Is Sorted and Rotated

### Solution: One Pass
If one array can be rotated to become sorted, only one `nums[i] > nums[i+1]` happens. If more than one happens, return `false`.

**Time Complexity:** `O(N)`.

**Space Complexity:** `O(1)`.