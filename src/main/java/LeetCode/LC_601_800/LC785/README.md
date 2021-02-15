# 785: Is Graph Bipartite?

### Solution 1: BFS
Assign each node with a different set:
* 0: not assigned to any set.
* 1: assign to A set.
* 2: assign to B set.

**Time Complexity:** `O(V + E)`.

**Space Complexity:** `O(N)`, `N` is the number of nodes.

### Solution 2: DFS
Same logic as BFS.

**Time Complexity:** `O(V + E)`.

**Space Complexity:** `O(N)`, `N` is the number of nodes.

### Related
785: Is Graph Bipartite?

886: Possible Bipartition.

