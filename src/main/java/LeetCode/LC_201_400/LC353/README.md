# 353: Design Snake Game

### Solution: ArrayDeque + Set
ArrayDeque used to track the snake body, i.e. increased body length. Set also used to track the body but only for look up. 
Worth to note this condition `!body.getLast().equals(encoded)` is to make sure if the snake next move is hitting the tail which can be a valid move.

**Time Complexity:** `O(1)` for `move(direction)`.

**Space Complexity:** `O(M * N)`. `M` and `N` is the width and height of the game.
