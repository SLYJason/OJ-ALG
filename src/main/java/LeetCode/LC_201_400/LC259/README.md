# 259: 3Sum Smaller

### Solution: Two-Pointers
How two-pointers works here? `3Sum Smaller` can be thought as `2Sum Smaller`. For example:
```
Target: 7
Input: [3,5,2,8,1]
After sorting: [1,2,3,5,8]
```
Initialize `left` and `right` and find `nums[left] + nums[right] = 9 > 7`:
```
[1, 2, 3, 5, 8]
 ↑           ↑
left       right
```
So move `right` to left 1 step:
```
[1, 2, 3, 5, 8]
 ↑        ↑
left    right
```
Now `nums[left] + nums[right] = 6 < 7`, so how many pairs between `left` and `right` meet the requirement `nums[i] + nums[j] < target`? It's `right - left` pairs in total. So we got the answer.

**Time Complexity:** `O(N^2)`.

**Space Complexity:** `O(N)` or `O(logN)` depending on the sorting.

### Related
15: 3Sum.

16: 3Sum Closest

259: 3Sum Smaller.