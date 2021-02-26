# 269: Alien Dictionary

### Solution 1: Topological Sorting.
Two cases need to be addressed:

**Case 1**: `["abc", "ab]` is not a valid lexicographically order, so return empty string.

**Case 2**: Not all characters can be topological sorted. For example: `["x", "z", "t", "z"]`.

**Time Complexity:** `O(N)`. Let `N` is the total length of all the words combined, `Step 1` takes more time than other steps. Because in BFS, time complexity is usually `O(V + E)`, `V` is number of vertices, `E` is number of edges.

**Space Complexity:** `O(1)`. Because, these words only contains 26 characters.

### Solution 2: DFS.
Time Complexity and Space Complexity same as Solution 1.

### Related
207: Course Schedule.

210: Course Schedule II.

269: Alien Dictionary.