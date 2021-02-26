# 307: Range Sum Query - Mutable

### Solution 1: Segment Tree
A segment tree for `n` size array `nums` can be represented using an array of size `4 * n`.

A couple of important feature of segment tree are:
1. The `root` of segment tree is at index `0`, i.e. `segment_tree[0]`.
2. The left child of node `i` is `i*2+1`, the right child of node `i` is `i*2+2`.
3. For empty node, we can set it to `0` or `null`.

**Time Complexity:**
* `construction` takes `O(N)`.
* `update` takes `O(logN)`.
* `sumRange` takes `O(logN)`.

**Space Complexity:**
* `construction` takes `O(N)`.
* `update` takes `O(1)`.
* `sumRange` takes `O(1)`.

Reference: [Stack Overflow](https://stackoverflow.com/questions/28470692/how-is-the-memory-of-the-array-of-segment-tree-2-2-ceillogn-1).

### Solution 2: Binary Indexed Tree
**Time Complexity:**
* `construction` takes `O(N * logN)`.
* `update` takes `O(logN)`.
* `sumRange` takes `O(logN)`.

**Space Complexity:**
* `construction` takes `O(N)`.
* `update` takes `O(1)`.
* `sumRange` takes `O(1)`.

### Related
303: Range Sum Query - Immutable.

304: Range Sum Query 2D - Immutable.

307: Range Sum Query - Mutable.