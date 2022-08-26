# 98: Validate Binary Search Tree

### Solution 1: Brute Force InOrder
In order traversal to put node value into a list, then verify if the list is in ascending order.

**Time Complexity**: `O(N)`, `N` is the number of the nodes.

**Space Complexity**: `O(N)`.

### Solution 2: Optimization of Solution 1
Similar to solution_1 using inorder traversal but no need to store each element in a list.

**Time Complexity**: `O(N)`, `N` is the number of the nodes.

**Space Complexity**: `O(N)`.

### Solution 3: Recursive with Valid Range
Given any node of the tree, it must smaller than or bigger than any parent node which is defined as `lowerBound` or `upperBound`. If is not, then the tree is not a valid BST.

**Time Complexity**: `O(N)`, `N` is the number of the nodes.

**Space Complexity**: `O(N)`.
