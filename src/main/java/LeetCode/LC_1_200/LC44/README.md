# 44: Wildcard Matching

### Diff with LC44
LC10: `*` matches zero or more of the preceding element.
LC44: `*` matches any sequence of characters (including the empty sequence).

### Solution 1: DP
Similar to LC10, `dp[i][j]`: `s` substring with length `i` matches `p` substring with length `j` or not.

Assuming for a given `s` substring with length `i` and `p` substring with length `j`, their corresponding characters at `i - 1` and `j - 1` are:
```
char ch1 = s.charAt(i - 1);
char ch2 = p.charAt(j - 1);
```

- Case 1: `ch1 == ch2`, then `dp[i][j] = dp[i - 1][j - 1]`.
- Case 2: `ch2 == '?'`, then `dp[i][j] = dp[i - 1][j - 1]`.
- Case 3: `ch2 == '*'`, since `*` can match any sequence characters includes the empty sequence, for example `*` matches `abc`. `dp[i][j] = dp[i][j - 1] || dp[i - 1][j]` is the recurrence relation. `dp[i][j - 1]` means don't use `*` so `dp[i][j] = dp[i][j - 1]`. `dp[i - 1][j]` means use `*` so `dp[i][j] = dp[i - 1][j]`.

Worth to note for the base case: 
- `dp[0][0] = true`: empty `s` and `p` are match.
- `dp[i][0] = false`: empty `p` not match anything to `s`.
- `dp[0][j] = true`: since `*` can match sequence of characters or empty sequence, as long as the previous `j` all is `*`, `dp[0][j] = true`.

**Time Complexity:** `O(M * N)`, `M` is the length of `s`, `N` is the length of `p`. Because we are calculating every `dp[i][j]`.

**Space Complexity:** `O(M * N)`, we use a `dp` table.

### Solution 2: Two Pointers
**Time Complexity:** `O(max(M, N))`.

**Space Complexity:** `O(1)`.

### Related
10: Regular Expression Matching.

44: Wildcard Matching.