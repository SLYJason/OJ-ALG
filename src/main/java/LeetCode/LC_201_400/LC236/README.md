# 236: Lowest Common Ancestor of a Binary Tree

### Solution 1: Recursive
The idea is we are using recursion to find `p` and `q`. 

Whenever we find `root == p` or `root == q` we can return `root` to its parent meaning we have found a target `p` or `q`. If both not found, we return `null`. 

**Time Complexity:** `O(N)`.

**Space Complexity:** `O(N)`.

### Solution 2: Iterative
1. To find a LCA of `p` and `q`, we need to build a graph that the child nodes point to the parent node called `parent`. As long as find the `p` and `q`, exist the loop.
2. Go through all the ancestors of node `p`, build a set `ancestors` to store all `p` ancestors. Then LCA of `p` and `q` must exist in this `ancestors`.
3. Then go through all the ancestors of node `q`, as long as any ancestor of `q` exist in the `ancestors`, the LCA found.

**Time Complexity:** `O(N)`.

**Space Complexity:** `O(N)`.

### Related
235: Lowest Common Ancestor of a Binary Search Tree.

236: Lowest Common Ancestor of a Binary Tree.

1644: Lowest Common Ancestor of a Binary Tree II.

1650: Lowest Common Ancestor of a Binary Tree III.

1676: Lowest Common Ancestor of a Binary Tree IV.