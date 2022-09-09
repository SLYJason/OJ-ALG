# 616: Add Bold Tag in String

### Solution: Greedy
Similar to merge intervals, we need to keep find the longest match word in the current index `i`.

The reason use the max here because the previous index may already match the word, which means that `i + word.length()` may already bigger than the current index match.
```
j = Math.max(j, i + word.length()); 
```
Example: 
```
"aaabbcc"
["aaa","aab","bc","aaabbcc"]
```
At index 0, "aaabbcc" match the whole string so the `j` will be assigned to 7. Then at index 1, there has "aaa" match, if no max so the `j` will be assigned to a smaller value 3. So that is not true.

**Time Complexity**: `O(N)`.

**Space Complexity**: `O(1)`.

### Related
56: Merge Intervals.

57: Insert Interval.

252: Meeting Rooms.

253: Meeting Rooms II.

616: Add Bold Tag in StringAdd Bold Tag in String.

758: Bold Words in String.