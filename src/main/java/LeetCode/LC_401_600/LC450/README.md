# 450: Delete Node in a BST

### Solution 1: brute force - NOT Recommended
First make inorder traversal of the BST and store the node value in a list but exclude the key. Then rebuild the BST based on the sorted list.

**Time Complexity:** `O(N)`. `N` is the total node of the BST.

**Space Complexity:** `O(N)`.

### Solution 2: In-Place Deletion
Core concepts about the BST.
1. Successor: "after node", i.e. the next node, or the smallest node after the current one. To find a successor, go to the **right** once and then as many times to the left as you could.
2. Predecessor: "before node", i.e. the previous node, or the largest node before the current one. To find a predecessor, go to the **left** once and then as many times to the right as you could.

There are 4 cases that the node contains the key may reside in the tree:
1. node is a leaf - return null.
2. node is not leaf and only has left child - return right subtree.
3. node is not leaf and only has right child - return left subtree.
4. node is not leaf and has both left and right child - find the minimum value in the right subtree, set that min value to the found node and recursively delete the min value node in the right subtree.

**Time Complexity:** `O(N)`. `N` is the total node of the BST.

**Space Complexity:** `O(1)`.
