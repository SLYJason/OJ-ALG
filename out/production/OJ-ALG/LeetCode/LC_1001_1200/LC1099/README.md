# 1099: Two Sum Less Than K
### Clarification
We can use sorting here since `i < j` does not matter because we can swap them: `A[j] + A[i] == A[i] + A[j]`. As long as we need to make sure `i != j`.

### Solution 1: No Sorting
Initially think we can't sort them because we need to meet `i < j`, so using `TreeMap` here.

**Time Complexity:** TreeMap insertion takes `O(logN)`, so total time is `O(N * logN)`.

**Space Complexity:** `O(N`.

### Solution 2: Sorting
**Time Complexity:** `O(N * logN)`.

**Space Complexity:** `O(1)`.

### Related
1: Two Sum.

167: Two Sum II - Input array is sorted.

170: Two Sum III - Data structure design.

653: Two Sum IV - Input is a BST.

1099: Two Sum Less Than K.

1679: Max Number of K-Sum Pairs.