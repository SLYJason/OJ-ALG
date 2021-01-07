# 315: Count of Smaller Numbers After Self

### Solution 1: Binary Indexed Tree
There has 2 steps to solve this problem: **discretization** of the array and calculate the prefixSum using **BIT**. 

Overall logic is since we need to count the number of smaller elements to the right of `nums[i]`, we need to build a mapping: `rank` -> `frequency`. And then, traverse input array backwards to calculate the prefix sum of `rank_frequency` mapping using BIT strategy.

##### Discretization 
The value of the array is not matter, but the relative order matters, so we need to do discretization of the array. Given `[5, 2, 6, 1, 2]` we calculate each number's rank:
```
Input: [5, 2, 6, 1, 2] -> Sorted: [1, 2, 2, 5, 6]
        |  |  |  |  |
Rank:  [3, 2, 4, 1, 2] -> count unique number's rank
```

##### Calculate the Prefix Sum Using BIT
Then we use BIT strategy to calculate the prefix sum of the `rank_frequency`. We traverse input array in reverse order:
```
Reversed: [2, 1, 6, 2, 5], rank_frequency = [0, 0, 0, 0, 0]

 i | reversed[i] |  rank  |   rank_frequency   | prefix sum |
 0 |      2      |   2    |   [0, 0, 1, 0, 0]  |      0     |
 1 |      1      |   1    |   [0, 1, 1, 0, 0]  |      0     |
 2 |      6      |   4    |   [0, 1, 1, 0, 1]  |      2     |
 3 |      2      |   2    |   [0, 1, 2, 0, 1]  |      1     |
 4 |      5      |   3    |   [0, 1, 2, 1, 1]  |      3     |
```