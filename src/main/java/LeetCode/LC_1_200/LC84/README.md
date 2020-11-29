# 84: Largest Rectangle in Histogram
 
### Solution 1: Brute Force
For each `height[i]`, go right direction to find `min_height`, in the meantime update the `max_area`. 

**Time Complexity:** `O(N ^ 2)`.
 
**Space Complexity:** `O(1)`.

### Solution 2: Monolithic Stack
Consider at given `height[i]`, the max area determined by `height[i]` is we have to find left most `height[left]` and right most `height[right]` that meets:
```
height[left] < height[i] < height[right], left < i < right.
``` 
So using a monolithic increasing stack, when we at index `i`, if `heights[stack.peek()] > heights[i]` we find the right boundary, so we can use `i` and `stack.peek()` to calculate the width and then get its max area.

The reason to push `-1` to the stack at the beginning: `-1` is as **sentinel**, so we don't need to empty check of the stack.

**Time Complexity:** `O(N)`.
 
**Space Complexity:** `O(N)`.

### Related
84: Largest Rectangle in Histogram.

85: Maximal Rectangle.