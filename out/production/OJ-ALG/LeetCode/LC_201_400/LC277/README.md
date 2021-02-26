# 277: Find the Celebrity

### Solution: Two Pass
There has some hints in `knows(A, B)` API:
* If `knows(A, B) = true`: means `A` knows `B`, so `A` cannot be a celebrity, `B` can be a celebrity candidate.
* If `knows(A, B) = false`: means `A` does not know `B`, so `A` can be a celebrity candidate, `B` cannot be a celebrity.

So 1st pass will find a celebrity candidate, 2nd pass will check everyone except the candidate knows him and candidate does not know every one.

**Time Complexity:** `O(N)`.

**Space Complexity:** `O(1)`.

### FollowUp: Cache
It's exactly same solution, just add a cache logic since we are making redundant calls in 1st pass and 2nd pass.

**Time Complexity:** `O(N)`.

**Space Complexity:** `O(1)`.