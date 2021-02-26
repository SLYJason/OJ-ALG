# Maximum Product of Subsequence of Size K

Given an array A[] of n integers, the task is to find a subsequence of size k whose product is maximum among all possible k sized subsequences of the given array.

Constraint:
```
1 <= n <= 10^5
1 <= k <= n
```

Example 1:
```
Input: A[] = {1, 2, 0, 3}, k = 2
Output: 6

Explanation: Subsequence containing elements {2, 3} gives maximum product: 2 * 3 = 6.
```

Example 2:
```
Input: A[] = {1, 2, -1, -3, -6, 4}, k = 4
Output: 144

Explanation : Subsequence containing {2, -3, -6, 4} gives maximum product : 2 * (-3) * (-6) * 4 = 144.
```

Reference: [GeeksforGeeks](https://www.geeksforgeeks.org/maximum-product-subsequence-size-k/).