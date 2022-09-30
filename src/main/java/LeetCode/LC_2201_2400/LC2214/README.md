# 2214: Minimum Health to Beat Game

### Solution: One Pass
There are 2 cases need to handle:
1. Any `damage[i]` is lowers than the `armor`. Thus, to optimize the armor, we should use armor to protect the `max(damage[i])`, i.e. the needed health would be `total_damages - max_damage + 1`.
2. `armor` is lower than the max `damage[i]`. In this case, the needed health will be `total_damages - armor + 1`.

**Time Complexity:** `O(N)`.

**Space Complexity:** `O(1)`.
