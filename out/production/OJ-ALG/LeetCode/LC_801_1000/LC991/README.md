# 991: Broken Calculator

### Solution: Think Backwards
Instead of changing `X -> Y`, there has a lot of uncertainties, since every step we can either **Double** or **Decrement**. So we need to think backwards: `Y -> X`: 

* `Y` is even: `Y = Y / 2`.
* `Y` is odd: `Y = Y + 1`.

One thing to note is if `Y` is even, if we plus 1 to `Y`, then `Y` is odd, we need to plus another 1. And because `(Y + 1 + 1) / 2 = (Y / 2) + 1`, 3 operations are more than 2. So that's why we always do `Y / 2` when `Y` is even.

**Time Complexity:** `O(logY)`.

**Space Complexity:** `O(1)`.

