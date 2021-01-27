# 1631: Path With Minimum Effort

### Solution 1: Dijkstra Algorithm
`efforts` array means the route from source `(0, 0)` to any cell `(i, j)`, the **effort** value. A route's **effort** is the **maximum absolute difference** in heights between two consecutive cells of the route. 

**Time Complexity:** `O(MN * log(MN))`. It takes `O(M * N)` time to visit every cell. The priority queue contains at most `M * N` entries, and it takes `O(log(M * N))` to insert a new entry. 

**Space Complexity:** `O(M * N)`.

### Solution 2: Binary Search + DFS
This solution is based on brute force. In brute force, we explore every possible path from source to destination, and then calculate each path effort to find the global minimum effort.

In this solution, based on `1 <= heights[i][j] <= 100,000`, we could use binary search to find the target minimum effort. So the possible minimum effort is 0, and the possible maximum effort is 100,000-1.

For each DFS iteration, we put a limit `mid` on each move, so we can make sure each cell is only be visited once.

**Time Complexity:** `O(M * N)`. Instead of like brute force, we visit each cell only once.

**Space Complexity:** `O(M * N)`.

### Related
1102: Path With Maximum Minimum Value.

1631: Path With Minimum Effort.