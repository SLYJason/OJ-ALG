# 285: Inorder Successor in BST

### Solution: Iterative
Using BST properties: `left` < `root` < `right`. Compare `root` with `p` to determine we should go `left` or go `right`.

**Time Complexity:** `O(logN)`.

**Space Complexity:** `O(1)`.

### Follow Up
How to find the inorder predecessor in BST?

### Related
510: Inorder Successor in BST II.

285: Inorder Successor in BST.