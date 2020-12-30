# 1060: Missing Element in Sorted Array

### Solution 1: Linear
**Time Complexity:** `O(N)`.

**Space Complexity:** `O(1)`.

### Solution 2: Binary Search
Given array `[4,7,9,10]`, if not missing, the valid is `[4,5,6,7,8,9,10]`:

* `nums[nums.length-1] - nums[0] + 1` means total numbers from beginning to ending. In such case, it is 7.
* `nums[nums.length-1] - nums[0] + 1 - n` means total missing numbers from beginning to ending. In such case, it is 3.

Using this logic, we compare `mid` with `left` missing numbers with `k` every time, applying the binary search logic to update `left` and `right`.

**Time Complexity:** `O(logN)`.

**Space Complexity:** `O(1)`.