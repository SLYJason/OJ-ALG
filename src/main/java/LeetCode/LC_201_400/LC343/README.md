# 343: Integer Break

### Solution 1: DP
`dp[i]` means the max product at integer `i`, where `i` can be broke into at least two integers. To get `dp[i]`, for any integer `j < i`:
```
j can be broke: dp[i] = dp[j] * (i - j);
j can not be broke: dp[i] = j * (i - j);

So dp[i] = max(dp[j] * (i - j), j * (i - j));
```
**Time Complexity:** `O(N)`.

**Space Complexity:** `O(N)`.

### Solution 2: Math
The key point is trying to break `n` to multiple 3 as much as possible, so use `num_3 = n / 3` to get how many 3 in `n`. Then to get the `reminder`, it has 3 situations:
* `reminder == 0`: `n` can be divided to multiple 3, so `max = Math.pow(3, num_3)`.
* `reminder == 1`: We need to extract 3 from `num_3` and combine 3 with reminder 1, so the combined value is 4. Then 4 can be divided to 2*2, so `max = Math.pow(3, num_3 - 1) * 4`.
* `reminder == 2`: We can just use the `reminder` as a break number, so `max = Math.pow(3, num_3) * reminder`.

Reference: [LeetCode-CN](https://leetcode-cn.com/problems/integer-break/solution/343-zheng-shu-chai-fen-tan-xin-by-jyd/).

**Time Complexity:** `O(1)`.

**Space Complexity:** `O(1)`.