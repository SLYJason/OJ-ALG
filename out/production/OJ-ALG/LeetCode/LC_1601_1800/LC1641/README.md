# 1641: Count Sorted Vowel Strings

### Solution 1: DFS
For `0th` position:
```
If select a, next 1th position have 5 choices.
If select e, next 1th position have 4 choices.
If select i, next 1th position have 3 choices.
If select o, next 1th position have 2 choices.
If select u, next 1th position have 1 choices.
```
Similar we move to next `ith position`.

**Time Complexity:** `O(N^5)`. For length `n`, each position we have 5 choices.

**Space Complexity:** `O(N)`.

### Solution 2: DP
`dp[i][j]` means number of ways of using the first `j` vowels to get string with length `i`.
```
When j = 1: use u only.
When j = 2: use o, u only.
When j = 3: use i, o, u only.
When j = 4: use e, i, o, u only.
When j = 5: use a, e, i, o, u only.
```
**Time Complexity:** `O(N)`.

**Space Complexity:** `O(N)`.