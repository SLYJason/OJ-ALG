# 122: Best Time to Buy and Sell Stock II

### Solution 1: Monotonic Queue
**Time Complexity:** `O(N)`.

**Space Complexity:** `O(N)`.

### Solution 2: Two Pointers
The idea is continuous to find `local minimum` and `local_maximum`, so the `max_profit` will be sum of the difference between `local minimum` and `local_maximum`.

![chart1](LC122_Sol2.png)

**Time Complexity:** `O(N)`.

**Space Complexity:** `O(1)`.

### Solution 3: Greedy
From the chart, we can see `D = A + B + C`. `D` can be treated as `max_profit`.

![chart1](LC122_Sol3.png)

**Time Complexity:** `O(N)`.

**Space Complexity:** `O(1)`.

### Reference
[LeetCode-122](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/solution/).

### Related
121: Best Time to Buy and Sell Stock.

122: Best Time to Buy and Sell Stock II.

123: Best Time to Buy and Sell Stock III.

188: Best Time to Buy and Sell Stock IV.