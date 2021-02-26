# 667: Beautiful Arrangement II

### Solution: Smart Construction
Given `n` numbers, the maximum `k` is `n - 1`. Given `n = 9`, the possible arrangement are:
```
k = 1: [1, 2, 3, 4, 5, 6, 7, 8, 9], increasing array.
k = 2: [1, 9 | 2, 3, 4, 5, 6, 7, 8], we arrange 1 and 9 first, then put the rest number in increasing order.
k = 3: [1, 9, 2 | 3, 4, 5, 6, 7, 8], we select 3 numbers first, then put the rest number in increasing order.
k = 4: [1, 9, 2, 8 | 3, 4, 5, 6, 7], we select 4 numbers first, then put the rest number in increasing order.
```
The code implementation does not generate the same result, above logic is a way of thinking.

**Time Complexity:** `O(N)`.

**Space Complexity:** `O(N)`.

### Related
526: Beautiful Arrangement.

667: Beautiful Arrangement II.