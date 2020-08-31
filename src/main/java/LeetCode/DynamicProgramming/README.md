# 0/1 Knapsack Problem
518 (Coin Change 2), 416 (Partition Equal Subset Sum).

# Best Time to Buy and Sell Stock
121 (Easy): no need DP, only permitted to complete at most one transaction.

122 (Easy): no need DP, complete as many transactions as you like.

# Word Break
139 (Medium): return true or false whether s is breakable.

140 (Hard): return all breakable list of s.

# Palindromic Substring

647 (Medium): `dp[i, j]` means `substring[i, j]` is a palindrome or not.
```
      0  1  2  3  4
i\j | a  b  b  a  c  
--------------------
0 a | T  F  F  T  F
1 b | F  T  T  F  F 
2 b | F  F  T  F  F
3 a | F  F  F  T  F
4 c | F  F  F  F  T
```
**Recurrence relations**: 
`dp[i, j] = dp[i+1, j-1] && s.charAt(i) == s.charAt(j)`.

Note: `i` is determined by `i+1`, so `i` goes decreasing order; `j` is determined by `j-1`, so `j` goes increasing order.