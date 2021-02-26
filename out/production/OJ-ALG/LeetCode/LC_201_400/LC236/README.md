# 236: Lowest Common Ancestor of a Binary Tree

### Solution: Recursion
The idea is we are using recursion to find `p` and `q`. 

Whenever we find `root == p` or `root == q` we can return `root` to its parent meaning we have found a target `p` or `q`. If both not found, we return `null`. 

**Time Complexity:** `O(N)`.

**Space Complexity:** `O(N)`.

### Related
235: Lowest Common Ancestor of a Binary Search Tree.

236: Lowest Common Ancestor of a Binary Tree.

1644: Lowest Common Ancestor of a Binary Tree II.

1650: Lowest Common Ancestor of a Binary Tree III.

1676: Lowest Common Ancestor of a Binary Tree IV.