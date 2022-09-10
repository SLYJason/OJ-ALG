# 593: Valid Square

### Solution: Sorting + Verify
Since the four points are given in any order, we should consider to determine the arrangement of these four points on a valid possible square boundary. 
Thus need to sort these points based on the x coordinates, if it has a tie, sort it based on y coordinates. 
Then the sorted p1 adjacent points are p2 and p3, p4 adjacent points are p2 and p3 too. Verify these two aspects:
1. Each side are equal and not 0.
2. Each diagonal are equal.

**Time Complexity:** `O(1)`.

**Space Complexity:** `O(1)`.