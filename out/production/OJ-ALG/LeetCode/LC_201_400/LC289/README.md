# 289: Game of Life

### Solution: In-Place
Initially, the board cell is either `0 (dead)` or `1 (live)` and these cells can become dead or live in next state, so we can define the following state transitions:
```
[2nd bit, 1st bit] = [next state, current state]

- 00  dead (next) <- dead (current): decimal value is 0.
- 01  dead (next) <- live (current): decimal value is 1.
- 10  live (next) <- dead (current): decimal value is 2.
- 11  live (next) <- live (current): decimal value is 3.
````
We can define the state transitions using decimal value `0, 1, 2, 3` to make the state change, and then change `2, 3` to its final `0 (dead)` or `1 (live)` state.

**Time Complexity:** `O(M*N)`.

**Space Complexity:** `O(1)`.

### Related
Both of them using matrix tricks.

73: Set Matrix Zeroes.

289: Game of Life.