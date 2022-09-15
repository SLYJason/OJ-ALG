# 138: Copy List with Random Pointer

### Solution 1: HashMap
Using a HashMap to store `original -> copy` pair. 1st iteration copy each node one by one (same as copy LinkedList), 2nd iteration link the random node.

**Time Complexity:** `O(N)`.

**Space Complexity:** `O(N)`.

### Solution 2: O(1) Space
The optimized algorithm is:
1. 1st iteration create the copied node right after each node.
2. 2nd iteration link the random node.
3. 3rd iteration link the copied next node and recover the original list.

**Time Complexity:** `O(N)`.

**Space Complexity:** `O(1)`.

### Related
133: Clone Graph.

138: Copy List with Random Pointer.
