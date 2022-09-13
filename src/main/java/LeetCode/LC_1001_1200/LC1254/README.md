# 1254: Number of Closed Islands

### Solution 1: DFS
It is an initial thought, similar to LC200 logic, instead traver the grid start from row 1 and col 1 because need to ignore the edges.

**Time Complexity:** `O(M * N)`. Given the M * N matrix.

**Space Complexity:** `O(M * N)`.

### Solution 2: Flood Fill
1. First flood fill the edges to convert 0(land) to 1(water) if any cell in the edge has 0(land).
2. Then iterate the rest of the grid to find out the number of closed islands, fill these closed islands on the fly.

**Time Complexity:** `O(M * N)`. Given the M * N matrix.

**Space Complexity:** `O(M * N)`.

### Related
200: Number of Islands.

286: Walls and Gates.

323: Number of Connected Components in an Undirected Graph.

542: 01 Matrix.

547: Number of Provinces.

694: Number of Distinct Islands.

695: Max Area of Island.

994: Rotting Oranges.

1091: Shortest Path in Binary Matrix.

1254: Number of Closed Islands.