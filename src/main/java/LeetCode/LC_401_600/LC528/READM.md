# 528: Random Pick with Weight

### Solution 1: Linear Search
The idea is we calculate the prefix sum `prefixSum` and total `weights` from input `w`. Then generate a random number from `weights`. Finally, scan the `prefixSum` as long as the generated random number is in the range of `prefixSum`, the index is found.
 
**Time Complexity:** construction takes `O(N)`, `pickIndex` takes `O(N)`.

**Space Complexity:** construction takes `O(N)`, `pickIndex` takes `O(1)`.

### Solution 2: Binary Search
Consider the input: `[2, 5, 3, 4]`. We get the prefixSum: `[2, 7, 10, 14]`. Then generate a random **integer** number `rand` in the range of `[0, 14]`.
```
rand in [1, 2], index = 0;
rand in [3, 7], index = 1;
rand in [8, 10], index = 2;
rand in [10, 14], index = 3;
```
**Time Complexity:** construction takes `O(N)`, `pickIndex` takes `O(logN)`.

**Space Complexity:** construction takes `O(N)`, `pickIndex` takes `O(1)`.

### Related
382: Linked List Random Node.

398: Random Pick Index.

528: Random Pick with Weight.
