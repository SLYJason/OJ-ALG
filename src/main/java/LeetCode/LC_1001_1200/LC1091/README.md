# 1091: Shortest Path in Binary Matrix

### Solution 1: BFS
This method modifying the input `0 -> 1` to mark visited cell, however it is not a good practice. We can use `visited` boolean array instead.

**Time Complexity:** `O(N^2)`.

**Space Complexity:** `O(N^2)`.

### Solution 2: Dijkstra Algorithm
**Time Complexity:** `O(N^2 * logN^2)`.

**Space Complexity:** `O(N^2)`.

### Solution 3: A* Search
At any node `n`, the cost is `f(n) = g(n) + h(n)`:
* `g(n)`: the exact cost of the path from the starting point to vertex `n`.
* `h(n)`: the **heuristic** estimated cost from vertex n to the goal.

To calculate the **heuristic**, we can either calculate the exact value of `h(n)` or approximate the value of `h(n)`.

To calculate Approximation Heuristics:

**Manhattan Distance**: when we are allowed to move only in four directions only.
```
h = abs(current_cell.x – goal.x) + abs(current_cell.y – goal.y);
```

**Diagonal Distance**: when we are allowed to move in eight directions only.
```
h = max(abs(current_cell.x – goal.x), abs(current_cell.y – goal.y));
```

**Euclidean Distance**: When we are allowed to move in any directions.
```
h = sqrt((current_cell.x – goal.x) ^ 2 + (current_cell.y – goal.y) ^ 2));
```

**Note**: Dijkstra is a special case of A* Search Algorithm, where h = 0 for all nodes.

**Reference:** [Geeksforgeeks-A* Search](https://www.geeksforgeeks.org/a-search-algorithm/).

**Time Complexity:** `O(N^2 * logN^2)`.

**Space Complexity:** `O(N^2)`.

### Related
200: Number of Islands.

286: Walls and Gates.

542: 01 Matrix.

694: Number of Distinct Islands.

695: Max Area of Island.

994: Rotting Oranges.

1091: Shortest Path in Binary Matrix.