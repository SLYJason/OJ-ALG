# 573: Squirrel Simulation

### Solution 1: Brute Force
The idea is all `nuts` to `tree` need to have two-way paths. To minimize the distance, need to replace one `tree -> nut` path with the `squirrel -> nut` path. All need is to find the `min(tree -> nut, squirrel -> nut)`.

**Time Complexity:** `O(N)`.

**Space Complexity:** `O(1)`.

### Solution 2: Single Pass
Based on brute force solution, we want to find the max difference between `tree -> nut` and `squirrel -> nut` path.

**Time Complexity:** `O(N)`.

**Space Complexity:** `O(1)`.
