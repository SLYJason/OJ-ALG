# 72: Edit Distance

### Solution: DP
`dp[i][j]` means the edit distance between word1's length `i` and word2's length `j`.
There has 4 cases need to consider:
```
i == 0 && j == 0: 2 empty string edit distance is 0.
i == 0: word1 is empty, so edit distance is word2's length j.
j == 0: word2 is empty, so edit distance is word1's length i.
i != 0 && j != 0:
* if word1's last char is equal to word2's last char, then dp[i][j] = dp[i-1][j-1] because we don't need any edit.
* if not, we need to use 3 rules to edit:
    - insert word2's last char to word1: dp[i][j] = 1 + dp[i][j-1].
    - delete word1's last char: dp[i][j] = 1 + dp[i-1][j].
    - replace word1's last char: dp[i][j] = 1 + dp[i-1][j-1].
So overall: dp[i][j] = 1 + min(dp[i][j-1], dp[i-1][j], dp[i-1][j-1]).
```
**Time Complexity:** `O(m * n)`, `m` and `n` is the word1's length and word2's length respectively.

**Space Complexity:** `O(m * n)`.

### Related
72: Edit Distance.

161: One Edit Distance.