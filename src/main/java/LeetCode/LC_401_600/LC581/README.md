# 581: Shortest Unsorted Continuous Subarray

### Solution 1: Sorting
**Time Complexity:** `O(N * logN)`.

**Space Complexity:** `O(N)`.

### Solution 2: Stack
It's similar to use monotonous queue:
1. Scan `left -> right`: When the top element of stack is larger than the current element, it means the array is descending, and we can find the left unsorted boundary. 
2. Scan `right -> left`: When the top element of stack is smaller than the current element, it means the array is ascending, and we can find the right unsorted boundary.

**Time Complexity:** `O(N)`.

**Space Complexity:** `O(N)`.

### Solution 3: Optimal Solution
Similar idea using stack:
1. Scan `left -> right`: track the maximum element `max` scanned so far. If the current element is smaller than `max`, keep updating the right boundary.  
2. Scan `right -> left`: track the minimum element `min` scanned so far. If the current element is bigger than `min`, keep updating the left boundary.

**Time Complexity:** `O(N)`.

**Space Complexity:** `O(1)`.