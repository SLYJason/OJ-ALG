# 48: Rotate Image

### Solution 1: Transpose + Reverse Column (Left -> Right)
Given image:
```
[1,  2,  3,  4]
[5,  6,  7,  8]
[9,  10, 11, 12]
[13, 14, 15, 16]
```
1st **transpose** based on the diagonal, it becomes:
```
[1,  5,  9,  13]
[2,  6,  10, 14]
[3,  7,  11, 15]
[4,  8,  12, 16]
```
2nd **reverse** the column:
```
[13, 9,  5, 1]
[14, 10, 6, 2]
[15, 11, 7, 3]
[16, 12, 8, 4]
```
**Time Complexity:** `O(N ^ 2)`.

**Space Complexity:** `O(1)`.

### Solution 2: Reverse Row (Top -> Down) + Transpose
Solution 2 is same as Solution 1 technically.

**Time Complexity:** `O(N ^ 2)`.

**Space Complexity:** `O(1)`.

### Follow Up 1: Rotate Anti-Clockwise
1st transpose then reverse row (top -> down).

### Follow Up 2: Rotate Rectangle
Rotate rectangle may not be solved by **in-place** because image with `M * N` becomes `N * M`, i.e. the array size get changed.