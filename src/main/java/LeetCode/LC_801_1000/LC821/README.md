# 821: Shortest Distance to a Character

### Solution: Two-Way Pass
From `left -> right`, find the distance between left `prev` and current `c`. From `right -> left`, find the distance between right `prev` and current `c`, and `answer[i]` is minimum of two value.

**Time Complexity:** `O(N)`.

**Space Complexity:** `O(N)`.