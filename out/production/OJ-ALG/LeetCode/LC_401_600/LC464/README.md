# 464: Can I Win

### Solution: Backtrack + Memorization
Why need memorization? For example, if first pick `2` and second pick `3` the state will be `[2,3]`, but there has some situations that first pick `3` and second pick `2`, so this state is `[3,2]`. `[2,3]` and `[3,2]` share same state, so need memorization.

Map structure: `K` -> `state: each number picked is labled with 1, if not, lable it with 0`, `V` -> `after the state, any player can win or not in next pick`.

**Time Complexity:** `O(2^N)`. Without memorization, the time complexity is `O(N!)`, `N` is `maxChoosableInteger`. Because we need `N` numbers permutations and check every permutation that the first player can win. With memorization, it's a combination problem now. Because for each number, we can choose it or not, so it becomes `O(2^N)`.

**Space Complexity:** `O(N)`. 