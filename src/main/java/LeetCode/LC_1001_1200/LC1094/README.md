# 1094: Car Pooling

### Solution 1: PriorityQueue
Similar to LC253, using a priority queue.

**Time Complexity:** `O(N * logN)`. `N` is the size of `trips`.

**Space Complexity:** `O(N)`.

### Solution 2: TreeMap
Get the total number of passengers in each start and end timestamp, and sort the timestamp in ascending order, so can use tree map here. 
Go over the tree map, as long as at any given timestamp, the total passenger is bigger than the capacity, return false. If not return true.

**Time Complexity:** `O(N * logN)`.

**Space Complexity:** `O(N)`.

### Related
56: Merge Intervals.

57: Insert Interval.

252: Meeting Rooms.

253: Meeting Rooms II.

616: Add Bold Tag in StringAdd Bold Tag in String.

758: Bold Words in String.

1094: Car Pooling.