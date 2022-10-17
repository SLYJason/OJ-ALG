# 10: Regular Expression Matching

### Solution: DP
`dp[i][j]`: `s` substring with length `i` matches `p` substring with length `j` or not.

Assuming for a given `s` substring with length `i` and `p` substring with length `j`, their corresponding characters at `i - 1` and `j - 1` are:
```
char ch1 = s.charAt(i - 1);
char ch2 = p.charAt(j - 1);
```
Several cases need to consider here:

- Case 1: `ch1 == ch2`, then `dp[i][j] = dp[i - 1][j - 1]`.
- Case 2: `ch2 == '.'`, then `dp[i][j] = dp[i - 1][j - 1]`.
- Case 3: `ch2 == '*'`, here we need to treat `p.charAt(j - 2)` plus `*` as a combo, for example: `a*`. Note `p.charAt(j - 2)` is character before `*`, i.e. means `a` here.
    - We can treat `*a` as empty here, so `dp[i][j] = dp[i][j - 2]`.
    - If `p.charAt(j - 2) == ch1` OR `p.charAt(j - 2) == '.'`, so `dp[i][j] = dp[i - 1][j]`, we allow `*a` repeat at least 1 times.

**Time Complexity:** `O(M * N)`, `M` is the length of `s`, `N` is the length of `p`. Because we are calculating every `dp[i][j]`.

**Space Complexity:** `O(M * N)`, we use a `dp` table.

### Related
10: Regular Expression Matching.

44: Wildcard Matching.