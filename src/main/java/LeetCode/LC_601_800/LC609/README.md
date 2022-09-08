# 609: Find Duplicate File in System

### Solution: HashMap
Build a map key -> content, value -> file dir path to find the duplicates.

**Time Complexity:** `O(M * N)`. `M` strings of average length `N`.

**Space Complexity:** `O(M * N)`.

### Follow Up
Q: Imagine you are given a real file system, how will you search files? DFS or BFS?

A: Depends. BFS explores neighbors first, this means the files are located to each other will be accessed first. 
   DFS will explore the current directory as far as it can, so it may cause some stack overflow problems.

Q: If the file content is very large (GB level), how will you modify your solution?

A: Compare the files size by size. Then hash the small part of the files and compare it. If both above cases pass, then compare byte by byte (be careful about the hash collision).

Q: What is the time complexity of your modified solution? What is the most time-consuming part and memory-consuming part of it? How to optimize?

A: It depends on how to interpret the file system structure. Most time-consuming and memory-consuming part is compare the files.

Q: If you can only read the file by 1kb each time, how will you modify your solution?

A: It does not change the solution, we can create hash of the 1kb chunks.

Q: How to make sure the duplicated files you find are not false positive?

A: We will use several filters to compare: File size, Hash and byte by byte comparisons.
