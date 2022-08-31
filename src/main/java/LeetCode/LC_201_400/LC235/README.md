# 235: Lowest Common Ancestor of a Binary Search Tree

### Solution: Recursive
1. Start from the root node.
2. If both `p` and `q` are in the right subtree, the LCA must be in the right subtree and continue to search there. 
3. If both `p` and `q` are in the left subtree, the LCA must be in the left subtree and continue to search there.
4. If #2 and #3 not true, the current node is LCA and return it.

**Time Complexity:** `O(N)`.

**Space Complexity:** `O(N)`.

### Solution: Iterative
Traverse down the tree iteratively, just to find the split point that `p` and `q` won't be the same subtree or one is the parent of another.

**Time Complexity:** `O(N)`.

**Space Complexity:** `O(1)`.

### Related
235: Lowest Common Ancestor of a Binary Search Tree.

236: Lowest Common Ancestor of a Binary Tree.

1644: Lowest Common Ancestor of a Binary Tree II.

1650: Lowest Common Ancestor of a Binary Tree III.

1676: Lowest Common Ancestor of a Binary Tree IV.