# 191: Number of 1 Bits

### Solution 1: Using Mask
The idea is check each `ith` bit of the number `n`. A logical **AND** between `ith` bit, and the mask 1 can tell `ith` bit is 1 or not.

**Time Complexity:** `O(1)`.

**Space Complexity:** `O(1)`.

### Solution 2: Bit Manipulation Trick
Instead of checking every bit of the number, we repeatedly flip the least significant 1-bit of the number to 0, and add 1 to the count. As soon as the number becomes 0, we know that it does not have anymore 1-bits, and we return the count.

**Important**: `n & (n - 1)` will flip `n` least significant 1-bit.

**Time Complexity:** `O(1)`.

**Space Complexity:** `O(1)`.