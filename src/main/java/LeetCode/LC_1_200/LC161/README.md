# 161: One Edit Distance

### Solution
The question is asking transfer `s` to `t`. Making `s` shorter than `t`, we can only consider two cases: **insert** and **replace**. 

There has 2 base cases that can return false immediately:
* `s` is equal to `t`.
* `s` length + 1 < `t` length.

**Time Complexity:** `O(min(m, n))`, `m` and `n` is the `s` length and `t` length respectively.

**Space Complexity:** `O(1)`.

### Related
72: Edit Distance.

161: One Edit Distance.