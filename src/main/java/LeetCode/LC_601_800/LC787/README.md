# 787: Cheapest Flights Within K Stops

### Solution 1: DFS
Brute force logic, start from `src` and find all available path to `dst`, calculating the minimum cost as much as we can. An important thing need to note here is we have to **pruning**, see code comments.

**Time Complexity:** `O(N^K)`. In the worse case, for a dense graph, we have to visit `N` nodes each step, total steps is `K`.

**Space Complexity:** `O(K)`, recursion space is up to `K`.

### Solution 2: Dijkstra Algorithm
**Time Complexity:** `O(V * logV)`, `V` is the number of cities.

**Space Complexity:** `O(V)`.