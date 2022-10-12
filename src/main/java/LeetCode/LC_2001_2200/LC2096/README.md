# 2096: Step-By-Step Directions From a Binary Tree Node to Another

### Solution: LCA + DFS
The shortest path from `startValue` to `destValue` can be break down into first find the longest common ancestor (LCA) of both node value, then shortest path can be represented as:
`shortest_path -> startValue -> LCA + LCA -> destValue`.

Worth to note here `startValue -> LCA` will be filled with all `U`, no `L` or `R`.

**Time Complexity:** `O(N)`. `N` is the number of nodes in binary tree.

**Space Complexity:** `O(N)`.
