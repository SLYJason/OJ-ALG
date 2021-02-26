# 1675:  Minimize Deviation in Array

### Solution 1: PriorityQueue
Key observations:
1. Only odd number can be increased, and it can be **increased once**.
2. Only even number can be decreased, and it can be **decreased multiple times**, it becomes odd number eventually.

Steps:
1. Double every odd number and push these numbers into max heap. In the meantime, keep tracking the minimum number. 
2. In this case, all numbers become maximum. To find minimum deviation, all need is to decrease the maximum number since minimum number is for sure.
3. Pop maximum number from max heap. If it is an even number, decrease it (divide by 2) and push to the max heap, check the deviation. If the maximum number is already an odd number, stop it.

**Time Complexity:** `O(N * logM * logN)`, `M` is the largest number in `nums`, `N` is the size of `nums`. PriorityQueue operations takes `O(logN)`. In the worst case when `M` is the power of 2, so total pq operations will be `O(logM)` times and if all the numbers are `M`, so total pq operations will be `O(N * logM)`.

**Space Complexity:** `O(N)`.

### Solution 2: TreeSet
Same as Solution 1, but with TreeSet implementation. Benefits using TreeSet is it remove **duplicates**.

**Time Complexity:** `O(N * logM * logN)`.

**Space Complexity:** `O(N)`.