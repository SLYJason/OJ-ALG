# 234: Palindrome Linked List

### Solution: O(1) Space Complexity
Why do we need to reduce to `O(1)` space complexity? Think about if we have limited memory space, the whole ListNode can't fit into memory, so we need `O(1)` space.

Another way to do is, we use two pointers called `slow` and `fast`. Move `slow` 1 step and move `fast` 2 step. When `fast` reach the end, `slow` is in the middle. So we can use `slow` to reverse the second half of list, then the rest logic is same.

**Time Complexity:** `O(N)`.

**Space Complexity:** `O(1)`.