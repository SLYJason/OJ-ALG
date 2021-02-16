# 784: Letter Case Permutation

### Solution 1: Backtrack
To toggle a letter, we use a trick here:
```
char toggle = (char)(c ^ (1 << 5));
```
For ASCII code: `A` is 65, `B` is 66,..., `Z` is 90. `a` is 97, `b` is 98,..., `z` is 122. By doing `XOR` operation, we will always flip this ASCII code binary's 5th bit which means `97 -> 65` or `65 -> 97`.

**Time Complexity:** `(2 ^ N)`, `N` is the length of `S`.

**Space Complexity:** `(2 ^ N)`.

### Solution 2: BFS
**Time Complexity:** `(2 ^ N)`, `N` is the length of `S`.

**Space Complexity:** `(2 ^ N)`.

### Related
17: Letter Combinations of a Phone Number.

784: Letter Case Permutation.
