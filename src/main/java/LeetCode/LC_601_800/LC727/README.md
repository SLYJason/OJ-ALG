# 727: Minimum Window Subsequence

### Solution: Two Pointers
The idea is using `s_idx` to traverse `S`, if we find a match between two string `s[s_idx] == t[t_idx]`, we just increase `t_idx`. Once `t_idx` reachs the end of the `T`, we are confirmed that we have found a matched subsequence `T` in `S`.

Then the next step is to go back to find the minimum matched length in `S`. Decrease `s_idx` and `t_idx` and once `t_idx == -1` we are sure that the match search is complete, so we can compute the matched length. Keep doing it so we can find the minimum length.

**Time Complexity:** `O(ST)`, `S` and `T` is the length of S and T respectively.

**Space Complexity:** `O(1)`.

### Related
76: Minimum Window Substring.

438: Find All Anagrams in a String.

567: Permutation in String.

727: Minimum Window Subsequence.