# 56: Merge Intervals

### Solution: Soring + Merge
Sorting the interval based on the start position, and then merge the interval based on the last interval start, end position.

**Time Complexity**: `O(N * log(N))`. Sorting takes `O(N * log(N))`.

**Space Complexity**: `O(1)`.

### Related
56: Merge Intervals.

57: Insert Interval.

252: Meeting Rooms.

253: Meeting Rooms II.

616: Add Bold Tag in StringAdd Bold Tag in String.

758: Bold Words in String.

1094: Car Pooling.