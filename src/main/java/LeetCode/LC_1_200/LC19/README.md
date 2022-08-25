# 19: Remove Nth Node From End of List

### Solution 1: Two Pass
First pass find the total length `L` of the list, remove the Nth node from the end of list means remove the index `L-n` node from the beginning.
Then the second pass to is used to do this job.
**Time Complexity:** `O(L)`, `L` is the length of the list.

**Space Complexity:** `O(1)`.

### Solution 2: One Pass
Maintain two pointers with distance `n` then move both together.
**Time Complexity:** `O(L)`, `L` is the length of the list.

**Space Complexity:** `O(1)`.

