# 57: Insert Interval

### Solution
1. Add the intervals to the output list before the `newInterval` start position.
2. Keep merging the interval as long as current interval start position is less than the `newInterval` end position.
3. Merge the rest of intervals.

**Time Complexity**: `O(N)`.

**Space Complexity**: `O(1)`.

### Related
56: Merge Intervals.

57: Insert Interval.

252: Meeting Rooms.

253: Meeting Rooms II.

616: Add Bold Tag in StringAdd Bold Tag in String.

758: Bold Words in String.