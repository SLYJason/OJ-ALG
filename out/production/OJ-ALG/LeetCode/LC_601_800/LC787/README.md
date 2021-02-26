# 787: Cheapest Flights Within K Stops

### Solution 1: DFS
Brute force logic, start from `src` and find all available path to `dst`, calculating the minimum cost as much as we can. An important thing need to note here is we have to **pruning**, see code comments.

**Time Complexity:** `O(N^K)`. In the worse case, for a dense graph, we have to visit `N` nodes each step, total steps is `K`.

**Space Complexity:** `O(K)`, recursion space is up to `K`.

### Solution 2: Dijkstra Algorithm
**Time Complexity:** `O(V * logV)`, `V` is the number of cities.

**Space Complexity:** `O(V)`.

### Solution 3: Bellman-Ford (DP)
**Edge Relaxation:** For a given edge `U -> V`, if `d(U) + W(U, V) < d(V)`, we update `d(V) = d(U) + W(U, V)`. We have to do `V - 1` times, where `V` is the number of vertices.

After the first iteration over all the vertices, the algorithm finds out all the shortest paths from the source to nodes which can be reached with **one hop (one edge)**.

**Time Complexity:** `O(K * E)`, `E` is the number of edges.

**Space Complexity:** `O(V)` or `O(N)`, `V` is the number of cities.