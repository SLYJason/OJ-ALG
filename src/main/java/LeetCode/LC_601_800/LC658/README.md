# 658: Find K Closest Elements

### Solution 1: Binary Search + Sliding Window
Using binary search to find the closet index to number `x`, then use the sliding window expand left and right to find the closet integers.

**Time complexity**: `O(logN + k)`. Binary search takes `O(logN)`, expand the sliding window takes `O(k)`.

**Space Complexity:** `O(1)`.

### Solution 2: Sort with Custom Comparator
The logic is simple, created a `sorted` array and sort it by compare each number in `arr` with distance to `x`. 
Then take the first `k` numbers from the `sorted` array and sort it again, so it is the final result.

**Time complexity**: `O(N * logN + k * logk)`. Sort `N` element takes `O(N * logN)` time, same time complexity for the `k` elements.

**Space Complexity:** `O(N)`.

### Solution 3: Binary Search to Find the Left Bound
Given it is a sorted array, what is the biggest index of the left bound of the result? The upper limit of the left bound is `arr.length - k`. Using the binary search in the range [0, arr.length - k] to find the left boundary.

**Time complexity**: `O(log(N - k) + k)`. Find the boundary takes `O(log(N - k))` and then takes `O(k)` build the result.

**Space Complexity:** `O(1)`.

### Related
658: Find K Closest Elements.

2239: Find Closest Number to Zero.
